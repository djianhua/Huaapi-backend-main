package com.hua.huaapicommon.service;

import com.hua.huaapicommon.model.entity.User;

/**
* @author MA_dou
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-03-13 20:40:10
*/
public interface InnerUserService{

    /**
     * 从数据库中查询已经分配的密钥（accessKey，secretKey）
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);

}
