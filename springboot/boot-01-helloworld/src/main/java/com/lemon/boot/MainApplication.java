package com.lemon.boot;

import com.lemon.boot.bean.Pet;
import com.lemon.boot.bean.User;
import com.lemon.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.cache.interceptor.CacheAspectSupport;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Classname MainApplication
 * @Description TODO
 * @Date 2022/7/4 12:24
 * @Created yj
 */
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run =
                SpringApplication.run(MainApplication.class, args);
        String[] beanNamesForType = run.getBeanNamesForType(WebMvcProperties.class);
        System.out.println(beanNamesForType.length);

    }
}
