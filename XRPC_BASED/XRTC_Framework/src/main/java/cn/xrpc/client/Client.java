package cn.xrpc.client;

import cn.xrpc.dto.Request;

public interface Client {
    Object sendRequest(Request request);
}
