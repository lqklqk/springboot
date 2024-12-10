package com.lqk.springboot;

import com.lqk.springboot.webserver.WebServer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Map;

/**
 * @author liqiankun
 * @date 2024/12/9 15:39
 * @description
 **/
public class LqkSpringApplication {
    public static void run(Class clazz) {
        // 创建spring容器
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        // 将配置Bean注册到spring容器中，所以clazz必须是配置类（@Configuration注解）
        webApplicationContext.register(clazz);
        // 刷新（启动）spring容器，根据配置指定的扫描路径（@ComponentScan注解所在包），创建所有bean（存在注册到spring容器中的注解）
        webApplicationContext.refresh();
        // 创建Tomcat
        // WebServerUtil.createTomcat(webApplicationContext);
        WebServer webServer = getWebServer(webApplicationContext);
        webServer.onStart(webApplicationContext);
    }


    public static WebServer getWebServer(WebApplicationContext applicationContext){
        Map<String, WebServer> beansOfType = applicationContext.getBeansOfType(WebServer.class);

        if (beansOfType.isEmpty()) {
            throw new NullPointerException();
        }

        if (beansOfType.size() > 1) {
            throw new IllegalStateException();
        }

        return beansOfType.values().stream().findFirst().get();
    }

}
