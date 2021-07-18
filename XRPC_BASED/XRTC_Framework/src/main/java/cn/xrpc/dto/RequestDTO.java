package cn.xrpc.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class RequestDTO {
    private String id;
    private String interfaceName;
    private String methodName;
    private Class<?> paramTypes;
    private Object[] parameters;
}
