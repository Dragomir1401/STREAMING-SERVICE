package commands;

public class TokenCommands {
    private static TokenCommands instance;

    public static TokenCommands getInstance() {
        if (instance == null) {
            instance = new TokenCommands();
        }

        return instance;
    }
    public static void run() {

    }
}
