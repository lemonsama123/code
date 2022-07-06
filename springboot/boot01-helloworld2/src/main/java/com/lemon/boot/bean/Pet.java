package com.lemon.boot.bean;

import lombok.Data;
import lombok.ToString;

/**
 * @Classname Pet
 * @Description TODO
 * @Date 2022/7/4 21:58
 * @Created yj
 */
@ToString
@Data
public class Pet {
    private String name;
    private Double weight;
}