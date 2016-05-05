package madvirus.spring.chap04;

import madvirus.spring.chap04.homecontrol.HomeController;
import madvirus.spring.chap04.homecontrol.InfraredRaySensor;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainConfigAutowired {

    public static void main(String[] args) {
        String[] configLocations = new String[]{"applicationContextJavaConfigAutowired.xml"};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);
        context.registerShutdownHook();

        HomeController homeControl = context.getBean("homeController",
                HomeController.class);

        homeControl.checkSensorAndAlarm();

        InfraredRaySensor doorSensor = context.getBean("doorSensor",
                InfraredRaySensor.class);
        doorSensor.foundObject();

        homeControl.checkSensorAndAlarm();
    }
}
