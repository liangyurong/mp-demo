package com.sdyb.mp.module.hutool.controller;

import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/hutool")
public class TestGet {

    @GetMapping("hutoolGet")
    public String forTest(@RequestParam("id")String id, @RequestParam("name")String name){
        return "id="+id+" name="+name;
    }

    // 使用HttpUtil调用上面的test接口
    @GetMapping("testget1")
    public String testget1(){

        String url = "http://localhost:8888/hutool/hutoolGet";

        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        map.put("name","hutool get test");

        String result = HttpUtil.get(url, map);
        return result;
    }


}
