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
        return new InfraredRaySensor("창 센서");
    }

    @Bean
    public InfraredRaySensor doorSensor() {
        return new InfraredRaySensor("현관 센서");
    }

    @Bean
    public InfraredRaySensor lampSensor() {
        return new InfraredRaySensor("전등 센서");
    }

    /*
    @Bean 어노테이션은 새로운 빈 객체를 제공할 때 사용되며 @Bean이 적용된 메서드의 이름을 빈의 식별값으로 사용한다.
    - XML 설정과 동일한 빈을 정의한다.
    <bean id="alarmDevice" class="madvirus.spring.chap04.homecontrol.SmsAlarmDevice"/>
     */
    @Bean
//    @Bean(name = "smsAlarmDevice")
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

    /*
    todo: proxyMode 잘 이해 안됨
     */
    @Bean
    @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Worker worker() {
        return new Worker();
    }
}
