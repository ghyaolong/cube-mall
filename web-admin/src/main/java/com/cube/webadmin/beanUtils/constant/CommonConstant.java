package com.cube.webadmin.beanUtils.constant;

/**
 * @author tututu
 * @description
 * @date 2019/9/9 23:54
 * @email 289911401@qq.com
 * @since V1.0.0
 */
public interface CommonConstant {

    /**
     * 用户默认头像
     */
    String USER_DEFAULT_AVATAR = "https://s1.ax1x.com/2018/05/19/CcdVQP.png";

    /**
     * 用户正常状态
     */
    Integer USER_STATUS_NORMAL = 0;

    /**
     * 用户禁用状态
     */
    Integer USER_STATUS_LOCK = -1;

    /**
     * 普通用户
     */
    Integer USER_TYPE_NORMAL = 0;

    /**
     * 管理员
     */
    Integer USER_TYPE_ADMIN = 1;

    /**
     * 性别男
     */
    Integer SEX_MAN = 0;

    /**
     * 性别女
     */
    Integer SEX_WOMAN = 1;

    /**
     * 性别保密
     */
    Integer SEX_SECRET = 2;

    /**
     * 正常状态
     */
    Integer STATUS_NORMAL = 0;

    /**
     * 禁用状态
     */
    Integer STATUS_DISABLE = -1;

    /**
     * 删除标志
     */
    Integer DEL_FLAG = 1;

    /**
     * 限流标识
     */
    String LIMIT_ALL = "XBOOT_LIMIT_ALL";

    /**
     * 页面类型权限
     */
    Integer PERMISSION_PAGE = 0;

    /**
     * 操作类型权限
     */
    Integer PERMISSION_OPERATION = 1;

    /**
     * 1级菜单
     */
    String PARENT_ID = "0";

    /**
     * 1级菜单
     */
    Integer LEVEL_ONE = 1;

    /**
     * 2级菜单
     */
    Integer LEVEL_TWO = 2;

    /**
     * 3级菜单
     */
    Integer LEVEL_THREE = 3;

    /**
     * 调用方法成功
     */
    Integer EXECUTE_SUCCESS = 0;

    /**
     * 调用方法失败,有异常
     */
    Integer EXECUTE_FAILD = 1;

    /**
     * 未上传
     */
    Integer FILE_UNUPLOAD = 0;
    /**
     * 已上传
     */
    Integer FILE_UPLOADED = 1;

    Integer PRE_FILE_UPLOAD= 0;

    Integer PRE_FILE_UPLOADED = 1;


    Integer UPLOAD_TAX = 0;

    Integer UPLOAD_TAX_DETAIL = 1;

    String FILE_SIZE="fileSize";
    String FILE_TYPE="fileType";



    String USER_TAXATION="taxationIds";
    String USER_REVIEWS="reviewerIds";
    String USER_VIEWS ="viewerIds";

    String ROLE_ADMIN_NAME = "ROLE_ADMIN";
}
