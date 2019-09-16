package com.cube.webadmin.dao;

import com.cube.webadmin.po.TRole;
import com.cube.webadmin.po.TUserRole;
import com.cube.webadmin.utils.MyMapper;

import java.util.List;

public interface TUserRoleMapper extends MyMapper<TUserRole> {
    /**
     * 获取userId用户所拥有的权限
     * @param userId
     * @return
     */
    List<TRole> findByUserId(String userId);

}