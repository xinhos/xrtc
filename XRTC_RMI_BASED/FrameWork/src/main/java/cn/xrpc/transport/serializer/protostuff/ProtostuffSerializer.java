package cn.xrpc.transport.serializer.protostuff;

import cn.xrpc.transport.serializer.Serializer;

public class ProtostuffSerializer implements Serializer {
    @Override
    public byte[] serialize(Object obj) {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] src, Class<T> tClass) {
        return null;
    }
}