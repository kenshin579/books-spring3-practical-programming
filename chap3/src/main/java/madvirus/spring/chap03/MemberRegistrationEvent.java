package madvirus.spring.chap03;

import org.springframework.context.ApplicationEvent;

@SuppressWarnings("serial")
public class MemberRegistrationEvent extends ApplicationEvent {

    private Member member;

    public MemberRegistrationEvent(Object source, Member member) {
        super(source);
        System.out.println("MemberRegistrationEvent...");
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

}
