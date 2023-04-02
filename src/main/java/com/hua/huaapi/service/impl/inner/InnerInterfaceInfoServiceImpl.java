package com.hua.huaapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hua.huaapi.common.ErrorCode;
import com.hua.huaapi.exception.BusinessException;
import com.hua.huaapi.mapper.InterfaceInfoMapper;
import com.hua.huaapicommon.model.entity.InterfaceInfo;
import com.hua.huaapicommon.service.InnerInterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;


@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    InterfaceInfoMapper interfaceInfoMapper;

    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if (StringUtils.isAnyBlank(url,method)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url",url);
        queryWrapper.eq("method",method);
        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectOne(queryWrapper);
        if (interfaceInfo == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return interfaceInfo;
    }
}
