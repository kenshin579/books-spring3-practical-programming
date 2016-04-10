package madvirus.spring.chap02;

public class SystemMonitor {

    private long periodTime;
    private SmsSender sender;

    public void setPeriodTime(long periodTime) {
        this.periodTime = periodTime;
    }

    public void setSender(SmsSender smsSender) {
        this.sender = smsSender;
    }

    @Override
    public String toString() {
        return "SystemMonitor [periodTime=" + periodTime + ", sender=" + sender
                + "]";
    }

}
