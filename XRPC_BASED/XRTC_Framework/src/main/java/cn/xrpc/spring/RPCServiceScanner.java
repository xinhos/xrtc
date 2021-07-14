package cn.xrpc.spring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;

public class RPCServiceScanner extends ClassPathBeanDefinitionScanner {

    public RPCServiceScanner(BeanDefinitionRegistry registry, Class<? extends Annotation>  annotationType) {
        super(registry);
        super.addIncludeFilter(new AnnotationTypeFilter(annotationType));
    }
}
