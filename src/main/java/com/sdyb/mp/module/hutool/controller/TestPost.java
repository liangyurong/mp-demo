package com.sdyb.mp.module.hutool.controller;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hutool")
public class TestPost {

    @PostMapping("hutoolPost")
    public String testPost(@RequestParam("id")String id,@RequestParam("name")String name){
        return "id="+id+" name="+name;
    }

    // 普通表单
    @GetMapping("testPost")
    public String testpost(){

        String url = "http://localhost:8888/hutool/hutoolPost";
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",1);
        paramMap.put("name","yurong");

        String result = HttpRequest.post(url)
                .header(Header.USER_AGENT, "Hutool http")//头信息，多个头信息多次调用此方法即可
                .form(paramMap)//表单内容
                .timeout(20000)//超时，毫秒
                .execute().body();
        return result;
    }

    @PostMapping("hutoolPost1")
    public String testPost(@RequestBody JSONObject json){
        return "id="+json.getString("id")+" name="+ json.getString("name");
    }

    // 请求是json
    @GetMapping("testPost1")
    public String testpost1(){

        // 请求路径
        String url = "http://localhost:8888/hutool/hutoolPost1";

        // map封装请求参数
        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("id",1);
        paramMap.put("name","yurong123");

        // 将map转为json形式的字符串
        String json = JSONObject.toJSONString(paramMap);

        String result = HttpRequest.post(url)
                // .header("","") // 添加请求头
                .body(json)
                .timeout(20000)
                .execute().body();
        return result;

    }

    // 获取客户端ip
    @GetMapping("/getClientIp")
    public String getClientIp(HttpServletRequest request){

        String clientIP = ServletUtil.getClientIP(request);
        return clientIP;
    }

}
