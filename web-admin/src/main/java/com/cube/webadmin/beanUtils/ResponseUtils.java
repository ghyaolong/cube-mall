package com.cube.webadmin.beanUtils;

import com.alibaba.fastjson.JSON;
import com.cube.mall.model.Message;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author tututu
 * @description
 * @date 2019/9/9 23:09
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@Slf4j
public class ResponseUtils {
    /**
     *  使用response输出JSON
     * @param response
     * @param resultMap
     */
    public static void out(ServletResponse response, Map<String, Object> resultMap){

        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            //out.println(new Gson().toJson(resultMap));
            out.println(JSON.toJSONString(resultMap));
        } catch (Exception e) {
            log.error(e + "输出JSON出错");
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }

    public static void out(ServletResponse response, Message message){

        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(message));
        } catch (Exception e) {
            log.error(e + "输出JSON出错");
        }finally{
            if(out!=null){
                out.flush();
                out.close();
            }
        }
    }



    public static Map<String, Object> resultMap(boolean flag, Integer code, String msg){

        Map<String, Object> resultMap = new HashMap <String, Object>();
        resultMap.put("success", flag);
        resultMap.put("message", msg);
        resultMap.put("code", code);
        resultMap.put("timestamp", System.currentTimeMillis());
        return resultMap;
    }

    public static Map<String, Object> resultMap(boolean flag, Integer code, String msg, Object data){

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("success", flag);
        resultMap.put("message", msg);
        resultMap.put("code", code);
        resultMap.put("timestamp", System.currentTimeMillis());
        resultMap.put("result", data);
        return resultMap;
    }
}
