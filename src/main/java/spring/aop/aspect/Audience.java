package spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面类 多为辅助功能类
 *
 * @author Jae
 */
@Aspect
public class Audience {

    @Pointcut("execution(* spring.aop.Performance.perform(..))")
    public void performance() {

    }

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("Silencing cell phones");
            System.out.println("Taking Seats");
            joinPoint.proceed();
            System.out.println("CLAP~");
        } catch (Throwable e) {
            System.out.println("Demanding a refund");
        }
    }

}
