package com.maimai.springboot.entity;

import com.maimai.springboot.config.IdentityCardNumber;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @program: all
 * @description: 2
 * @author: zxb
 * @create: 2019-12-16 11:11
 **/
@Data
public class User {
    private Long id;

    @NotNull(message = "名称不能为空")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Range(max = 200,message = "年龄必须在1-200之间")
    private Integer age;

    @NotNull(message = "身份证不能为空")
    @IdentityCardNumber(message = "身份证信息有误,请核对后提交")
    private String idcard;

}
