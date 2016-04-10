package madvirus.spring.chap02;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainLifecycle {

    public static final String CONFIG_FILE_PATH = "applicationContextLifecycle.xml";

    public static void main(String[] args) {
        useApplicationFactory();
        System.out.println("\n\n");
        useBeanFactory(false);
        System.out.println("\n\n");
        useBeanFactory(true);
        System.out.println("\n\n");
    }

    private static void useApplicationFactory() {
        System.out.println("--- useApplicationFactory");
        String[] configLocations = new String[]{CONFIG_FILE_PATH};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);
        context.registerShutdownHook();
    }

    private static void useBeanFactory(boolean addBeanPostProcessor) {
        System.out.println("--- useBeanFactory"
                + (addBeanPostProcessor ? ": Use BeanPostProcessor" : ""));
        Resource resource = new ClassPathResource(CONFIG_FILE_PATH);
        XmlBeanFactory beanFactory = new XmlBeanFactory(resource);

        if (addBeanPostProcessor) {
            beanFactory.addBeanPostProcessor(new CustomBeanPostProcessor());
        }

        String beanName = "allILifeCycleInterfacesImpl";
        AllILifeCycleInterfacesImpl bean = beanFactory.getBean(beanName,
                AllILifeCycleInterfacesImpl.class);
        System.out.println(bean);
        beanFactory.removeBeanDefinition(beanName);
    }
}
