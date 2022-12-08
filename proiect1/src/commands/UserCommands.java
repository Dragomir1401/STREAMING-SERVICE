package commands;

public class UserCommands {
    private static UserCommands instance;
    public static void run() {

    }

    public static UserCommands getInstance() {
        if (instance == null) {
            instance = new UserCommands();
        }

        return instance;
    }
}
