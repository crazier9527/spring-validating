package com.mangocd;


import lombok.Data;

/**
 * Created by Ryan on 2017/6/15.
 */
@Data
public class ErrorInfo<T> {

    private Integer code;
    private String message;
    private String url;
    private T data;


}