package madvirus.spring.chap04.scope;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 참고
 * - http://isstory83.tistory.com/92
 * - https://blog.outsider.ne.kr/765
 */
public class MainScope {
    public static void main(String[] args) {
        String[] configLocations = new String[]{"scope.xml"};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);

        /*
        1. singleton: getBean 여러번 해도 다 같은 처음 생성한 객체만 존재함
         */
        BeanTest beanSingletonTest1 = (BeanTest) context.getBean("beanSingletonTest");
        BeanTest beanSingletonTest2 = (BeanTest) context.getBean("beanSingletonTest");
        BeanTest beanSingletonTest3 = (BeanTest) context.getBean("beanSingletonTest");

        System.out.println("beanSingletonTest1: " + beanSingletonTest1);
        System.out.println("beanSingletonTest2: " + beanSingletonTest2);
        System.out.println("beanSingletonTest3: " + beanSingletonTest3);
//        beanTest1: madvirus.spring.chap04.scope.BeanTest@129a8472
//        beanTest2: madvirus.spring.chap04.scope.BeanTest@129a8472
//        beanTest3: madvirus.spring.chap04.scope.BeanTest@129a8472

        /*
        2.prototype: 다수의 객체가 존재할 수 있음
         */

        BeanTest beanPrototypeTest1 = (BeanTest) context.getBean("beanPrototypeTest");
        BeanTest beanPrototypeTest2 = (BeanTest) context.getBean("beanPrototypeTest");
        BeanTest beanPrototypeTest3 = (BeanTest) context.getBean("beanPrototypeTest");

        System.out.println("beanPrototypeTest1: " + beanPrototypeTest1);
        System.out.println("beanPrototypeTest2: " + beanPrototypeTest2);
        System.out.println("beanPrototypeTest3: " + beanPrototypeTest3);
//        beanPrototypeTest1: madvirus.spring.chap04.scope.BeanTest@1b0375b3
//        beanPrototypeTest2: madvirus.spring.chap04.scope.BeanTest@2f7c7260
//        beanPrototypeTest3: madvirus.spring.chap04.scope.BeanTest@2d209079


    }
}
