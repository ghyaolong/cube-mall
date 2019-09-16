package com.cube.webadmin.service.impl;
import com.cube.webadmin.beanUtils.MyBeanUtils;
import com.cube.webadmin.dao.TRolePermissionMapper;
import com.cube.webadmin.po.TRolePermission;
import com.cube.webadmin.service.RolePermissionService;
import com.cube.webadmin.vo.RolePermissionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description: 角色-权限服务类
 * @Date: Created in 20:44 2018/10/25
 * @Author: yaochenglong
 */
@Slf4j
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    @Autowired
    private TRolePermissionMapper tRolePermissionMapper;

    @Override
    public List<RolePermissionVO> findByPermissionId(String permissionId) {
        Example example = new Example(TRolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("permissionId",permissionId);
        List<TRolePermission> tRolePermissionList = tRolePermissionMapper.selectByExample(example);
        List<RolePermissionVO> rolePermissionVoList = MyBeanUtils.copyList(tRolePermissionList, RolePermissionVO.class);
        return rolePermissionVoList;
    }

    @Override
    public void deleteByRoleId(String roleId) {
        log.info("删除角色-权限，入参roleId="+roleId);
        Example example = new Example(TRolePermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleId",roleId);
        tRolePermissionMapper.deleteByExample(example);
        log.info("删除角色-权限成功");
    }
}
