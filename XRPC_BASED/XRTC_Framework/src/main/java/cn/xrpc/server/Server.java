package cn.xrpc.server;

import cn.xrpc.dto.Respose;

public interface Server {
    void sendResponse(Respose respose);
}
