package madvirus.spring.chap02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainConfigurer {
    public static void main(String[] args) {
        String[] configLocations = new String[]{"applicationContextConfigurer.xml"};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);
        context.registerShutdownHook();

        DataSourceFactory dataSourceFactory = context.getBean(
                "dataSourceFactory", DataSourceFactory.class);

        System.out.println(dataSourceFactory.toString());
    }

}
