package madvirus.spring.chap04;

import madvirus.spring.chap04.homecontrol.HomeController;
import madvirus.spring.chap04.homecontrol.InfraredRaySensor;
import madvirus.spring.chap04.work.Executor;
import madvirus.spring.chap04.work.WorkUnit;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {

    public static void main(String[] args) {
        String[] configLocations = new String[]{"applicationContextAnnotation.xml"};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);
        context.registerShutdownHook();

        Executor executor = context.getBean("executor", Executor.class);
        executor.addUnit(new WorkUnit());
        executor.addUnit(new WorkUnit());

        HomeController homeControl = context.getBean("homeController",
                HomeController.class);

        homeControl.checkSensorAndAlarm();

        InfraredRaySensor doorSensor = context.getBean("doorSensor",
                InfraredRaySensor.class);
        doorSensor.foundObject();

        homeControl.showCameraImage();
        homeControl.checkSensorAndAlarm();

    }
}
