package cn.xrpc.transport.client;

import cn.xrpc.transport.dto.Request;

public interface Client {
    public Object sendRequest(Request request);
}
