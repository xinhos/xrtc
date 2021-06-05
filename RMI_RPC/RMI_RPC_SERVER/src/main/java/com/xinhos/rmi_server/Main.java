package com.xinhos.rmi_server;

import com.xinhos.rmi_api.Action;
import com.xinhos.rmi_server.impl.ActionImpl;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

// 服务端的启动入口。在此处创建一个服务提供者（即一个Impl对象），并注册到注册中心
// main方法运行后会常驻后台，因为LocateRegistry在创建注册中心时会创建一个守护线程
public class Main {
    public static void main(String[] args) throws RemoteException, MalformedURLException {
        // 创建一个服务实现
        Action aAction = new ActionImpl();

        // 获取注册中心（在这里是新建一个注册中心，也可以引用远程注册中心）
        LocateRegistry.createRegistry(11111);

        // 将服务发布到注册中心。注册中心的服务名不允许重复，注册时有bind()和rebind()这两种
        // 方式，前者在出现同名服务时会抛出异常，后者会直接覆盖服务。
        String serverName = "action";
        Naming.rebind(String.format("rmi://localhost:11111/%s", serverName), aAction);

        System.out.print("server A001 started!");
    }
}
