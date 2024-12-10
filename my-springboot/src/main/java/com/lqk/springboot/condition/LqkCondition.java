package com.lqk.springboot.condition;

import com.lqk.springboot.annotation.LqkConditionalOnClass;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @author liqiankun
 * @date 2024/12/10 16:26
 * @description 具体逻辑为，拿到@LqkConditionalOnClass中的value属性，然后用类加载器进行加载，如果加载
 * 到了所指定的这个类，那就表示符合条件，如果加载不到，则表示不符合条件。
 **/
public class LqkCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(LqkConditionalOnClass.class.getName());
        String className = (String) annotationAttributes.get("value");

        try {
            context.getClassLoader().loadClass(className);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }

    }
}
