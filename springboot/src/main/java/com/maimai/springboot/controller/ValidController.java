package com.maimai.springboot.controller;

import com.maimai.springboot.entity.Result;
import com.maimai.springboot.entity.User;
import com.maimai.springboot.util.ResultUtil;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: all
 * @description: 2
 * @author: zxb
 * @create: 2019-12-16 11:12
 **/
@RestController
@RequestMapping("valid")
public class ValidController {
    @PostMapping("/postUser")
    public Result<User> postUser(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(user);
    }
    @PostMapping("/postUser1")
    public String postUser1(@Valid @RequestBody User user) {

        return "ResultUtil.success(user)";
    }

    @PostMapping("/girls")
    public Result<?> girlAdd(@Valid @RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
         List<String> list= bindingResult.getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
            return ResultUtil.success(list);
        }
        return ResultUtil.success(user);

    }
}
