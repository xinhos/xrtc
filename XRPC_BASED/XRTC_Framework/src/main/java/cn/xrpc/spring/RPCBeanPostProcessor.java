package cn.xrpc.spring;

import cn.xrpc.annotation.RPCService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.NonNull;

public class RPCBeanPostProcessor implements BeanPostProcessor {
    /* 前处理针对server，将RPC service注册到zookeeper中 */
    @Override
    public Object postProcessBeforeInitialization(Object bean, @NonNull String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(RPCService.class)) {

        }
        return bean;
    }

    /* 后处理针对client，从zookeeper中发现服务 */
    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        return bean;
    }
}
