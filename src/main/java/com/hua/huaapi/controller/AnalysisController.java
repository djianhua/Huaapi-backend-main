package com.hua.huaapi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hua.huaapi.annotation.AuthCheck;
import com.hua.huaapi.common.BaseResponse;
import com.hua.huaapi.common.ErrorCode;
import com.hua.huaapi.common.ResultUtils;
import com.hua.huaapi.exception.BusinessException;
import com.hua.huaapi.mapper.UserInterfaceInfoMapper;
import com.hua.huaapi.model.vo.InterfaceInfoVO;
import com.hua.huaapi.model.vo.UserInterfaceVO;
import com.hua.huaapi.service.InterfaceInfoService;
import com.hua.huaapi.service.UserService;
import com.hua.huaapicommon.model.entity.InterfaceInfo;
import com.hua.huaapicommon.model.entity.User;
import com.hua.huaapicommon.model.entity.UserInterfaceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分析控制器
 */
@RestController
@RequestMapping("/analysis")
@Slf4j
public class AnalysisController {

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Resource
    private InterfaceInfoService interfaceInfoService;

    @Resource
    private UserService userService;

    /**
     * 接口被调用次数TOP5
     * @return
     */
    @GetMapping("/top/interface/invoke")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<InterfaceInfoVO>> listTopInvokeInterfaceInfo() {
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopInvokeInterfaceInfo(5);
        Map<Long, List<UserInterfaceInfo>> interfaceInfoIdObjMap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getInterfaceInfoId));
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", interfaceInfoIdObjMap.keySet());
        List<InterfaceInfo> list = interfaceInfoService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        List<InterfaceInfoVO> interfaceInfoVOList = list.stream().map(interfaceInfo -> {
            InterfaceInfoVO interfaceInfoVO = new InterfaceInfoVO();
            BeanUtils.copyProperties(interfaceInfo, interfaceInfoVO);
            int totalNum = interfaceInfoIdObjMap.get(interfaceInfo.getId()).get(0).getTotalNum();
            interfaceInfoVO.setTotalNum(totalNum);
            return interfaceInfoVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(interfaceInfoVOList);
    }

    /**
     * 最活跃的用户TOP5
     * @return
     */
    @GetMapping("/top/interface/user")
    @AuthCheck(mustRole = "admin")
    public BaseResponse<List<UserInterfaceVO>> listTopUserInvokeInterfaceInfo() {
        List<UserInterfaceInfo> userInterfaceInfoList = userInterfaceInfoMapper.listTopUserInvokeInterfaceInfo(5);
        Map<Long, List<UserInterfaceInfo>> userIdObjMap = userInterfaceInfoList.stream()
                .collect(Collectors.groupingBy(UserInterfaceInfo::getUserId));
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("id", userIdObjMap.keySet());
        List<User> list = userService.list(queryWrapper);
        if (CollectionUtils.isEmpty(list)) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        //list为userId的信息
        //todo 只需返回用户信息即可
        List<UserInterfaceVO> interfaceInfoVOList = list.stream().map(user -> {
            UserInterfaceVO userVO = new UserInterfaceVO();
            BeanUtils.copyProperties(user, userVO);
            int totalNum = userIdObjMap.get(user.getId()).get(0).getTotalNum();
            userVO.setTotalNum(totalNum);
            return userVO;
        }).collect(Collectors.toList());
        return ResultUtils.success(interfaceInfoVOList);
    }
}


