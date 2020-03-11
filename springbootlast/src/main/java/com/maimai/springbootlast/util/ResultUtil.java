package com.maimai.springbootlast.util;

import com.maimai.springbootlast.entity.Result;

/**
 * @program: springbootmaimai
 * @description: 2
 * @author: zxb
 * @create: 2020-03-11 16:51
 **/
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
