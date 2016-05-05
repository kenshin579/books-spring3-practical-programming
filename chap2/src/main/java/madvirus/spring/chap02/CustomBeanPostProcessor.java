package madvirus.spring.chap02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        System.out
                .println("CustomBeanPostProcessor.postProcessAfterInitialization():"
                        + beanName);
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        System.out
                .println("CustomBeanPostProcessor.postProcessBeforeInitialization():"
                        + beanName);
        return bean;
    }

}
