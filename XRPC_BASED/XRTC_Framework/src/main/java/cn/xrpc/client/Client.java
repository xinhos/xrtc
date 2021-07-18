package cn.xrpc.client;

import cn.xrpc.dto.RequestDTO;

public interface Client {
    Object sendRequest(RequestDTO requestDTO);
}
