package madvirus.spring.chap04.work;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Executor {

    @Autowired
    private Worker worker;

    public void addUnit(WorkUnit work) {
        worker.work(work);
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

}
