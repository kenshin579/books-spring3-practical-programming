package madvirus.spring.chap03;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MemberService implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void regist(Member member) {
        applicationContext.publishEvent(new MemberRegistrationEvent(this,
                member));
    }

}
