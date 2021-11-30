package com.sdyb.mp.util;

import java.time.LocalDateTime;

/**
 * 日期工具
 */
public class DateUtils {

    /**
     * 日期与今天相比，是否过期
     *
     * 过期，return true
     * 不过期，return false
     */
    public static boolean isExpired(LocalDateTime expireTime){

        LocalDateTime today = LocalDateTime.now();

        if(expireTime.isAfter(today)){
            return false;
        }

        return true;
    }

}
