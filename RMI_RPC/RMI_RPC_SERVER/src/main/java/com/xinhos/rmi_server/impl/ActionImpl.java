package com.xinhos.rmi_server.impl;

import com.xinhos.rmi_api.Action;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// 在服务端攥写可供远程调用的方法，从解耦的角度考虑，将所有的服务接口单独剥离出来，服务端通一实现即可。
public class ActionImpl extends UnicastRemoteObject implements Action{
    public ActionImpl() throws RemoteException { }

    @Override
    public String sayHello(String name) throws RemoteException {
        System.out.printf("hello %s, i'm server A001, i receive your call.\n", name);
        return String.format("A001 respose %s at %d", name, System.currentTimeMillis());
    }
}
