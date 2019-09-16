package com.cube.webadmin.service;
import com.cube.mall.model.PageVO;
import com.cube.webadmin.vo.RoleVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description: 角色管理
 * @Date: Created in 20:02 2018/10/23
 * @Author: yaochenglong
 */

public interface RoleService {

    /**
     * 获取所有角色
     * @return
     */
    List<RoleVO> getAll();

    /**
     * 通过id查找
     * @param id
     * @return
     */
    RoleVO getById(String id);

    /**
     * 添加角色
     * @param roleVo
     */
    void addRole(RoleVO roleVo);

    /**
     * 分页查找所有角色
     * @param vo
     * @return
     */
    PageInfo<RoleVO> findAllByPage(PageVO<RoleVO> vo);


    /**
     * 修改角色
      * @param roleVo
     */
    void editRole(RoleVO roleVo);


    /**
     * 删除角色
     * @param id
     */
    void delById(String id);

    void delRolePermission(String roleId);

    void assignPermission(String roleId, String permissionIds);


}
