package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;

@Controller
public class HelloController {

    @RequestMapping("/hello.do")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        /*
        아래 코드는 뷰 이름을 hello(ex. hello.jsp)로 지정하였는데 DispatcherServlet은 이 뷰 이름과 매칭되는
         뷰 구현체를 찾기 위해 ViewResolver를 사용한다.
         */
        mav.setViewName("hello");
        mav.addObject("greeting", getGreeting());
        return mav;
    }

    private String getGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (hour >= 6 && hour <= 10) {
            return "좋은 아침입니다 ";
        } else if (hour >= 12 && hour <= 15) {
            return "점심 식사는 하셨나요?";
        } else if (hour >= 18 && hour <= 22) {
            return "좋은 밤 되세요";
        }
        return "안녕하세요";
    }

}
