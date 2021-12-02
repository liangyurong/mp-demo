package com.sdyb.mp.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.HashMap;

/**
 * 结果返回类
 */
@Data
@AllArgsConstructor
public class Result extends HashMap<String, Object>  {

    @Override
    public Result put(String key, Object value){
        super.put(key,value);
        return this;
    }

    public void putData(Object data) {
        this.put("data", data);
    }

    public void putMsg(String msg) {
        this.put("msg",msg);
    }

    public void putCode(int code) {
        this.put("code",code);
    }

}
