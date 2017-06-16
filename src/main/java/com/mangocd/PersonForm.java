package com.mangocd;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Ryan on 2017/6/15.
 */
@Data
public class PersonForm {

    @NotNull(message = "名字不能为空")
    @Size(min=2, max=30,message = "名字的长度不能小于2字节")
    private String name;

    @NotNull(message = "年龄不能为空")
    @Min(value = 18,message = "年龄不能小于18")
    private Integer age;

//    @NotNull
//    @Email
//    private String mail;



}
