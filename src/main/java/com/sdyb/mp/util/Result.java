package com.sdyb.mp.util;

import lombok.Data;

import java.util.HashMap;

/**
 * 结果返回类
 */
@Data
public class Result extends HashMap<String, Object> {

    /** 0-成功 1-失败（非0则失败，因此传递其他数字也是可以的，比如404,403） */
    private int code=0;

    /** 返回的说明信息 */
    private String msg="";

    /** data是Object修饰的，因此能放进任何形式的东西 */
    public Object data="";

    public Result(){
        super();
        this.put("code",code);
        this.put("msg",msg);
        this.put("data",data);
    }

    @Override
    public Result put(String key, Object value){
        super.put(key,value);
        return this;
    }

    public Result putData(Object data) {
        this.put("data", data);
        return this;
    }

    public Result putMsg(String msg) {
        this.put("msg", msg);
        return this;
    }

    public Result putCode(int code) {
        this.put("code", code);
        return this;
    }

}
