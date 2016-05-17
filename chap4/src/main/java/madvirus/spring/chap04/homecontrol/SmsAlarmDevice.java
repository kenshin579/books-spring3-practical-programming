package madvirus.spring.chap04.homecontrol;

import org.springframework.stereotype.Component;

@Component("smsAlarmDevice")
public class SmsAlarmDevice implements AlarmDevice {

    public void alarm(String name) {
        System.out.println(name + "���� ħ�� Ž��");
    }

}
