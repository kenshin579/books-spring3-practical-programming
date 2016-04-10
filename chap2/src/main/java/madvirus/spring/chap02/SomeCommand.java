package madvirus.spring.chap02;

public class SomeCommand implements Command {

    @Override
    public void execute() {
        System.out.println("SomeCommand executed.");
    }

}
