package cn.xrpc.transport.server;

import cn.xrpc.transport.dto.Respose;

public interface Server {
    public void sendResponse(Respose respose);
}
