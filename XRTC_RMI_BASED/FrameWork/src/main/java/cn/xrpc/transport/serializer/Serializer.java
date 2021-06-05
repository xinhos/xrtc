package cn.xrpc.transport.serializer;

public interface Serializer {
    byte[] serialize(Object obj);

    <T> T deserialize(byte[] src, Class<T> tClass);
}
