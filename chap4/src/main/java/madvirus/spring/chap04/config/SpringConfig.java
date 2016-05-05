package madvirus.spring.chap04.config;

import madvirus.spring.chap04.homecontrol.*;
import madvirus.spring.chap04.work.Executor;
import madvirus.spring.chap04.work.Worker;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringConfig {

    @Bean
    public Camera camera1() {
        return new Camera();
    }

    @Bean
    public Camera camera2() {
        return new Camera();
    }

    @Bean
    public Camera camera3() {
        return new Camera();
    }

    @Bean
    public Camera camera4() {
        return new Camera();
    }

    @Bean
    public InfraredRaySensor windowSensor() {
        return new InfraredRaySensor("â ����");
    }

    @Bean
    public InfraredRaySensor doorSensor() {
        return new InfraredRaySensor("�� ����");
    }

    @Bean
    public InfraredRaySensor lampSensor() {
        return new InfraredRaySensor("�� ����");
    }

    @Bean
    public AlarmDevice alarmDevice() {
        return new SmsAlarmDevice();
    }

    @Bean
    public Viewer viewer() {
        MonitorViewer viewer = new MonitorViewer();
        viewer.setDisplayStrategy(displayStrategy());
        return viewer;
    }

    @Bean
    public DisplayStrategy displayStrategy() {
        return new DefaultDisplayStrategy();
    }

    @Bean
    @Qualifier("main")
    public Recorder recorder() {
        return new Recorder();
    }

    @Bean(initMethod = "init")
    public HomeController homeController() {
        HomeController homeController = new HomeController();

        List<InfraredRaySensor> sensors = new ArrayList<InfraredRaySensor>();
        sensors.add(windowSensor());
        sensors.add(doorSensor());
        homeController.setSensors(sensors);
        homeController.prepare(alarmDevice(), viewer());

        homeController.setCamera1(camera1());
        homeController.setCamera2(camera2());
        homeController.setCamera3(camera3());
        homeController.setCamera4(camera4());

        return homeController;
    }

    @Bean
    public Executor executor() {
        Executor executor = new Executor();
        executor.setWorker(worker());
        return executor;
    }

    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Worker worker() {
        return new Worker();
    }
}
