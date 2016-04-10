package madvirus.spring.chap02;

public class CommandFactoryImpl implements CommandFactory {

    @Override
    public Command createCommand(String commandName) {
        if (commandName.equals("some")) {
            return new SomeCommand();
        }
        return null;
    }

}
