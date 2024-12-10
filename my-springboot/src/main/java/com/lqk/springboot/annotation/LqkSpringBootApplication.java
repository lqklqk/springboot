package com.lqk.springboot.annotation;

import com.lqk.springboot.config.LqkImportSelect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liqiankun
 * @date 2024/12/9 15:40
 * @description
 **/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
// 表示该注解所在类是一个配置类，会注册到spring容器中
@Configuration
// 后续注册到spring容器中会根据该注解进行扫描，指定扫描bean的包路径
@ComponentScan
// 导入选择的bean
@Import(LqkImportSelect.class)
public @interface LqkSpringBootApplication {
}
