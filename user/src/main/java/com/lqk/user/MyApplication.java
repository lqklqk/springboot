package com.lqk.user;

import com.lqk.springboot.LqkSpringApplication;
import com.lqk.springboot.annotation.LqkSpringBootApplication;
import com.lqk.springboot.config.WebServerAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * @author liqiankun
 * @date 2024/12/9 15:42
 * @description
 **/
@LqkSpringBootApplication
@Import(WebServerAutoConfiguration.class)
public class MyApplication {
    public static void main(String[] args) {
        LqkSpringApplication.run(MyApplication.class);
    }
}
