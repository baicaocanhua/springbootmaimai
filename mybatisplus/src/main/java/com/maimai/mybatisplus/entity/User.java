package com.maimai.mybatisplus.entity;

import lombok.Data;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-05-12 17:28
 **/
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
