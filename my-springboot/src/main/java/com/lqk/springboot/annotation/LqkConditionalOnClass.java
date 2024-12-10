package com.lqk.springboot.annotation;

import com.lqk.springboot.condition.LqkCondition;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liqiankun
 * @date 2024/12/10 16:24
 * @description
 **/
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Conditional(LqkCondition.class)
public @interface LqkConditionalOnClass {
    String value();
}
