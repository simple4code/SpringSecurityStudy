package com.hzc.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hzc.pojo.User;

/**
 * <p>
 *
 * </p>
 *
 * @author hzc
 * @since 2023-01-19 0:32
 */
public interface UserService extends IService<User> {

    public void addUser(User user);
}
