package madvirus.spring.chap02;

public class PessimisticLockingFailManager {

    private int retryCount;

    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    @Override
    public String toString() {
        return "PessimisticLockingFailManager [retryCount=" + retryCount + "]";
    }

}
