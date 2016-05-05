package madvirus.spring.chap02;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AllILifeCycleInterfacesImpl implements BeanNameAware,
        BeanFactoryAware, InitializingBean, DisposableBean,
        ResourceLoaderAware, ApplicationEventPublisherAware,
        MessageSourceAware, ApplicationContextAware {

    public AllILifeCycleInterfacesImpl() {
        System.out.println("AllILifeCycleInterfacesImpl.������()");
    }

    public void setBeanName(String arg0) {
        System.out.println("AllILifeCycleInterfacesImpl.setBeanName()");
    }

    public void setBeanFactory(BeanFactory arg0) throws BeansException {
        System.out.println("AllILifeCycleInterfacesImpl.setBeanFactory()");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("AllILifeCycleInterfacesImpl.afterPropertiesSet()");
    }

    public void destroy() throws Exception {
        System.out.println("AllILifeCycleInterfacesImpl.destroy()");
    }

    public void setResourceLoader(ResourceLoader arg0) {
        System.out.println("AllILifeCycleInterfacesImpl.setResourceLoader()");
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
        System.out.println("AllILifeCycleInterfacesImpl.setApplicationEventPublisher()");
    }

    public void setMessageSource(MessageSource arg0) {
        System.out.println("AllILifeCycleInterfacesImpl.setMessageSource()");
    }

    public void setApplicationContext(ApplicationContext arg0)
            throws BeansException {
        System.out.println("AllILifeCycleInterfacesImpl.setApplicationContext()");
    }

    public void customInit() {
        System.out.println("AllILifeCycleInterfacesImpl.customInit()");
    }

    @PostConstruct
    public void annotatedInit() {
        System.out.println("AllILifeCycleInterfacesImpl.annotatedInit()");
    }

    @PreDestroy
    public void annotatedDestroy() {
        System.out.println("AllILifeCycleInterfacesImpl.annotatedDestroy()");
    }

    public void customDestroy() {
        System.out.println("AllILifeCycleInterfacesImpl.customDestroy()");
    }
}
