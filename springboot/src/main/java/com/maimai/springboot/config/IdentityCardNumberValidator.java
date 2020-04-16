package com.maimai.springboot.config;


import com.maimai.springboot.util.IdCardValidatorUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * @program: all
 * @description: 2
 * @author: zxb
 * @create: 2019-12-17 15:48
 **/
public class IdentityCardNumberValidator implements ConstraintValidator<IdentityCardNumber, Object> {

    @Override
    public void initialize(IdentityCardNumber identityCardNumber) {
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(o==null){
            return  false;
        }
        return IdCardValidatorUtils.isValidate18Idcard(o.toString());
    }
}
