package madvirus.spring.chap03;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import java.util.Locale;

public class LoginProcessorUsingMessageSourceAware implements MessageSourceAware {

    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        System.out.println("LoginProcessorUsingMessageSourceAware: setMessageSource");
        this.messageSource = messageSource;
    }

    public void login(String username, String password) {
        if (!username.equals("madvirus") && !password.equals("password111")) {
            Object[] args = new String[]{username};
            String failMessage = messageSource.getMessage("login.fail", args,
                    Locale.getDefault());
            throw new IllegalArgumentException(failMessage);
        }
    }

}
