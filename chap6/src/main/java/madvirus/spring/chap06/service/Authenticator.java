package madvirus.spring.chap06.service;

public interface Authenticator {

    void authenticate(LoginCommand loginCommand)
            throws AuthenticationException;

}
