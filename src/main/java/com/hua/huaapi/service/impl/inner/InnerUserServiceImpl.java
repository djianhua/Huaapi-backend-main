package com.hua.huaapi.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hua.huaapi.common.ErrorCode;
import com.hua.huaapi.exception.BusinessException;
import com.hua.huaapi.mapper.UserMapper;
import com.hua.huaapicommon.model.entity.User;
import com.hua.huaapicommon.service.InnerUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;


@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey",accessKey);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null){
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return user;
    }
}
