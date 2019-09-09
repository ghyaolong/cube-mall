package com.cube.webadmin.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author tututu
 * @description
 * @date 2019/9/9 22:06
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@Data
public class RoleVO {
    private String id;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String name;

    private Integer delFlag;

    private Boolean defaultRole;

    private String description;

    private Integer dataType;
}
