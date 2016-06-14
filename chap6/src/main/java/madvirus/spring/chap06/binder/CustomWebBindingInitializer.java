package madvirus.spring.chap06.binder;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
WebBindingInitializer를 전체 컨트롤러에 공통으로 적용되는 PropertyEditor를 등록하는데 사용된다
- XML 설정파일에 AnnotationMethodHandlerAdapter의 webBindingInitializer 프로퍼티 값으로
   구현 클래스의 빈을 전달해주면 된다
 */
public class CustomWebBindingInitializer implements WebBindingInitializer {

    @Override
    public void initBinder(WebDataBinder binder, WebRequest request) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, true));
    }

}
