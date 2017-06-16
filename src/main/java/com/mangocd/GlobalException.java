package com.mangocd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class GlobalException {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ErrorInfo<String> defaultErrorHandler(HttpServletRequest req, Exception e){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(20000);
        r.setData("defaultErrorHandler");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorInfo<String> illegalArgumentExceptionHandler(HttpServletRequest req, IllegalArgumentException e){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(10000);
        r.setData("illegalArgumentException");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


    @ResponseBody
    @ExceptionHandler(BindException.class)
    public ErrorInfo<String> validateExceptionHandler(HttpServletRequest req, BindException e){
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage("参数不合法");
        r.setCode(80000);
        r.setData( e.getFieldError().getDefaultMessage() );
        r.setUrl(req.getRequestURL().toString());
        return r;
    }


}
