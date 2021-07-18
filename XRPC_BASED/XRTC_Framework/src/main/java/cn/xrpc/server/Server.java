package cn.xrpc.server;

import cn.xrpc.dto.ResposeDTO;

public interface Server {
    void sendResponse(ResposeDTO respose);
}
