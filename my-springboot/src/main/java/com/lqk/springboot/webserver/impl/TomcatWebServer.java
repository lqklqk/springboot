package com.lqk.springboot.webserver.impl;

import com.lqk.springboot.utils.WebServerUtil;
import com.lqk.springboot.webserver.WebServer;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author liqiankun
 * @date 2024/12/9 17:12
 * @description
 **/
public class TomcatWebServer implements WebServer {
    @Override
    public void onStart(WebApplicationContext webApplicationContext) {
        System.out.println("启动tomcat");
        WebServerUtil.createTomcat(webApplicationContext);
    }
}
