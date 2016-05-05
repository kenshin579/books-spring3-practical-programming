package madvirus.spring.chap04.work;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Worker {

    public void work(WorkUnit unit) {
        System.out.println(toString() + " work " + unit);
    }

}
