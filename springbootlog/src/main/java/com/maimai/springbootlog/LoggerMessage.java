package com.maimai.springbootlog;

import lombok.AllArgsConstructor;
import lombok.*;

/**
 * @program: springbootmaimai
 * @description: 2
 * @author: zxb
 * @create: 2020-01-09 11:19
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
public class LoggerMessage {
    private String body;
    private String timestamp;
    private String threadName;
    private String className;
    private String level;
    private String exception;
    private String cause;
}
