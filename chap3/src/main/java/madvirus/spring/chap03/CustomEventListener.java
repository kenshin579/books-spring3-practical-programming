package madvirus.spring.chap03;

import org.springframework.context.ApplicationListener;

public class CustomEventListener implements ApplicationListener<MemberRegistrationEvent> {

    public void onApplicationEvent(MemberRegistrationEvent event) {
        //publishEvent() 메서드 호출로 onApplicationEvent() 메서드가 호출됨
        System.out.println("CustomEventListener: " + event.getMember());
    }

}
