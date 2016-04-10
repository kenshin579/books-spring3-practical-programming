package madvirus.spring.chap02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        String[] configLocations = new String[]{"applicationContext.xml"};
        AbstractApplicationContext context = new ClassPathXmlApplicationContext(
                configLocations);
        context.registerShutdownHook();

        WriteArticleService articleService = context.getBean(
                "writeArticleService", WriteArticleService.class);
        articleService.write(new Article());

        Processor processor = context.getBean("processor", Processor.class);
        processor.process("some");

        Executor executor = context.getBean("executor", Executor.class);
        executor.addUnit(new WorkUnit());
        executor.addUnit(new WorkUnit());
        executor.addUnit(new WorkUnit());

        Worker worker = context.getBean("workerBean", Worker.class);
        worker.work(new WorkUnit());
        worker.work(new WorkUnit());
    }

}
