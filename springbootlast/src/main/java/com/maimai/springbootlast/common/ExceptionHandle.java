package com.maimai.springbootlast.common;

import com.maimai.springbootlast.entity.Result;
import com.maimai.springbootlast.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: springbootmaimai
 * @description:
 * @author: zxb
 * @create: 2020-03-11 17:08
 **/
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result Handle(Exception e) {

        return ResultUtil.error(11, e.getMessage());
    }
}
