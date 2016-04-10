package madvirus.spring.chap02;

public class Processor {

    public void process(String commandName) {
        CommandFactory factory = getCommandFactory();
        Command command = factory.createCommand(commandName);
        command.execute();
    }

    protected CommandFactory getCommandFactory() {
        return null;
    }
}
