package com.lemon.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.lemon.mybatisplus.enums.SexEnum;
import lombok.*;

/**
 * @Classname User
 * @Description TODO
 * @Date 2022/7/7 11:32
 * @Created yj
 */
//@TableName("t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("user_name")
    private String name;

    private Integer age;

    private String email;

    @TableLogic
    private Integer isDeleted;

    private SexEnum sex;
}
