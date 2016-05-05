package madvirus.spring.chap02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ykoh on 2016. 4. 15..
 */
public class MainBookClient {
    public static void main(String[] args) {
        String[] configLocations = new String[]{"propertiesContext.xml"};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);
        context.registerShutdownHook();

        BookClient bookClient = context.getBean("client", BookClient.class);
        bookClient.connect();
    }
}
