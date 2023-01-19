package com.hzc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hzc.mapper.UserMapper;
import com.hzc.pojo.User;
import com.hzc.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *
 * </p>
 *
 * @author hzc
 * @since 2023-01-19 0:32
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void addUser(User user) {
        this.save(user);
    }
}
