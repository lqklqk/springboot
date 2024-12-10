package com.lqk.springboot.config;

import com.lqk.springboot.annotation.LqkConditionalOnClass;
import com.lqk.springboot.webserver.WebServer;
import com.lqk.springboot.webserver.impl.JettyWebServer;
import com.lqk.springboot.webserver.impl.TomcatWebServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liqiankun
 * @date 2024/12/10 14:11
 * @description
 **/
@Configuration
public class WebServerAutoConfiguration implements AutoConfiguration{
    // 只有存在"org.apache.catalina.startup.Tomcat"类，那么才有TomcatWebServer这个Bean
    @Bean
    @LqkConditionalOnClass("org.apache.catalina.startup.Tomcat")
    public WebServer tomcatWebServer() {
        return new TomcatWebServer();
    }
    // 只有存在"org.eclipse.jetty.server.Server"类，那么才有JettyWebServer这个Bean
    @Bean
    @LqkConditionalOnClass("org.eclipse.jetty.util.Jetty")
    public WebServer jettyWebServer() {
        return new JettyWebServer();
    }
}
