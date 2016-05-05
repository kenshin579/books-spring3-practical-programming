package madvirus.spring.chap02;

import java.util.Properties;

/**
 * Created by ykoh on 2016. 4. 15..
 */
public class BookClient {
    private Properties config;

    public void setConfig(Properties config) {
        this.config = config;
    }

    public void connect() {
        String serverIp = config.getProperty("server");
        System.out.println("serverIp: " + serverIp);
    }
}
