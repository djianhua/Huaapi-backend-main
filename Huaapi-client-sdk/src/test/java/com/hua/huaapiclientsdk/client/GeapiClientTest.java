package com.hua.huaapiclientsdk.client;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.junit.jupiter.api.Test;

import java.net.HttpCookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class HuaapiClientTest {

    @Test
    void getdyGirlGet() {
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/api-dy-girl/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        System.out.println(httpResponse.body());
    }
}
