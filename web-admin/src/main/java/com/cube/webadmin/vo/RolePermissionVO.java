package com.cube.webadmin.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author tututu
 * @description
 * @date 2019/9/9 22:07
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@Data
public class RolePermissionVO {

    private String id;

    private String createBy;

    private Date createTime;

    private Integer delFlag;

    private String updateBy;

    private Date updateTime;

    private String permissionId;

    private String roleId;
}
