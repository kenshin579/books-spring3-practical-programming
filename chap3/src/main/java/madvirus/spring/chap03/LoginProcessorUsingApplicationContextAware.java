package madvirus.spring.chap03;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Locale;

public class LoginProcessorUsingApplicationContextAware implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("LoginProcessorUsingApplicationContextAware: setMessageSource");
        this.applicationContext = applicationContext;
    }

    public void login(String username, String password) {
        if (!username.equals("madvirus") && !password.equals("password111")) {
            Object[] args = new String[]{username};
            String failMessage = applicationContext.getMessage("login.fail", args,
                    Locale.getDefault());
            throw new IllegalArgumentException(failMessage);
        }
    }


}
