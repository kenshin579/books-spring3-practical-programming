package madvirus.spring.chap06.common;

public class CommonLoggerImpl implements CommonLogger {

    @Override
    public void log(String message) {
        System.out.println("CommonLogger - " + message);
    }

}
