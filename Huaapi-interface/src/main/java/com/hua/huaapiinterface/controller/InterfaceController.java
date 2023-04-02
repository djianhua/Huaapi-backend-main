package com.hua.huaapiinterface.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.hua.huaapiclientsdk.model.LoveWords;
import com.hua.huaapiclientsdk.model.User;

import com.hua.huaapiinterface.mapper.LoveWordsMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class InterfaceController {

    @Resource
    private LoveWordsMapper loveWordsMapper;

    @PostMapping("/user")
    public String getUserNameByGet(@RequestBody User user, HttpServletRequest request){
        String result = "POST 用户名字是" + user.getUserName();
        return result;
    }
    @GetMapping("/lovewords")
    public String getLoveWordsGet(@RequestBody LoveWords loveWords){
        //todo 根据type返回不同格式的数据
        String loveWord = loveWordsMapper.getRandomLoveWords();
        return loveWord;
    }

    @GetMapping("/godreply")
    public String getGodReply(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/api-wenan-shenhuifu/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        return httpResponse.body();
    }

    @GetMapping("/dygirl")
    public String getdyGirlGet(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://zj.v.api.aa1.cn/api/video_dyv2")
                .addHeaders(map)
                .execute();
        String location = httpResponse.header("Location");
        HttpResponse httpResponse1 = HttpRequest.get(location).execute();
        return httpResponse1.body();
    }

    @GetMapping("/lickDog")
    public String getLickDog(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/tiangou/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        return httpResponse.body();
    }

    @GetMapping("/badsaying")
    public String getSaying(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/api-wenan-dujitang/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        return httpResponse.body();
    }

    @GetMapping("/pcgirl")
    public String getpcGirlGet(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/api-dy-girl/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        return httpResponse.body();
    }

    @GetMapping("/time")
    public String getTimeUsed(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://v.api.aa1.cn/api/rsdjs/index.php?aa1=json")
                .addHeaders(map)
                .execute();
        return httpResponse.body();
    }

    @GetMapping("/poem")
    public String getPoem(){
        Map<String,String> map= new HashMap<>();
        map.put("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36 Edg/111.0.1661.44");
        HttpResponse httpResponse = HttpRequest.get("https://zj.v.api.aa1.cn/api/wenan-shici/?type=json")
                .addHeaders(map)
                .execute();
        return httpResponse.body();
    }

}
