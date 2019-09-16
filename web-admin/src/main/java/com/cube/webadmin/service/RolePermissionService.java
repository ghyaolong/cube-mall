package com.cube.webadmin.service;

import com.cube.webadmin.vo.RolePermissionVO;

import java.util.List;

/**
 * @Description: 角色权限服务类
 * @Date: Created in 20:43 2018/10/25
 * @Author: yaochenglong
 */
public interface RolePermissionService {
    /**
     * 通过permissionId获取
     * @param permissionId
     * @return
     */
    List<RolePermissionVO> findByPermissionId(String permissionId);

    /**
     * 通过roleId删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}
