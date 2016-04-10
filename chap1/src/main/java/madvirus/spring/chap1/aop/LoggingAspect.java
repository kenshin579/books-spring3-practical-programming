package madvirus.spring.chap1.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
    private Log log = LogFactory.getLog(getClass());

    /**
     * ProceedingJoinPoint 객체는 Aspect가 적용되는 객체 및 메서드에 대한 정보를 담고 있다
     * - 이 객체를 통해서 핵심 로직을 (즉 Aspect가 적용되는 메서드를) 실행할 수 있게 됨
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("기록 시작");
        StopWatch stopWatch = new StopWatch();
        try {
            stopWatch.start();
            Object retValue = joinPoint.proceed(); //<- 적용된 메서드 실행부분
            return retValue;
        } catch (Throwable e) {
            throw e;
        } finally {
            stopWatch.stop();
            log.info("기록 종료");
            log.info(joinPoint.getSignature().getName() + "메서드 실행 시간 : "
                    + stopWatch.getTotalTimeMillis());
        }


    }
}
