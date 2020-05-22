package cn.system.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component("logger")
@Aspect//当前类是一个切面类
public class Logger {
    @Pointcut("execution(* cn.system.service.impl.*ServiceImpl.*(..))")
    private  void  pt1(){}

    @Before("pt1()")
    public void beforePrintLogger(){
        System.out.println("before");
    }
    @AfterReturning("pt1()")
    public  void afterReturningLogger(){
        System.out.println("after return");
    }
    @AfterThrowing("pt1()")
    public void afterErrorLogger(){
        System.out.println("after Error");
    }
    @After("pt1()")
    public  void afterLogger(){
        System.out.println("after");
    }
    @Around("pt1()")
    public  void aroundLogger(){
        System.out.println("around");
    }

}
