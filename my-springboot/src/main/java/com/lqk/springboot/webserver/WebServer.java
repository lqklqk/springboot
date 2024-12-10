package com.lqk.springboot.webserver;

import org.springframework.web.context.WebApplicationContext;

/**
 * @author liqiankun
 * @date 2024/12/9 17:12
 * @description
 **/
public interface WebServer {
    /**
     * 启动WebServer
     * @param webApplicationContext spring容器
     */
    void onStart(WebApplicationContext webApplicationContext);
}
