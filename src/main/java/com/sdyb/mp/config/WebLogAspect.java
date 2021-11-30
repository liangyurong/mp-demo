package com.sdyb.mp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

@Aspect
@Component
public class WebLogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 切面，监控public * com.lyr.demo.controller..*.*(..))
    // 2021-10-20 只能监控单一的controller，如果有多个模块，那么无法统一监控到多个模块中的controller
    // 改进建议：使用自定义注解
    @Pointcut("execution(public * com.sdyb.mp.controller..*.*(..))")
    public void webLog() {
    }

    @Before(value = "webLog()")
    public void doBefore(JoinPoint joinPoint) {

        // 接收到请求，记录请求内容
        logger.info("\n");
        logger.info("================== API start："+joinPoint.getSignature().getName()+"  ===================");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        logger.info("请求的URL : " + request.getRequestURL().toString());
        logger.info("请求的类型 : " + request.getMethod());
        logger.info("请求的IP : " + request.getRemoteAddr());
        logger.info("请求的参数: " + Arrays.toString(joinPoint.getArgs()));
        logger.info("参数 : ");
        //获取所有参数方法一：
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            logger.info("参数： "+paraName + ": " + request.getParameter(paraName));
        }
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) {
        // 处理完请求，返回内容
        logger.info("返回的参数 : " + ret);
        logger.info("=================   API end："+joinPoint.getSignature().getName()+"  ======================");
    }
}
