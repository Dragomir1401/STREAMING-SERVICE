package momentaryInstances;

import input.UserInput;

public class UserNow {
    private UserInput user;
    private static UserNow instance = null;

    // Singleton instance for current user
    public static UserNow getInstance() {
        if (instance == null) {
            instance = new UserNow();
        }
        return instance;
    }

    public UserInput getUser() {
        return user;
    }

    public void setUser(UserInput user) {
        this.user = user;
    }

    public static void setInstance(UserNow instance) {
        UserNow.instance = instance;
    }
}
