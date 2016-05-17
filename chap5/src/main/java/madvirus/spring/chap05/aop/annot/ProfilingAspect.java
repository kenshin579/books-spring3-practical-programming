package madvirus.spring.chap05.aop.annot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(3)
public class ProfilingAspect {

    @Pointcut("execution(public * madvirus.spring.chap05.board..*(..))")
    private void profileTarget() {
    }

    @Around("profileTarget()")
    public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
        String signatureString = joinPoint.getSignature().toShortString();
        System.out.println(signatureString + " ����");
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            return result;
        } finally {
            long finish = System.currentTimeMillis();
            System.out.println(signatureString + " ����");
            System.out.println(signatureString + " ���� �ð� : " + (finish - start)
                    + "ms");
        }
    }
}
