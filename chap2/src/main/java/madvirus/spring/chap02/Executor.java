package madvirus.spring.chap02;

public class Executor {

    private Worker worker;

    public void addUnit(WorkUnit work) {
        worker.work(work);
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

}
