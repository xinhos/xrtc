package cn.xrpc.client;

import cn.xrpc.registry.RegistryCenter;
import cn.xrpc.dto.Request;
import org.springframework.beans.factory.annotation.Autowired;

public class SocketClient implements Client{
    @Autowired
    private RegistryCenter registryCenter;

    @Override
    public Object sendRequest(Request request) {
        return null;
    }
}
