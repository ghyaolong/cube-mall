package com.cube.webadmin.vo;

import org.springframework.security.authentication.InternalAuthenticationServiceException;

/**
 * @author tututu
 * @description
 * @date 2019/9/9 23:39
 * @email 289911401@qq.com
 * @since V1.0.0
 */
public class LoginFailLimitException extends InternalAuthenticationServiceException {

    private String msg;

    public LoginFailLimitException(String msg){
        super(msg);
        this.msg = msg;
    }

    public LoginFailLimitException(String msg, Throwable t) {
        super(msg, t);
        this.msg = msg;
    }
}
