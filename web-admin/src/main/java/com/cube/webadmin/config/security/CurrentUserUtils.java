package com.cube.webadmin.config.security;

import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.exception.BizException;
import com.cube.webadmin.beanUtils.MyBeanUtils;
import com.cube.webadmin.dao.TUserRoleMapper;
import com.cube.webadmin.po.TRole;
import com.cube.webadmin.service.UserService;
import com.cube.webadmin.vo.RoleVO;
import com.cube.webadmin.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CurrentUserUtils {

    @Autowired
    private UserService userService;
    @Autowired
    private TUserRoleMapper tUserRoleMapper;

    /**
     * 获取当前用户名称
     * @return
     */
    public  String getUserName(){
        try {
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return user.getUsername();

        }catch (Exception e){
            throw new BizException(ExceptionCode.TOKEN_ERROR);
        }
    }

    /**
     * 获取当前用户id
     * @return
     */
    public  String getUserId(){
        try {
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserVO vo = userService.getUserByUserName(user.getUsername());
            if(vo!=null){
                return vo.getId();
            }

        }catch (Exception e){
            throw new BizException(ExceptionCode.TOKEN_ERROR);
        }
        return null;
    }

    public List<RoleVO> getCurrUserRole(){
        try {
            UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            UserVO vo = userService.getUserByUserName(user.getUsername());
            List<TRole> troles = tUserRoleMapper.findByUserId(vo.getId());
            List<RoleVO> roleVos = MyBeanUtils.copyList(troles, RoleVO.class);
            if(roleVos!=null){
                return roleVos;
            }

        }catch (Exception e){
            throw new BizException(ExceptionCode.TOKEN_ERROR);
        }
        return null;
    }
}
