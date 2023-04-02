package com.hua.huaapi.model.vo;

import com.hua.huaapicommon.model.entity.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接口信息封装视图
 *
 * @author yupi
 * @TableName product
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInterfaceVO extends User {

    /**
     * 调用次数
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;

}
