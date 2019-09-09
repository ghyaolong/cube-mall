package com.cube.webadmin.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 角色菜单VO
 * @Date: Created in 18:35 2018/10/24
 * @Author: yaochenglong
 */

@Data
public class RoleMenuVO {

    private String id;

    private String roleId;

    private String menuId;

    private String creator;

    private Date createTime;

    private Integer isDel;

    private Date delTime;
}
