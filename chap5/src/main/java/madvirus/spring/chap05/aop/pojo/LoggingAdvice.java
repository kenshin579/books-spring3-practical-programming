package madvirus.spring.chap05.aop.pojo;

public class LoggingAdvice {

    public void before() {
        System.out.println("[LA] �޼��� ���� �� ��ó�� ����");
    }

    public void afterReturning(Object ret) {
        System.out.println("[LA] �޼��� ���� �� ��ó�� ����, ���ϰ�=" + ret);
    }

    public void afterThrowing(Throwable ex) {
        System.out.println("[LA] �޼��� ���� �� ���� �߻�, ����=" + ex.getMessage());
    }

    public void afterFinally() {
        System.out.println("[LA] �޼��� ���� �Ϸ�");
    }

}
