package madvirus.spring.chap04.homecontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("viewer")
public class MonitorViewer implements Viewer {

    @Autowired
    private DisplayStrategy displayStrategy;

    public void setDisplayStrategy(DisplayStrategy displayStrategy) {
        this.displayStrategy = displayStrategy;
    }

    @Override
    public void draw() {
        System.out.println("DisplayType "
                + displayStrategy.getDisplayType().name() + "�� ī�޶� �̹��� ���");
    }

    @Override
    public void add(Camera camera) {
        System.out.println("MonitorViewer�� " + camera + " ���� �߰�");
    }

}
