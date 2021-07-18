package cn.xrpc.annotation;

import cn.xrpc.spring.PackageScannerRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/* 扫描指定路径下的RTCService */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(PackageScannerRegister.class)
public @interface RPCServiceScan {
    String[] basePackages();
}
