package com.cube.webadmin.dao;

import com.cube.webadmin.po.TPermission;
import com.cube.webadmin.utils.MyMapper;

import java.util.List;

public interface TPermissionMapper extends MyMapper<TPermission> {

    List<TPermission> findByUserId(String userId);
}