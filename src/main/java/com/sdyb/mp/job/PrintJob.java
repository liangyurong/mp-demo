//package com.sdyb.mp.job;
//
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import java.util.Date;
//
//@Component
//@EnableAsync
//public class PrintJob {
//
//    /** 该@Async注解是可以指定使用哪个线程池的。这样就可以在不同的线程池中执行不同的定时任务了 */
//    @Scheduled(fixedRate = 3000)
//    @Async("executor1")
//    public void printTest1(){
//        p1();
//        p2();
//    System.out.println("--------------------");
//    }
//
//    @Scheduled(fixedRate = 3000)
//    @Async("executor2")
//    public void printTest2(){
//        System.out.println("2 run --> "+new Date()+" "+Thread.currentThread().getName());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("2 end --> "+new Date());
//    }
//
//
//    private void p1(){
//
//        System.out.println("ppppppppp1111111111111111111111"+new Date()+" "+Thread.currentThread().getName());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private void p2(){
//        System.out.println("ppp22222222222"+new Date()+" "+Thread.currentThread().getName());
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
