package com.xinhos.rmi_api;

import java.rmi.Remote;
import java.rmi.RemoteException;

// 之所以要单独的抽离出一个api模块，是为了客户端、服务端解耦。
public interface Action extends Remote {
    public String sayHello(String name) throws RemoteException;
}
