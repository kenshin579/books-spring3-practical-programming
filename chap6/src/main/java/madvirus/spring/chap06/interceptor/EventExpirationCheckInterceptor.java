package madvirus.spring.chap06.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/*
컨트롤러가 요청을 처리하기 전과 처리한 후에 알맞은 기능을 수행할때
- 조건에 따라 컨트롤러에 요청을 전달하지 않거나
- 요청을 처리한후 ModelAndView 객체를 조작하고 싶은 경우
 */
public class EventExpirationCheckInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        if (checkEvent(request) && checkEventExpiration()) {
            displayEventExpirationPage(request, response);
            return false;
        }
        return true;
    }

    private boolean checkEvent(HttpServletRequest request) {
        return request.getRequestURI().equals(
                request.getContextPath() + "/event/list.do");
    }

    private boolean checkEventExpiration() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2009, 11, 31);
        Date now = new Date();
        return now.after(calendar.getTime());
    }

    private void displayEventExpirationPage(HttpServletRequest request,
                                            HttpServletResponse response) throws IOException {
        response.sendRedirect("eventExpired.do");
    }

}
