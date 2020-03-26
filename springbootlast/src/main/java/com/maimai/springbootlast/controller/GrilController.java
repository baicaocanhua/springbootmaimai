package com.maimai.springbootlast.controller;

import com.maimai.springbootlast.entity.Gril;
import com.maimai.springbootlast.entity.Result;
import com.maimai.springbootlast.util.ResultUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @program: springbootmaimai
 * @description: 2
 * @author: zxb
 * @create: 2020-03-11 16:55
 **/
@RestController
public class GrilController {
    //添加女生
    @PostMapping(value = "/grils/{id}")
    public Result<Gril> grilAdd(@Valid Gril gril, BindingResult bindingResult) {
        System.out.println(123);
        if (bindingResult.hasErrors()) {
            //这个是把gril里面的这个id必传返回给前端
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        return ResultUtil.success();
    }
}
