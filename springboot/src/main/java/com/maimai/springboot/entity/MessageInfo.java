package com.maimai.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: all
 * @description: 11
 * @author: zxb
 * @create: 2019-12-05 10:49
 **/
@Data
@AllArgsConstructor
public class MessageInfo {
    // 消息类型
    private Integer type;
    // 消息内容
    private String content;
}
