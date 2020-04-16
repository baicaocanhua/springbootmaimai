package com.maimai.springboot.config;

import com.maimai.springboot.entity.Result;
import com.maimai.springboot.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: all
 * @description: 2
 * @author: zxb
 * @create: 2019-12-16 16:00
 **/
@RestControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        return ResultUtil.error(500, e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> list= e.getBindingResult() .getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.toList());
        //return ResultUtil.success(list);

        return ResultUtil.error(100, "参数校验异常",list);
    }

    @ExceptionHandler(ValidationException.class)
    public Result handleValidationException(ValidationException e){
        return ResultUtil.error(100, e.getMessage());
    }


    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(NoHandlerFoundException e){
        return ResultUtil.error(404, "路径不存在，请检查路径是否正确",e.getMessage());
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException  e){
        return ResultUtil.error(404, "数据重复，请检查后提交",e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public Result handleConstraintViolationException(ConstraintViolationException  e){
        return ResultUtil.error(404, "数据重复，请检查后提交",e.getMessage());
    }
}
