package com.lqk.springboot.utils;

import com.lqk.springboot.webserver.WebServer;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author liqiankun
 * @date 2024/12/9 19:35
 * @description
 **/
public class WebServerUtil {
    /**
     * 创建WebServer并启动（根据不同的bean）
     * @param webApplicationContext spring容器
     */
    public static void createWebServer(WebApplicationContext webApplicationContext) {
        WebServer webServer = webApplicationContext.getBean(WebServer.class);
        webServer.onStart(webApplicationContext);
    }

    /**
     * 启动Tomcat容器
     * @param webApplicationContext spring容器
     */
    public static void createTomcat(WebApplicationContext webApplicationContext) {
        Tomcat tomcat = new Tomcat();
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        Connector connector = new Connector();
        connector.setPort(8081);

        Engine engine = new StandardEngine();
        engine.setDefaultHost("localhost");

        Host host = new StandardHost();
        host.setName("localhost");

        String contextPath = "";
        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);
        // 生成DispatcherServlet对象，并且和前面创建出来的Spring容器进行绑定
        // 将DispatcherServlet添加到Tomcat中
        tomcat.addServlet(contextPath, "dispatcher", new DispatcherServlet(webApplicationContext));
        context.addServletMappingDecoded("/*", "dispatcher");

        try {
            tomcat.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
