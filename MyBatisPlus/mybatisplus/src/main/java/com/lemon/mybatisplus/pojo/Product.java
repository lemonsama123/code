package com.lemon.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @Classname Product
 * @Description TODO
 * @Date 2022/7/7 18:24
 * @Created yj
 */
@Data
public class Product {

    private Long id;
    private String name;
    private Integer price;

    @Version
    private Integer version;
}