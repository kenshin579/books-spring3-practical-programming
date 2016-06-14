package madvirus.spring.chap06.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class QueryLogController {

    @ModelAttribute("command")
    public QueryLogCommand formBacking() {
        return new QueryLogCommand();
    }

    @RequestMapping("/log/query.do")
    public String query(@ModelAttribute("command") QueryLogCommand command,
                        BindingResult result) {
        /*
        아래 new CustomDateEditor(dateFormat,false)으로 설정할 경우,
        typeMismatch라는 에러 코드가 발생하게 됨
         */
        if (result.hasErrors()) {

        }
        return "log/logList";
    }

    /*
    CustomDateEditor를 WebDataBinder에 등록함으로써 문자열을 Date 타입으로 변환할 수 있다
    - 따라서 다음과 같이 커맨드 클래스에 java.util.Date 타입의 프로퍼티를 추가해도 폼에 입력한 파라미터 값을
     Date 타입의 프로퍼티로 전달받을 수 있다
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat,
                true)); //true이면 HTTP 요청 파라미터 값이 존재하지 않거나 빈 문다열인 경우 null을 값으로 설정하게 됨
    }
}
