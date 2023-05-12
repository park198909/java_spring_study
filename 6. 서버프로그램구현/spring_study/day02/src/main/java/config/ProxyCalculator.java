package config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect
public class ProxyCalculator {
//    @Pointcut("execution(* exam05..*(..))")
//    //@Pointcut("execution(long exam05..*(*))")
//    public void publicTarget() {}

    //@Around("execution(* exam05..*(..))")
    @Around("CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        long stime = System.nanoTime();
        try{
            Object result = joinPoint.proceed(); // factorial() 실행

            return result;
        } finally {
            long etime = System.nanoTime();
            System.out.printf("걸린시간 : %d%n", etime-stime);
        }
    }
}
