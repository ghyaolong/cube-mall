package com.cube.webadmin.service.impl;

import com.cube.IDGeneratorUtils;
import com.cube.mall.constant.CommonStatus;
import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.exception.BizException;
import com.cube.mall.model.PageVO;
import com.cube.security.DigestUtil;
import com.cube.webadmin.beanUtils.MyBeanUtils;
import com.cube.webadmin.dao.TPermissionMapper;
import com.cube.webadmin.dao.TUserMapper;
import com.cube.webadmin.dao.TUserRoleMapper;
import com.cube.webadmin.po.TPermission;
import com.cube.webadmin.po.TRole;
import com.cube.webadmin.po.TUser;
import com.cube.webadmin.po.TUserRole;
import com.cube.webadmin.service.UserService;
import com.cube.webadmin.vo.PermissionVO;
import com.cube.webadmin.vo.RoleVO;
import com.cube.webadmin.vo.UserVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:用户管理实现类
 * @Author: yaochenglong
 * @Date: 17:49 2018/10/21
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private TUserMapper tUserMapper;

    @Autowired
    private TUserRoleMapper tUserRoleMapper;



    @Autowired
    private TPermissionMapper tPermissionMapper;

    @Override
    public boolean login(UserVO vo) {
        if (vo == null) {
            throw new BizException(ExceptionCode.USER_INFO_IS_NOT_EXIST);
        }

        if (StringUtils.isEmpty(vo.getUsername())) {
            throw new BizException(ExceptionCode.REQUEST_PARAM_MISSING);
        }

        TUser tUser = null;
        try {
            Example example = new Example(TUser.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", vo.getUsername());
            tUser = tUserMapper.selectOneByExample(example);
            if (tUser == null) {
                return false;
            }
        } catch (Exception e) {
            throw new BizException(ExceptionCode.DATA_AREADY_EXIST);
        }
        String salt = tUser.getSalt();
        String oriPassword = tUser.getPassword();
        String password = DigestUtil.encryptMD5(vo.getPassword(), salt);
        if (oriPassword.equals(password)) {
            return true;
        } else {
            throw new BizException(ExceptionCode.PASSORD_ERROR);
        }
    }

    @Override
    public List<UserVO> getAllUser() {
        List<TUser> tUsers = tUserMapper.selectAll();
        List<UserVO> voList = MyBeanUtils.copyList(tUsers, UserVO.class);
        return voList;
    }



    @Override
    public UserVO getUser(UserVO vo) {
        TUser tuser = new TUser();
        BeanUtils.copyProperties(vo, tuser);
        try {
            TUser tUser = tUserMapper.selectOne(tuser);
            BeanUtils.copyProperties(tUser, vo);
        } catch (Exception e) {
            throw new BizException("用户数据不唯一");
        }
        return vo;
    }

    @Override
    public UserVO getUserByUserName(String username) {
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", username);
        try {
            TUser tUser = tUserMapper.selectOneByExample(example);
            if (tUser != null) {
                UserVO userVo = MyBeanUtils.copy(tUser, UserVO.class);
                
                //关联角色
                List<TRole> tRoles = tUserRoleMapper.findByUserId(tUser.getId());
                List<RoleVO> roleVos = MyBeanUtils.copyList(tRoles, RoleVO.class);
                userVo.setRoles(roleVos);
                //关联权限菜单
                List<TPermission> tPermissions = tPermissionMapper.findByUserId(tUser.getId());
                List<PermissionVO> permissionVos = MyBeanUtils.copyList(tPermissions, PermissionVO.class);
                userVo.setPermissions(permissionVos);
                return userVo;
            }
            return null;

        } catch (Exception e) {
            log.error("查询用户" + username + "出错", e);
            throw new BizException(ExceptionCode.DATA_AREADY_EXIST);
        }
    }

    @Override
    public UserVO getUserById(String id) {
        TUser tUser = tUserMapper.selectByPrimaryKey(id);
        if (tUser == null) {
            throw new BizException(ExceptionCode.USER_INFO_IS_NOT_EXIST);
        }
        UserVO vo = new UserVO();
        BeanUtils.copyProperties(tUser, vo, "password2");
        return vo;
    }

    @Override
    public PageInfo<UserVO> getUserByPage(int pageNow, int pageSize) {
        if (pageNow < 0 || pageSize <= 0) {
            throw new BizException("分页参数不正确");
        }
        PageHelper.startPage(pageNow, pageSize, true);
        Example example = new Example(TUser.class);
        example.createCriteria().andEqualTo("is_del", CommonStatus.NORMAL_FLAG);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        int count = tUserMapper.selectCountByExample(example);
        List<UserVO> userVoList = MyBeanUtils.copyList(tUsers, UserVO.class);
        PageInfo<UserVO> page = new PageInfo<>(userVoList);
        return page;
    }

    @Override
    public PageInfo<UserVO> getUserByPage(int pageNow, int pageSize, UserVO vo) {
        TUser tuser = new TUser();
        BeanUtils.copyProperties(vo, tuser);
        PageHelper.startPage(pageNow, pageSize, true);
        tuser.setStatus(CommonStatus.NORMAL_FLAG);
        List<TUser> tUsers = tUserMapper.select(tuser);
        int count = tUserMapper.selectCount(tuser);
        List<UserVO> userVoList = MyBeanUtils.copyList(tUsers, UserVO.class);
        PageInfo<UserVO> page = new PageInfo<>(userVoList);
        return page;
    }

    @Transactional
    @Override
    public void addUser(UserVO vo) {
        log.info("添加用户开始,入参为[" + vo.toString() + "]");
        TUser tuser = new TUser();
        boolean bool = isExistByUserName(vo.getUsername());
        if (bool) {
            throw new BizException(ExceptionCode.USER_NAME_AREADY_EXIST);
        }
        log.info("验证用户唯一性通过，");
        //这里将密码加密成暗文
        BeanUtils.copyProperties(vo, tuser);
        tuser.setId(IDGeneratorUtils.UUID32());
//        String salt = RandomUtils.randomSalt();
//        String password = DigestUtil.encryptMD5(tuser.getPassword(), salt);
        String encryptPass = new BCryptPasswordEncoder().encode(vo.getPassword());
        tuser.setCreateTime(new Date());
        tuser.setPassword(encryptPass);
        tuser.setStatus(0);
        log.info("添加用户中....,参数为[" + tuser.toString() + "]");
        tUserMapper.insertSelective(tuser);

        if(!StringUtils.isEmpty(vo.getRoleIds())){
            //保存用户-角色关系
            String[] roleIds = vo.getRoleIds().split(",");
            for (String roleId : roleIds) {
                TUserRole tUserRole = new TUserRole();
                tUserRole.setId(IDGeneratorUtils.UUID32());
                tUserRole.setUserId(tuser.getId());
                tUserRole.setRoleId(roleId);
                tUserRoleMapper.insert(tUserRole);
                log.debug("保存用户-角色成功，结果:" + tUserRole);
            }
        }
        log.info("添加用户成功");
    }

    /**
     * 判断用户是否存在，
     *
     * @return
     * @Param username 用户名
     */
    private boolean isExistByUserName(String username) {
        if (StringUtils.isEmpty(username)) {
            throw new BizException(ExceptionCode.REQUEST_PARAM_MISSING);
        }
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("username", username);
        int i = tUserMapper.selectCountByExample(example);
        return i > 0;
    }

    /**
     * 判断用户是否存在，
     *
     * @return
     * @Param workNumber
     */
    private boolean isExistByWorkNumber(String workNumber) {
        if (StringUtils.isEmpty(workNumber)) {
            throw new BizException(ExceptionCode.REQUEST_PARAM_MISSING);
        }
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("workNumber", workNumber);
        int i = tUserMapper.selectCountByExample(example);
        return i > 0;
    }

    private boolean isExistByECode(String eCode) {
        if (StringUtils.isEmpty(eCode)) {
            throw new BizException(ExceptionCode.REQUEST_PARAM_MISSING);
        }
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.orEqualTo("eCode", eCode);
        int i = tUserMapper.selectCountByExample(example);
        return i > 0;
    }


    @Override
    public void delUser(String id) {
        log.info("删除用户，输入参数[id=" + id + "]");
//        TUser tUser = tUserMapper.selectByPrimaryKey(id);
//        tUser.setStatus(CommonStatus.DEL_FLAG);
//        //tUserMapper.deleteByPrimaryKey(id);
//        tUserMapper.updateByPrimaryKeySelective(tUser);
        tUserMapper.deleteByPrimaryKey(id);
        Example example = new Example(TUserRole.class);
        example.createCriteria().andEqualTo("userId", id);
        tUserRoleMapper.deleteByExample(example);
        log.info("删除用户成功");
    }


    @Override
    public void editUser(UserVO vo) {
        Example queryExample = new Example(TUser.class);
        if(!StringUtils.isEmpty(vo.getUsername())){
            TUser tUser = tUserMapper.selectByPrimaryKey(vo.getId());
            if(!tUser.getUsername().equals(vo.getUsername())){
                if(!tUser.getUsername().equals(vo.getUsername())){
                    queryExample.createCriteria().andEqualTo("username",vo.getUsername());
                    int i = tUserMapper.selectCountByExample(queryExample);
                    if(i>0){
                        throw new BizException(ExceptionCode.DATA_AREADY_EXIST.getCode(),"用户名已存在");
                    }
                }
            }
        }
        TUser tuser = tUserMapper.selectByPrimaryKey(vo.getId());
        BeanUtils.copyProperties(vo, tuser, "password");
        String roleIds = vo.getRoleIds();
        Example userRoleExample = new Example(TUserRole.class);
        userRoleExample.createCriteria().andEqualTo("userId", vo.getId());
        tUserRoleMapper.deleteByExample(userRoleExample);
        if (!StringUtils.isEmpty(roleIds)) {
            //清除用户先前的角色，重新添加角色
//            Example userRoleExample = new Example(TUserRole.class);
//            userRoleExample.createCriteria().andEqualTo("userId", vo.getId());
//            tUserRoleMapper.deleteByExample(userRoleExample);
            log.debug("修改用户中，清除用户原有的角色成功");
            String[] split = roleIds.split(",");
            for (String s : split) {
                TUserRole tUserRole = new TUserRole();
                tUserRole.setId(IDGeneratorUtils.UUID32());
                tUserRole.setUserId(vo.getId());
                tUserRole.setRoleId(s);
                tUserRoleMapper.insertSelective(tUserRole);
            }
            log.debug("修改用户.....重新给用户添加角色成功");
        }else{

        }
        tUserMapper.updateByPrimaryKeySelective(tuser);
    }

    @Override
    public void updatePassord(UserVO userVo) {
        log.info("开始修改用户密码，输入参数:" + userVo);
        TUser tuser = new TUser();
        BeanUtils.copyProperties(userVo, tuser);
        tUserMapper.updateByPrimaryKeySelective(tuser);
        log.info("修改密码成功");
    }

    /**
     * 分页查询
     * @return
     */
    @Override
    public PageInfo<UserVO> findByCondition(PageVO<UserVO> pageVO){

        UserVO userVo = pageVO.getT();
        //去空格处理
        if(!StringUtils.isEmpty(userVo.getUsername())){
            String username = userVo.getUsername().trim();
            userVo.setUsername(username);
        }
        String email = userVo.getEmail();
        String sex = userVo.getSex();
        Integer status = userVo.getStatus();
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringUtils.isEmpty(email)){
            criteria.andEqualTo("email",email);
        }
        if(!StringUtils.isEmpty(sex)){
            criteria.andEqualTo("sex",sex);
        }
        if(!StringUtils.isEmpty(sex)){
            criteria.andEqualTo("status",status);
        }
        PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize(), true);
        List<TUser> tUsers = tUserMapper.selectByExample(example);
        List<UserVO> userVoList = MyBeanUtils.copyList(tUsers, UserVO.class, "password", "password2");
        return new PageInfo<>(userVoList);
    }
}
