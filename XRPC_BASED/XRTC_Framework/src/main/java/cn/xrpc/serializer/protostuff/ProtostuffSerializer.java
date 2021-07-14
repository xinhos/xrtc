package cn.xrpc.serializer.protostuff;

import cn.xrpc.serializer.Serializer;

public class    ProtostuffSerializer implements Serializer {
    @Override
    public byte[] serialize(Object obj) {
        return new byte[0];
    }

    @Override
    public <T> T deserialize(byte[] src, Class<T> tClass) {
        return null;
    }
}
