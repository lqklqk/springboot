package com.lqk.springboot.webserver.impl;

import com.lqk.springboot.webserver.WebServer;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author liqiankun
 * @date 2024/12/9 17:13
 * @description
 **/
public class JettyWebServer implements WebServer {

    @Override
    public void onStart(WebApplicationContext webApplicationContext) {
        System.out.println("启动jetty");
    }
}
