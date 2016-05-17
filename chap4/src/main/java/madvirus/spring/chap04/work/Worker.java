package madvirus.spring.chap04.work;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/*
todo: scope 부분 이해가 안됨. 기본적으로 singleton이라는 의미는 어떻게 이해하면 되나?
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Worker {

    public void work(WorkUnit unit) {
        System.out.println(toString() + " work " + unit);
    }

}
