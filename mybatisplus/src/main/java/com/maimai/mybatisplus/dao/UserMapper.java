package com.maimai.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.maimai.mybatisplus.entity.User;

import java.util.List;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-05-12 17:27
 **/
public interface UserMapper extends BaseMapper<User> {

    List<User> maimai();
    List<User> maimai2();

}
