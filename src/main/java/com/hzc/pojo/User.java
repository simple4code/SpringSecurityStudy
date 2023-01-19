package com.hzc.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * <p>
 *
 * </p>
 *
 * @author hzc
 * @since 2023-01-19 0:28
 */
@Data
public class User {
    /**
     * 设置主键和主键自增方式
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    private String login;
    private String password;
    private String role;
}
