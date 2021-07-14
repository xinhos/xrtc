package cn.xrpc.spring;

import cn.xrpc.spring.anotation.RPCService;
import cn.xrpc.spring.anotation.RPCServiceScan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;

/* 包扫描器，令spring加载时扫描用户指定路径下的RPCService注解，并扫描框架中的组件 */
@Slf4j
public class PackageScannerRegister implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private static final String COMPONENT_PACKAGE = "cn.xrpc";
    private static final String BASE_PACKAGE_NAME = "basePackages";
    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 获取RPCServiceScan注解上的basePackages属性
        String[] rpcServicePackages = new String[0];
        AnnotationAttributes rpcScanAttributes = AnnotationAttributes
                .fromMap(importingClassMetadata.getAnnotationAttributes(RPCServiceScan.class.getName()));
        if (rpcScanAttributes != null) {
            rpcServicePackages = rpcScanAttributes.getStringArray(BASE_PACKAGE_NAME);
        }
        // 如果没有配置basePackages，则默认是当前类所在的package（这样设定符合sprig约定大于配置的理念）
        if (rpcServicePackages.length == 0) {
            StandardAnnotationMetadata metadata = ((StandardAnnotationMetadata) importingClassMetadata);
            rpcServicePackages = new String[] { metadata.getIntrospectedClass().getPackage().getName() };
        }

        // 扫描注解
        RPCServiceScanner rpcServiceScanner = new RPCServiceScanner(registry, RPCService.class);
        ClassPathBeanDefinitionScanner componentScanner = new ClassPathBeanDefinitionScanner(registry);
        if (resourceLoader != null) {
            rpcServiceScanner.setResourceLoader(resourceLoader);
            componentScanner.setResourceLoader(resourceLoader);
        }
        rpcServiceScanner.scan(rpcServicePackages);  // 扫描RPCService注解
        componentScanner.scan(COMPONENT_PACKAGE);    // 扫描框架中的组件（相当于<component-scan>）

    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }
}
