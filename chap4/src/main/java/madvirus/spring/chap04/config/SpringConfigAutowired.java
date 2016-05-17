package madvirus.spring.chap04.config;

import madvirus.spring.chap04.homecontrol.*;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigAutowired {

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
    @Qualifier("intrusionDetection")
    public InfraredRaySensor windowSensor() {
        return new InfraredRaySensor("창 센서");
    }

    @Bean
    @Qualifier("intrusionDetection")
    public InfraredRaySensor doorSensor() {
        return new InfraredRaySensor("현관 센서");
    }

    @Bean
    public InfraredRaySensor lampSensor() {
        return new InfraredRaySensor("전등 센서");
    }

    @Bean
    public AlarmDevice alarmDevice() {
        return new SmsAlarmDevice();
    }

    @Bean
    public Viewer viewer() {
        return new MonitorViewer();
    }

    @Bean(autowire = Autowire.BY_NAME)
    public HomeController homeController() {
        return new HomeController();
    }

    @Bean
    @Qualifier("main")
    public Recorder recorder() {
        return new Recorder();
    }

    @Bean
    public DisplayStrategy displayStrategy() {
        return new DefaultDisplayStrategy();
    }
}
