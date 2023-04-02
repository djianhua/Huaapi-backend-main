package com.hua.huaapi.model.dto.interfaceinfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/JianHuaDeng">程序员Hua</a>
 */
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    private Long id;

    /**
     * 请求参数
     */
    private String userRequestParams;

    /**
     * 请求头
     */
    private String requestHeader;

    /**
     * 响应头
     */
    private String responseHeader;

    /**
     * 请求类型
     */
    private String method;


    private static final long serialVersionUID = 1L;
}
