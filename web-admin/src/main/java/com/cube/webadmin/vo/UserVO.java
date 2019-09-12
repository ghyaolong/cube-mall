package com.cube.webadmin.vo;

import lombok.Data;

import java.util.List;

/**
 * @author tututu
 * @description
 * @date 2019/9/9 22:05
 * @email 289911401@qq.com
 * @since V1.0.0
 */
@Data
public class UserVO {

    private String id;

    private String address;

    private String avatar;

    private String description;

    private String email;

    private String mobile;

    private String nickName;

    private String password;

    private String sex;

    private Integer status;

    private Integer type;

    private String username;

    private Integer delFlag;

    private String departmentId;

    private String street;

    private String passStrength;

    private String salt;

    private List<RoleVO> roles;

    private String roleIds;

    private List<PermissionVO> permissions;

    private String permissionsIds;
}
