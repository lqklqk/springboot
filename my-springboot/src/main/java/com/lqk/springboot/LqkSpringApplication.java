package com.lqk.springboot;

import com.lqk.springboot.utils.WebServerUtil;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

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
        WebServerUtil.createWebServer(webApplicationContext);
    }

}
