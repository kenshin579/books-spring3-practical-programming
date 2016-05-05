package madvirus.spring.chap03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        String[] configLocations = new String[]{"applicationContext.xml"};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);

        //종료 훅을 등록한다
        //- 종료 훅을 등록함으로써 안정적인 종료를 보장하고 모든 리소스를 릴리즈하기 위해 싱글톤 빈의 적절한 파괴 메서드를 호출한다.
        //- 물론 여전히 이러한 파괴 콜백을 적절하게 설정하고 구현해야 한다
        context.registerShutdownHook();

/*
        빈 객체에서 메시지 사용하는 방법 2가지
		1. ApplicationContextAware 인터페이스를 구현하는 방법 (바로 아래 구현)
		- 참고: https://github.com/kenu/springstudy2013/blob/master/0325/1.SpringMessageSource.md
		 */

        Locale locale = Locale.getDefault();
        String greeting = context.getMessage("greeting", new Object[0], locale); //ApplicationContextAware에서 message 사용하는 방법
        System.out.println("Default Locale Greeting: " + greeting);

        Locale englishLocale = Locale.ENGLISH;
        String englishGreeting = context.getMessage("greeting", new Object[0],
                englishLocale);
        System.out.println("English Locale Greeting: " + englishGreeting);


        LoginProcessorUsingApplicationContextAware loginProcessorUsingApplicationContextAware = context.getBean("loginProcessorUsingApplicationContextAware",
                LoginProcessorUsingApplicationContextAware.class);
        try {
            loginProcessorUsingApplicationContextAware.login("madvirus2", "1234");
        } catch (Throwable e) {
            System.out.println(": " + e.getMessage());
        }

        /*
        2. MessageSourceAware 사용방법 예제
        - todo: setMessageSource가 여기 실행하기전에 이미 세팅을 하는데, 어떤 MessageSource로 세팅이 되는지 이해가 안됨
         */
        LoginProcessorUsingMessageSourceAware loginProcessorUsingMessageSourceAware = context.getBean("loginProcessorUsingMessageSourceAware",
                LoginProcessorUsingMessageSourceAware.class);
        try {
            loginProcessorUsingMessageSourceAware.login("madvirus2", "1234");
        } catch (Throwable e) {
            System.out.println(": " + e.getMessage());
        }

        /*
        스프링 컨텍스트 이벤트
        - ApplicationContext는 publishEvent() 메서드 이용해서 이벤트를 발생시킬 수 있다
        -
         */
        MemberService memberService = context.getBean("memberService", MemberService.class);
        memberService.regist(new Member("madvirus", "홍길동"));
    }
}
