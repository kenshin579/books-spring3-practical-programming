package madvirus.spring.chap02;

/**
 * Created by ykoh on 2016. 4. 23..
 */
public class Monitor {
    public void start() {
        System.out.println("start...");
    }

    public void stop() {
        System.out.println("stop...");
    }

    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        monitor.start();
    }
}
