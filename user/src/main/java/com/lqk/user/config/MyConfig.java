package com.lqk.user.config;

import com.lqk.springboot.webserver.WebServer;
import com.lqk.springboot.webserver.impl.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liqiankun
 * @date 2024/12/9 19:47
 * @description
 **/
@Configuration
public class MyConfig {
    @Bean
    public WebServer webServer() {
        return new TomcatWebServer();
    }
}
