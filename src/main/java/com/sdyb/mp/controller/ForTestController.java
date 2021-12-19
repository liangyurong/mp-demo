package com.sdyb.mp.controller;

import com.google.common.base.Preconditions;
import com.sdyb.mp.job.MyForTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForTestController {

    @Autowired
    private MyForTest forTest;

    @GetMapping("test")
    public void forTest(){
        // isBlank
        String str1 = null;
        Preconditions.checkNotNull(str1,"报错：参数为null");
    }

}
