package com.lqk.springboot.config;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author liqiankun
 * @date 2024/12/10 16:38
 * @description
 **/
public class LqkImportSelect implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        // 自动配置，加载META-INF\services.com.lqk.springboot.config.AutoConfiguration文件中的全限定域名的配置类
        ServiceLoader<AutoConfiguration> loader = ServiceLoader.load(AutoConfiguration.class);
        List<String> list = new ArrayList<>();
        for (AutoConfiguration configuration : loader) {
            list.add(configuration.getClass().getName());
        }
        return list.toArray(new String[0]);
    }
}
