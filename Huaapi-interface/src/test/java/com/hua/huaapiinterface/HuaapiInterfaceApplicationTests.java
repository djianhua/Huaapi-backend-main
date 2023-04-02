package com.hua.huaapiinterface;

import com.hua.huaapiclientsdk.client.HuaapiClient;
import com.hua.huaapiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class HuaapiInterfaceApplicationTests {

    @Resource
    HuaapiClient huaapiClient;
    @Test
    void contextLoads() {
        User user = new User();
        user.setUserName("hua");
        String huaGet = huaapiClient.getNameByGet(user);
        String userNameByPost = huaapiClient.getUserNameByPost(user);
        System.out.println(huaGet);
        System.out.println(userNameByPost);
    }

}
