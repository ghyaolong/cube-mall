package com.cube.webadmin.config.security.jwt;
import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.model.ResponseUtil;
import com.cube.webadmin.beanUtils.ResponseUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * @author tututu
 * @description
 * @date 2019/9/9 23:50
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@Slf4j
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        ResponseUtils.out(httpServletResponse, ResponseUtil.responseBody(ExceptionCode.HAS_NO_PERMISSION.getCode(),ExceptionCode.HAS_NO_PERMISSION.getMsg()));
    }
}
