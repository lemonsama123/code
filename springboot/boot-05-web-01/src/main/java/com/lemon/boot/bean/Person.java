package com.lemon.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Classname Person
 * @Description TODO
 * @Date 2022/7/6 12:06
 * @Created yj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private String userName;
    private Integer age;
    private Date birth;
    private Pet pet;
}
