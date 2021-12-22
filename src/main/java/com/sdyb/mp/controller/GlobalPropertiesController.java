package com.sdyb.mp.controller;

import com.sdyb.mp.config.GlobalPropertiesConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalPropertiesController {

    /**
     * 请求地址：http://localhost:8888/getGlobalProperties
     * @return name+age
     */
    @GetMapping("getGlobalProperties")
    public String getGlobalPropertiesConfig(){
        return GlobalPropertiesConfig.getName()+" "+ GlobalPropertiesConfig.getAge()+"/////////////";
    }

}
