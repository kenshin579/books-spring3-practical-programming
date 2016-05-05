package madvirus.spring.chap04;

import madvirus.spring.chap04.config.SpringConfig;
import madvirus.spring.chap04.homecontrol.HomeController;
import madvirus.spring.chap04.homecontrol.InfraredRaySensor;
import madvirus.spring.chap04.work.Executor;
import madvirus.spring.chap04.work.WorkUnit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainConfig {

    public static void main(String[] args) {
        ApplicationContext context = makeContextByXml();
        run(context);

        context = makeContextByClass();
        run(context);
    }

    private static ApplicationContext makeContextByClass() {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class);
        context.registerShutdownHook();
        return context;
    }

    private static void run(ApplicationContext context) {
        HomeController homeControl = context.getBean("homeController",
                HomeController.class);

        homeControl.checkSensorAndAlarm();

        InfraredRaySensor doorSensor = context.getBean("doorSensor",
                InfraredRaySensor.class);
        doorSensor.foundObject();

        homeControl.checkSensorAndAlarm();

        Executor executor = context.getBean("executor", Executor.class);
        executor.addUnit(new WorkUnit());
        executor.addUnit(new WorkUnit());
        executor.addUnit(new WorkUnit());
    }

    private static ApplicationContext makeContextByXml() {
        String[] configLocations = new String[]{"applicationContextJavaConfig.xml"};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);
        context.registerShutdownHook();
        return context;
    }
}
