package com.hua.huaapicommon.service;

import com.hua.huaapicommon.model.entity.InterfaceInfo;

/**
* @author MA_dou
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2023-03-13 20:40:10
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询接口是否存在(请求路径，请求方法)
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path,String method);
}
