package com.cube.webadmin.vo;

/**
 * @author tututu
 * @description
 * @date 2019/9/9 23:43
 * @email 289911401@qq.com
 * @since V1.0.0
 */
public interface SecurityConstant {

    /**
     * token分割
     */
    String TOKEN_SPLIT = "Bearer ";

    /**
     * JWT签名加密key
     */
    String JWT_SIGN_KEY = "item";

    /**
     * token参数头
     */
    String HEADER = "accessToken";

    /**
     * 权限参数头
     */
    String AUTHORITIES = "authorities";

    /**
     * 用户选择JWT保存时间参数头
     */
    String SAVE_LOGIN = "saveLogin";
}
