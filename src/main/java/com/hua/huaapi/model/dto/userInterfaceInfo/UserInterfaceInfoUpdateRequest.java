package com.hua.huaapi.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

/**
 * 更新请求
 *
 * @author <a href="https://github.com/JianHuaDeng">程序员Hua</a>
 */
@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 接口 id
     */
    private Long interfaceInfoId;

    /**
     * 调用用户 id
     */
    private Long userId;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0-正常，1-禁用
     */
    private Integer status;



    private static final long serialVersionUID = 1L;
}
