package madvirus.spring.chap02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainHierachy {
    public static void main(String[] args) {
        String[] parentConfigLocations = new String[]{"parent.xml"};
        AbstractApplicationContext parentContext = new ClassPathXmlApplicationContext(
                parentConfigLocations);

        String[] childConfigLocations = new String[]{"child.xml"};
        AbstractApplicationContext childContext = new ClassPathXmlApplicationContext(
                childConfigLocations, parentContext); //부모 컨테이너 지정

        SmsSender parentSender = parentContext.getBean("smsSender", SmsSender.class);
        SmsSender childSender = childContext.getBean("smsSender", SmsSender.class);

        System.out.println("parentSender == childSender : " + (parentSender == childSender));
        SystemMonitor monitor = childContext.getBean("monitor", SystemMonitor.class);
        System.out.println(monitor);
    }

}
