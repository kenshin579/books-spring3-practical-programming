package madvirus.spring.chap04.homecontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("viewer")
public class MonitorViewer implements Viewer {

    /*
    Autowired 어노테이션은 생성자, 필드, 메서드의 세곳에 적용 가능하다
    - 아래 코드는 displayStrategy 프로퍼티에 DisplayStrategy 타입의 빈 객체를 전달한다
     */
    @Autowired
    private DisplayStrategy displayStrategy;

    public void setDisplayStrategy(DisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }

    public void draw() {
        System.out.println("DisplayType "
                + displayStrategy.getDisplayType().name() + "�� ī�޶� �̹��� ���");
    }

    public void add(Camera camera) {
        System.out.println("MonitorViewer�� " + camera + " ���� �߰�");
    }

}
