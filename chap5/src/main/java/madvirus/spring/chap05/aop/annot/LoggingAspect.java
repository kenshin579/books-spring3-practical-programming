package madvirus.spring.chap05.aop.annot;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class LoggingAspect {

    @Before("PublicPointcut.publicMethod()")
    public void before() {
        System.out.println("[LA] �޼��� ���� �� ��ó�� ����");
    }

    @AfterReturning(
            pointcut = "madvirus.spring.chap05.aop.annot.PublicPointcut.publicMethod()",
            returning = "ret")
    public void afterReturning(Object ret) {
        System.out.println("[LA] �޼��� ���� �� ��ó�� ����, ���ϰ�=" + ret);
    }

    @AfterThrowing(
            pointcut = "madvirus.spring.chap05.aop.annot.PublicPointcut.publicMethod()",
            throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("[LA] �޼��� ���� �� ���� �߻�, ����=" + ex.getMessage());
    }

    @After("madvirus.spring.chap05.aop.annot.PublicPointcut.publicMethod()")
    public void afterFinally() {
        System.out.println("[LA] �޼��� ���� �Ϸ�");
    }

}
