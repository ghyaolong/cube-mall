package com.cube.webadmin.service.impl;
import com.cube.IDGeneratorUtils;
import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.exception.BizException;
import com.cube.webadmin.beanUtils.MyBeanUtils;
import com.cube.webadmin.dao.TPermissionMapper;
import com.cube.webadmin.po.TPermission;
import com.cube.webadmin.service.PermissionService;
import com.cube.webadmin.vo.PermissionVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
/**
 * @Description: 权限服务实现类
 * @Date: Created in 20:24 2018/10/25
 * @Author: yaochenglong
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {


    @Autowired
    private TPermissionMapper tPermissionMapper;


    @Override
    public PermissionVO findById(String id){
        PermissionVO permissionVo = new PermissionVO();
        TPermission tPermission = tPermissionMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(tPermission,permissionVo);
        return permissionVo;
    }

    @Override
    public List<PermissionVO> findByUserId(String userId) {
        List<TPermission> tPermissionList = tPermissionMapper.findByUserId(userId);
        List<PermissionVO> permissionVos = MyBeanUtils.copyList(tPermissionList, PermissionVO.class);
        return permissionVos;
    }

    @Override
    public void addPermission(PermissionVO permissionVo) {
        log.info("添加权限,入参["+permissionVo+"]");
        TPermission tPermission = new TPermission();
        BeanUtils.copyProperties(permissionVo,tPermission);
        tPermission.setId(IDGeneratorUtils.UUID32());
        tPermission.setCreateTime(new Date());
        tPermissionMapper.insertSelective(tPermission);
        log.info("添加权限成功,结果["+tPermission+"]");
    }

    @Override
    public void delPermissionById(String id) {
        log.info("删除权限，入参："+id);
        tPermissionMapper.deleteByPrimaryKey(id);
        log.info("删除权限成功");

    }

    @Override
    public void editPermission(PermissionVO permissionVo) {
        log.info("修改权限,入参["+permissionVo+"]");
        TPermission tPermission = new TPermission();
        BeanUtils.copyProperties(permissionVo,tPermission);
        if(StringUtils.isEmpty(tPermission.getId())){
            throw new BizException(ExceptionCode.REQUEST_PARAM_MISSING);
        }
        tPermissionMapper.updateByPrimaryKeySelective(tPermission);
        log.info("修改权限,结果["+tPermission+"]");
    }

    @Override
    public List<PermissionVO> findByLevelOrderBySortOrder(Integer level) {
        Example example = new Example(TPermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("level",level);
        List<TPermission> tPermissions = tPermissionMapper.selectByExample(example);
        List<PermissionVO> permissionVoList = MyBeanUtils.copyList(tPermissions, PermissionVO.class);
        return permissionVoList;
    }

    @Override
    public List<PermissionVO> findByParentIdOrderBySortOrder(String parentId) {
        Example example = new Example(TPermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentId",parentId);
        List<TPermission> tPermissions = tPermissionMapper.selectByExample(example);
        List<PermissionVO> permissionVoList = MyBeanUtils.copyList(tPermissions, PermissionVO.class);
        return permissionVoList;
    }

    @Override
    public List<PermissionVO> findByTypeAndStatusOrderBySortOrder(Integer type, Integer status) {
        Example example = new Example(TPermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",type);
        criteria.andEqualTo("status",status);
        List<TPermission> tPermissions = tPermissionMapper.selectByExample(example);
        List<PermissionVO> permissionVoList = MyBeanUtils.copyList(tPermissions, PermissionVO.class);
        return permissionVoList;
    }

    @Override
    public List<PermissionVO> findByTitle(String title) {
        Example example = new Example(TPermission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("title",title);
        List<TPermission> tPermissions = tPermissionMapper.selectByExample(example);
        List<PermissionVO> permissionVoList = MyBeanUtils.copyList(tPermissions, PermissionVO.class);
        return permissionVoList;
    }
}
