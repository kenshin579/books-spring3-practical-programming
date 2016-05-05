package madvirus.spring.chap02;

import org.springframework.beans.factory.BeanNameAware;

/**
 * Created by ykoh on 2016. 4. 23..
 */
public class JobExecutor implements BeanNameAware {
    private String beanName;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public void run() {
//        log.debug(beanName + ":");
    }
}
