package com.cube.webadmin.service.impl;
import com.cube.IDGeneratorUtils;
import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.exception.BizException;
import com.cube.mall.model.PageVO;
import com.cube.webadmin.beanUtils.MyBeanUtils;
import com.cube.webadmin.dao.TPermissionMapper;
import com.cube.webadmin.dao.TRoleMapper;
import com.cube.webadmin.dao.TRolePermissionMapper;
import com.cube.webadmin.po.TPermission;
import com.cube.webadmin.po.TRole;
import com.cube.webadmin.po.TRolePermission;
import com.cube.webadmin.service.RoleService;
import com.cube.webadmin.vo.PermissionVO;
import com.cube.webadmin.vo.RoleVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description: 角色管理实现类
 * @Date: Created in 20:30 2018/10/23
 * @Author: yaochenglong
 */

@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private TRoleMapper tRoleMapper;
    @Autowired
    private TRolePermissionMapper tRolePermissionMapper;
    @Autowired
    private TPermissionMapper tPermissionMapper;

    /**
     * 获取所有角色
     * @return
     */
    @Override
    public List<RoleVO> getAll() {
        List<TRole> tRoles = tRoleMapper.selectAll();
        List<RoleVO> roleVoList = MyBeanUtils.copyList(tRoles, RoleVO.class);
        return roleVoList;
    }

    @Override
    public RoleVO getById(String id) {
        TRole tRole = tRoleMapper.selectByPrimaryKey(id);
        RoleVO roleVo = new RoleVO();
        BeanUtils.copyProperties(tRole,roleVo);
        return roleVo;
    }
    /**
     * 分页查找所有角色
     * @param pageVo
     * @return
     */
    @Override
    public PageInfo<RoleVO> findAllByPage(PageVO<RoleVO> pageVo){
        RoleVO vo = pageVo.getT();
        PageHelper.startPage(pageVo.getPageNum(),pageVo.getPageSize());
        Example example = new Example(TRole.class);
        example.setOrderByClause("create_time");
        if(vo!=null){
            Example.Criteria criteria = example.createCriteria();
            criteria.andLike("name",vo.getName());
        }
        List<TRole> tRoles = tRoleMapper.selectByExample(example);
        List<RoleVO> roleVoList = MyBeanUtils.copyList(tRoles, RoleVO.class);
        for (RoleVO roleVo : roleVoList) {
            List<TPermission> tPermissionList = tPermissionMapper.findByRoleId(roleVo.getId());
            List<PermissionVO> permissionVoList = MyBeanUtils.copyList(tPermissionList, PermissionVO.class);
            roleVo.setPermissions(permissionVoList);
        }
        return new PageInfo<>(roleVoList);
    }


    @Override
    public void assignPermission(String roleId, String permissionIds) {
        log.info("分配权限，入参roleId="+roleId+",permissionIds=["+permissionIds+"]");
        delRolePermission(roleId);
        List<TRolePermission> tRoleMenuList = new ArrayList<>();
        for (String permissionId : permissionIds.split(",")) {
            TRolePermission tRolePermission = new TRolePermission();
            tRolePermission.setId(IDGeneratorUtils.UUID32());
            tRolePermission.setRoleId(roleId);
            tRolePermission.setPermissionId(permissionId);
            tRolePermission.setCreateTime(new Date());
            tRolePermissionMapper.insertSelective(tRolePermission);
            tRoleMenuList.add(tRolePermission);
        }
        //todo 批量插入有问题，坑，回头自己写批量插入
        //tRoleMenuMapper.insertList(tRoleMenuList);
        log.info("分配权限成功，入参roleId="+roleId+",permissionIds=["+tRoleMenuList+"]");
    }

    @Override
    public void addRole(RoleVO roleVo) {
        log.info("添加角色,入参roleVo=["+roleVo.toString()+"]");
        if(StringUtils.isEmpty(roleVo.getName())){
            throw new BizException(ExceptionCode.REQUEST_PARAM_MISSING);
        }
        TRole tRole = new TRole();
        BeanUtils.copyProperties(roleVo,tRole);
        Example example = new Example(TRole.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("name",roleVo.getName());
        int i = tRoleMapper.selectCountByExample(example);
        if(i>0){
            log.error("该角色名称已经存在!");
            throw new BizException(ExceptionCode.ROLE_AREADY_EXIST.getCode(),ExceptionCode.ROLE_AREADY_EXIST.getMsg());

        }
        tRole.setId(IDGeneratorUtils.UUID32());
        tRole.setCreateTime(new Date());
        tRoleMapper.insertSelective(tRole);
        log.info("添加角色成功，输出roleVo=["+tRole.toString()+"]");
    }

    @Transactional
    @Override
    public void editRole(RoleVO roleVo) {
        if(StringUtils.isEmpty(roleVo.getId())||StringUtils.isEmpty(roleVo.getName())){
            throw new BizException(ExceptionCode.REQUEST_PARAM_MISSING);
        }
        log.info("修改角色,入参roleVo=["+roleVo.toString()+"]");
        TRole tRole = MyBeanUtils.copy(roleVo, TRole.class);
        tRoleMapper.updateByPrimaryKeySelective(tRole);
        log.info("修改角色成功，输出roleVo=["+tRole.toString()+"]");
    }

    @Override
    public void delById(String id) {
        log.info("删除角色,入参id=["+id+"]");
        TRole tRole = tRoleMapper.selectByPrimaryKey(id);
        //查询该角色下的权限，如果有，则提示无法删除
        TRolePermission tRolePermission = new TRolePermission();
        tRolePermission.setRoleId(id);
        List<TRolePermission> tRolePermissionsList = tRolePermissionMapper.select(tRolePermission);
        if(!CollectionUtils.isEmpty(tRolePermissionsList)){
            throw new BizException(ExceptionCode.DEL_ROLE_HAS_PERMISSION);
        }
        tRoleMapper.deleteByPrimaryKey(id);
        log.info("删除角色成功");

    }

    @Override
    public void delRolePermission(String roleId) {
        Example trolePermissionExmaple = new Example(TRolePermission.class);
        Example.Criteria criteria = trolePermissionExmaple.createCriteria();
        criteria.andEqualTo("roleId",roleId);
        tRolePermissionMapper.deleteByExample(trolePermissionExmaple);
    }
}
