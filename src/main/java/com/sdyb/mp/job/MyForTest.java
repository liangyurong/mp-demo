package com.sdyb.mp.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class MyForTest {

    /** 该@Async注解是可以指定使用哪个线程池的 */
    @Async("executor1")
    public void printTest(int num){
        soutTest(num);
    }

    // 这里传递的num数值：0 1 2 3 4 5 6 7 8
    public  void soutTest(int num){
        int start = num*100;
        int end = (num+1)*100;
        for (int i = start; i < end; i++) {
            int tmp = i+1;
            System.out.println("当前线程："+Thread.currentThread().getName()+" , tmp="+tmp);
        }
    }

}
