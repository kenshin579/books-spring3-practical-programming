package madvirus.spring.chap01.springInjection;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

    public static void main(String[] args) {
        Resource resource = new ClassPathResource("applicationContext.xml");

        //BeanFactory: 빈 객체를 관리하는 컨테이너
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        WriteArticleService articleService = (WriteArticleService) beanFactory
                .getBean("writeArticleService");
        articleService.write(new Article());
    }
}
