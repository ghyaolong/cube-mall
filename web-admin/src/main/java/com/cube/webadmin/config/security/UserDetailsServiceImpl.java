package com.cube.webadmin.config.security;

import com.cube.mall.enums.ExceptionCode;
import com.cube.mall.exception.BizException;
import com.cube.webadmin.service.UserService;
import com.cube.webadmin.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserVO user = userService.getUserByUserName(username);
        if(user==null){
            throw new BizException(ExceptionCode.LOGIN_INFO_IS_NOT_EXIST);
        }
        return new SecurityUserDetails(user);
    }
}
