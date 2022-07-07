package com.lemon.mybatisplus;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @Classname FastAutoGeneratorTest
 * @Description TODO
 * @Date 2022/7/7 19:00
 * @Created yj
 */
public class FastAutoGeneratorTest {

    public static void main(String[] args) {
        FastAutoGenerator.create("jjdbc:mysql://localhost:3306/mybatis_plus?characterEncoding=utf-8&userSSL=false", "root", "123456")
                        .globalConfig(builder -> {
                            builder.author("atguigu")
                                    .fileOverride()
                                    .outputDir("D://mybatis_plus");
                        }).packageConfig(builder -> {
                            builder.parent("com.atguigu") // 设置父包名
                                    .moduleName("mybatisplus") // 设置父包模块名
                                    .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "D://mybatis_plus"));
                        })
                        .strategyConfig(builder -> {
                            builder.addInclude("t_user"); // 设置需要生成的表名
                                    //.addTablePrefix("t_", "c_"); // 设置过滤表前缀
                        })
                        .templateEngine(new FreemarkerTemplateEngine())
                        .execute();
    }
}
