package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.service.AuthenticationException;
import madvirus.spring.chap06.service.Authenticator;
import madvirus.spring.chap06.service.LoginCommand;
import madvirus.spring.chap06.validator.LoginCommandValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

    private String formViewName = "login/form";

    /*
    XML 설정해서 아래 변수에 MockAuthenticator 구현체를 setter로 세팅해준다
     */
    @Autowired
    private Authenticator authenticator;

    @RequestMapping(method = RequestMethod.GET)
    public String form() {
        return formViewName;
    }

    @ModelAttribute
    public LoginCommand formBacking() {
        return new LoginCommand();
    }

    /*
     @Valid 어노테이션과 스프링 프레임워크의 @InitBinder 어노테이을 이용해서 Validator에 대한
     직접적인 호출없이 스프링 프레임워크가 유효성 검사 코드를 실행함
     - Validtors.validate() 메서드를 명시적으로 호출하지 않고 스프링에서 자동으로 호출해줌
     */
    @RequestMapping(method = RequestMethod.POST)
    public String submit(@Valid LoginCommand loginCommand,
                         BindingResult result) {
        if (result.hasErrors()) {
            return formViewName;
        }
        try {
            authenticator.authenticate(loginCommand);
            return "redirect:/index.jsp";
        } catch (AuthenticationException e) {
            result.reject("invalidIdOrPassword", new Object[]{loginCommand.getUserId()}, null);
            return formViewName;
        }
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new LoginCommandValidator());
    }

    public void setAuthenticator(Authenticator loginService) {
        this.authenticator = loginService;
    }

}
