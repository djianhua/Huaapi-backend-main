package com.hua.huaapi.service.impl;


import com.hua.huaapi.service.UserInterfaceInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserInterfaceInfoServiceImplTest {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Test
    void invokeCount() {
        boolean b = userInterfaceInfoService.invokeCount(24L, 1L);
        Assertions.assertTrue(b);

    }
}
