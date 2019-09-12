package com.cube.webadmin.service.impl;

import com.cube.IDGenerator;
import com.cube.mall.constant.CommonStatus;
import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.exception.BizException;
import com.cube.mall.model.PageVO;
import com.cube.utils.DigestUtil;
import com.cube.webadmin.beanUtils.MyBeanUtils;
import com.cube.webadmin.beanUtils.constant.CommonConstant;
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
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public List<UserVO> getAllUserByRoleCode(String roleCode) {
        List<TUser> tusers = tUserMapper.findAllUserByRoleCode(roleCode);
        List<UserVO> UserVOs = MyBeanUtils.copyList(tusers, UserVO.class,new String[]{"password"});
        return UserVOs;
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
                UserVO userVO = MyBeanUtils.copy(tUser, UserVO.class);

                //关联角色
                List<TRole> tRoles = tUserRoleMapper.findByUserId(tUser.getId());
                List<RoleVO> roleVos = MyBeanUtils.copyList(tRoles, RoleVO.class);
                userVO.setRoles(roleVos);
                //关联权限菜单
                List<TPermission> tPermissions = tPermissionMapper.findByUserId(tUser.getId());
                List<PermissionVO> permissionVos = MyBeanUtils.copyList(tPermissions, PermissionVO.class);
                userVO.setPermissions(permissionVos);
                return userVO;
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
        List<UserVO> UserVOList = MyBeanUtils.copyList(tUsers, UserVO.class);
        PageInfo<UserVO> page = new PageInfo<>(UserVOList);
        return page;
    }

    @Override
    public PageInfo<UserVO> getUserByPage(int pageNow, int pageSize, UserVO vo) {
        TUser tuser = new TUser();
        BeanUtils.copyProperties(vo, tuser);
        PageHelper.startPage(pageNow, pageSize, true);
        tuser.setStatus(CommonStatus.NORMAL_FLAG);
        List<TUser> tUsers = tUserMapper.select(tuser);
        List<UserVO> UserVOList = MyBeanUtils.copyList(tUsers, UserVO.class);
        PageInfo<UserVO> page = new PageInfo<>(UserVOList);
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
        tuser.setId(IDGenerator.UUID32());
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
                tUserRole.setId(IDGenerator.UUID32());
                tUserRole.setUserId(tuser.getId());
                tUserRole.setRoleId(roleId);
                tUserRoleMapper.insert(tUserRole);
                log.debug("保存用户-角色成功，结果:" + tUserRole);
            }
        }
        log.info("添加用户成功");
    }
//    }

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
    public void delUserByWorkNum(String workNumber) {
        log.info("通过工号删除用户，输入参数[workNumber=" + workNumber + "]");
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("workNumber", workNumber);
        TUser tUser = tUserMapper.selectOneByExample(example);
        tUser.setStatus(CommonStatus.DEL_FLAG);
        tUserMapper.updateByPrimaryKeySelective(tUser);
        log.info("删除用户成功，返回对象[" + tUser.toString() + "]");
    }

    @Override
    public void editUser(UserVO vo) {
        //vo.setRealName(vo.getUsername());
        //TUser tuser = new TUser();

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
                tUserRole.setId(IDGenerator.UUID32());
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
    public void updatePassord(UserVO UserVO) {
        log.info("开始修改用户密码，输入参数:" + UserVO);
        TUser tuser = new TUser();
        BeanUtils.copyProperties(UserVO, tuser);
        tUserMapper.updateByPrimaryKeySelective(tuser);
        log.info("修改密码成功");
    }

    /**
     * 分页查询
     *
     * @return
     */
    @Override
    public PageInfo<UserVO> findByCondition(PageVO<UserVO> pageVO){


        UserVO userVO = pageVO.getT();

        String email = userVO.getEmail();
        String sex  = userVO.getSex();
        Integer status = userVO.getStatus();
        //Date createTime = UserVO.getCreateTime();
        Example example = new Example(TUser.class);
        Example.Criteria criteria = example.createCriteria();

        PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize(), true);
        //List<TUser> tUsers = tUserMapper.selectByExample(example);
        List<TUser> tUsers = tUserMapper.findAll(userVO);
        List<UserVO> userVOList = MyBeanUtils.copyList(tUsers, UserVO.class, "password", "password2");
        PageInfo info = new PageInfo(userVOList);
        return info;

    }


    @Override
    public boolean isAdmin() {
        UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        Example example = new Example(TUser.class);
        example.createCriteria().andEqualTo("username",username);
        TUser tUser = tUserMapper.selectOneByExample(example);
        if(tUser!=null){
            List<TRole> byUserId = tUserRoleMapper.findByUserId(tUser.getId());
            for (TRole tRole : byUserId) {
                if(tRole.getName().equals(CommonConstant.ROLE_ADMIN_NAME)){
                    return true;
                }
            }
        }
        return false;
    }
}
