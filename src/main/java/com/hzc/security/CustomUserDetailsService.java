package com.hzc.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzc.pojo.User;
import com.hzc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  自定义 UserDetailsService
 *      从数据库中获取用户角色
 * </p>
 *
 * @author hzc
 * @since 2023-01-19 0:53
 */
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    private GrantedAuthority DEFAULT_ROLE = new SimpleGrantedAuthority("USER");

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        // 1. 查询用户
        User userFromDB = userService.getOne(new QueryWrapper<User>().eq("login", login));
        if(userFromDB == null) {
            throw new UsernameNotFoundException("User " + login + " was not found in db");
        }

        // 2. 设置角色
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        String dbRole = userFromDB.getRole();
        if(!StringUtils.hasLength(dbRole)) {
            grantedAuthorities.add(DEFAULT_ROLE);
        }else {
            String[] roles = dbRole.split(",");
            for (String role : roles) {
                grantedAuthorities.add(new SimpleGrantedAuthority(role));
            }
        }

        return new org.springframework.security.core.userdetails.User(
                login,
                userFromDB.getPassword(),
                grantedAuthorities
        );
    }
}
