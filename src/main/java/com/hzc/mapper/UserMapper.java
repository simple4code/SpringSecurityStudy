package com.hzc.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzc.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *
 * </p>
 *
 * @author hzc
 * @since 2023-01-19 0:24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
