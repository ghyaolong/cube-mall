package com.cube.webadmin.aop;

import com.alibaba.fastjson.JSON;
import com.cube.utils.ThreadPoolUtil;
import com.cube.webadmin.annotation.SystemLog;
import com.cube.webadmin.beanUtils.IpInfoUtil;
import com.cube.webadmin.config.security.CurrentUserUtils;
import com.cube.webadmin.service.LogInfoService;
import com.cube.webadmin.vo.LogInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Description: Spring AOP实现日志管理
 * @Date: Created in 9:09 2018/11/7
 * @Author: yaochenglong
 */
@Aspect
@Component
@Slf4j
public class SystemLogAspect {

    private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<Date>("ThreadLocal beginTime");

    @Autowired
    private LogInfoService logInfoService;

    @Autowired(required = false)
    private HttpServletRequest request;

    @Autowired
    private IpInfoUtil ipInfoUtil;

    @Autowired
    private CurrentUserUtils currentUserUtils;

    /**
     * Controller层切点,注解方式
     */
    //@Pointcut("execution(* *..controller..*Controller*.*(..))")
    @Pointcut("@annotation(com.cube.webadmin.aop.SystemLog)")
    public void controllerAspect() {

    }

    /**
     * 前置通知 (在方法执行之前返回)用于拦截Controller层记录用户的操作的开始时间
     *
     * @param joinPoint 切点
     * @throws InterruptedException
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) throws InterruptedException {

        //线程绑定变量（该数据只有当前请求的线程可见）
        Date beginTime = new Date();
        beginTimeThreadLocal.set(beginTime);
    }


    /**
     * 后置通知(在方法执行之后返回) 用于拦截Controller层操作
     *
     * @param joinPoint 切点
     */
    @After("controllerAspect()")
    public void after(JoinPoint joinPoint) {
        try {
            String username = currentUserUtils.getUserName();
            //String username = "admin";
            if (StringUtils.isNotBlank(username)) {
                StringBuffer sb = new StringBuffer();
                // 参数值
                Object[] args = joinPoint.getArgs();
                // 参数名
                String[] argNames = ((MethodSignature)joinPoint.getSignature()).getParameterNames();
                for (int i = 0; i < args.length; i++) {
                    sb.append(JSON.toJSON(argNames[i])).append("=");
                    sb.append(args[i].toString());
                    sb.append(";");
                }
                String paramData = "";
                if(StringUtils.isNotEmpty(sb)){
                    paramData = sb.substring(0,sb.length()-1);
                }
                //log.info("参数名称列表："+JSON.toJSONString(argNames));
                //log.info("输入参数列表:"+JSON.toJSONString(args));
                log.info("参数："+paramData);
                Signature signature = joinPoint.getSignature();
                String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
                String methodName = declaringTypeName+"."+signature.getName();
                LogInfoVO logInfoVo = new LogInfoVO();
                logInfoVo.setCreator(username);
                //日志标题
                logInfoVo.setMethod(getControllerMethodDescription(joinPoint));
                logInfoVo.setMethodCode(methodName);
                //操作时间
                logInfoVo.setOperationTime(new Date());
                //请求参数
                //Map<String, String[]> logParams = request.getParameterMap();
                logInfoVo.setParam(paramData);
                //请求用户
                logInfoVo.setUsername(username);
                //请求IP
                logInfoVo.setIp(ipInfoUtil.getIpAddr(request));
                //请求开始时间
                /*Date logStartTime = beginTimeThreadLocal.get();
                long beginTime = beginTimeThreadLocal.get().getTime();
                long endTime = System.currentTimeMillis();
                //请求耗时
                Long logElapsedTime = endTime - beginTime;*/
                //调用线程保存至ES
                ThreadPoolUtil.getPool().execute(new SaveSystemLogThread(logInfoVo, logInfoService));
            }

        } catch (Exception e) {
            log.error("AOP后置通知异常", e);
        }
    }


    /**
     * 保存日志至数据库
     */
    private static class SaveSystemLogThread implements Runnable {

        private LogInfoVO logInfoVo;
        private LogInfoService logInfoService;

        public SaveSystemLogThread(LogInfoVO logInfoVo, LogInfoService logInfoService) {
            this.logInfoVo = logInfoVo;
            this.logInfoService = logInfoService;
        }
        @Override
        public void run() {
            logInfoService.add(logInfoVo);
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {

        //获取目标类名
        String targetName = joinPoint.getTarget().getClass().getName();
        //获取方法名
        String methodName = joinPoint.getSignature().getName();
        //获取相关参数
        Object[] arguments = joinPoint.getArgs();
        //生成类对象
        Class targetClass = Class.forName(targetName);
        //获取该类中的方法
        Method[] methods = targetClass.getMethods();

        String description = "";

        for (Method method : methods) {
            if (!method.getName().equals(methodName)) {
                continue;
            }
            Class[] clazzs = method.getParameterTypes();
            if (clazzs.length != arguments.length) {
                //比较方法中参数个数与从切点中获取的参数个数是否相同，原因是方法可以重载哦
                continue;
            }
            description = method.getAnnotation(SystemLog.class).description();
        }
        return description;
    }
}
