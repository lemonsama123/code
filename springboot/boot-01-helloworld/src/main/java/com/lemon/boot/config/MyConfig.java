package com.lemon.boot.config;

import com.lemon.boot.bean.Car;
import com.lemon.boot.bean.Pet;
import com.lemon.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Classname MyConfig
 * @Description TODO
 * @Date 2022/7/4 17:30
 * @Created yj
 */
@Import({User.class})
@Configuration(proxyBeanMethods = true)
@EnableConfigurationProperties(Car.class)
public class MyConfig {


    @Bean
    public User user01() {
        User zhangsan = new User("zhangsan", 18);
        zhangsan.setPet(tomcat());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcat() {
        return new Pet("tomcat");
    }
}
