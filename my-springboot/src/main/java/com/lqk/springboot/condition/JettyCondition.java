package com.lqk.springboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author liqiankun
 * @date 2024/12/10 14:27
 * @description
 **/
public class JettyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        ClassLoader classLoader = context.getClassLoader();
        try {
            classLoader.loadClass("org.eclipse.jetty.util.Jetty");
            return true;
        } catch (ClassNotFoundException e) {
            // 表示加载Tomcat失败
            return false;
        }
    }
}
