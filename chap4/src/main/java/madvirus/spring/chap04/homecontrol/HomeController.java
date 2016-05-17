package madvirus.spring.chap04.homecontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.util.List;

/*
스프링 2.5부터 클래스패스에 위치한 클래스를 검색하여 툭정한 어노테이션이 붙은 클래스를 자동으로 빈으로 등록해주는 기능을 제공한다
- @Repository
- @Service
- @Component
- @Controller
 */
@Component("homeController")
public class HomeController {

    private AlarmDevice alarmDevice;
    private Viewer viewer;

    /*
     @Autowired는 타입으로 참조할 빈을 찾았을 때 injection이 일어난다
     @Resource의 경우는 bean name으로 의존 주입을 하고자하는 경우에 사용된다
     스프링에서는 의존하는 빈 객체를 전달할 때 사용된다
     */
    @Resource(name = "camera1")
    private Camera camera1;

    @Resource(name = "camera2")
    private Camera camera2;

    @Resource(name = "camera3")
    private Camera camera3;

    private Camera camera4;

    private List<InfraredRaySensor> sensors;

    /*
    자동 설정할 타입이 2개 이상 (동일한 타입) 존재할 경우, Qualifier 어노테이션을 설정해서 빈 객체들중에서 특정 빈을 사용하도록 설정한다
    - 아래 코드는 recorder 맴버 필드에 Recorder 타입의 빈 객체를 자동 연결하는데 수식어가 'main'인 빈 객체를 연결한다는 것을 의미함
    todo: Qualifier 어노테이션을 정확하게 언제 왜 사용하는지가 중요함. 확인 필요
     */
    @Autowired
    @Qualifier("main")
    private Recorder recorder;

    private DisplayStrategy displayStrategy;

    /*
    프로퍼티 설정 메서드(ex. setXXX)뿐만이 아니라 일반 메서드에도 적용 가능하다
    - 의미: 스프링은 HomeController 객체를 생성할 때 prepare() 메서드에 AlarmDevice 타입의 빈 객체와 Viewer 타입의 빈 객체를 전달한다
     */
    @Autowired
    public void prepare(AlarmDevice alarmDevice, Viewer viewer) {
        this.alarmDevice = alarmDevice;
        this.viewer = viewer;
    }

    /*
     생성자나 메서드가 2개 이상의 파라미터를 갖는 경우 Qualifier 어노테이션을 각 파라미터에 적용함으로써 각 파라미터에 전달되는 빈 객체를 한정할 수도 있다
     */
//    @Autowired
//    public void prepare2(AlarmDevice alarmDevice, @Qualifier("center") Viewer viewer) {
//        this.alarmDevice = alarmDevice;
//        this.viewer = viewer;
//    }

    /*
    required = false로 하면 프로퍼티를 반드시 설정할 필요가 없다는 의미임
     */
    @Autowired(required = false)
    @Qualifier("intrusionDetection")
    public void setSensors(List<InfraredRaySensor> sensors) {
        this.sensors = sensors;
        for (InfraredRaySensor sensor : sensors) {
            System.out.println("���� ���: " + sensor);
        }
    }

    public void setCamera1(Camera camera1) {
        this.camera1 = camera1;
    }

    public void setCamera2(Camera camera2) {
        this.camera2 = camera2;
    }

    public void setCamera3(Camera camera3) {
        this.camera3 = camera3;
    }

    @Resource(name = "camera4")
    public void setCamera4(Camera camera4) {
        this.camera4 = camera4;
    }

    public void setRecorder(Recorder recorder) {
        this.recorder = recorder;
    }

    @Resource(name = "displayStrategy")
    public void setDisplayStrategy(DisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }

    /*
    의존하는 객체를 설정한 이후에 초기화 작업을 수행할 메서드에 적용함
     */
    @PostConstruct
    public void init() {
        //초기화 처리
        System.out.println("init");
        viewer.add(camera1);
        viewer.add(camera2);
        viewer.add(camera3);
        viewer.add(camera4);
    }

    /*
    컨테이너에서 객체를 제거하기 전에 호출 될 메서드에 적용됨
     */
    @PreDestroy
    public void close() {
        System.out.println("close");
        //자원 반환 등 종료 처리
    }

    public void checkSensorAndAlarm() {
        for (InfraredRaySensor sensor : sensors) {
            if (sensor.isObjectFounded()) {
                alarmDevice.alarm(sensor.getName());
            }
        }
    }

    public void showCameraImage() {
        viewer.draw();
    }
}
