package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.model.Address;
import madvirus.spring.chap06.model.MemberInfo;
import madvirus.spring.chap06.validator.MemberInfoValidator;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/*
    - GET 요청시 폼의 특정값을 초기화 함
    - POST때는 form에 입력한 값을 받음 사용자로부터
 */
@Controller
@RequestMapping("/account/create.do")
public class CreateAccountController {

    /*

    todo: formBacking은 언제 누구의 의해서 호출되나?
    - URI 요청이 들어오면 @ModelAttribute 어노테이션이 적용된 메서드가 @RequestMapping 어노테이션이 적용된 메서드 보다 먼저 호출된다

    */
    @ModelAttribute("command") //submit 메서드의 파라미터에서 사용된 @ModelAttribute 어노테이션의 값이 command로 동일함
    public MemberInfo formBacking(HttpServletRequest request) {
        if (request.getMethod().equalsIgnoreCase("GET")) {
            MemberInfo mi = new MemberInfo();
            Address address = new Address();
            address.setZipcode(autoDetectZipcode(request.getRemoteAddr()));
            mi.setAddress(address);
            return mi;
        } else {
            return new MemberInfo(); //command 라는 이름의 모델 객체로 저장됨
        }
    }

    private String autoDetectZipcode(String remoteAddr) {
        return "000000";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String form() {
        return "account/creationForm";
    }

    /*
    formBacking() 메서드의 반환값 MemberInfo()는 command 이름의 모델 객체로 저장되고
    command MemberInfo 객체는 submit() 메서드의 동일한 모델 이름을 갖는 커맨드 객체(첫번째 파라미터)로 전달됨

    1. 여기서 BindingResult는 무슨 역할을 하나?
    - Validator를 통한 검증과정의 결과는 BindingResult를 통해 확인할 수 있다
    실제로 BindingResult는 Errors의 서버인터페이스다. (오류정보가 여기에 저장됨)

     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(@ModelAttribute("command") MemberInfo memberInfo,
                         BindingResult result) {
        new MemberInfoValidator().validate(memberInfo, result);
        if (result.hasErrors()) { //검증 결과 에러가 존재한다면
            return "account/creationForm"; //뷰로 폼을 다시 보여줌
        }
        return "account/created";
    }
}
