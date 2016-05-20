package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @RequestMapping("/cookie/make.do")
    public String make(HttpServletResponse response) {
        response.addCookie(new Cookie("auth", "1"));
        return "cookie/made";
    }

    @RequestMapping("/cookie/view.do")
    public String view(
            @CookieValue(value = "auth", defaultValue = "0") String auth) {
        System.out.println("auth ��Ű: " + auth);
        return "cookie/view";
    }
}
