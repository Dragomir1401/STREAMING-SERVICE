package commands;

import input.ActionInput;
import input.Input;
import input.MovieInput;
import input.UserInput;

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

    public boolean userExists(final Input input, final ActionInput actionInput) {
        // user with the same name exists
        for (UserInput userInput : input.getUsers()) {
            if (userInput.getCredentials().getName().equals(actionInput.getCredentials().getName()))
                return true;
        }
        return false;
    }

    public boolean checkCredentials(final Input input, final ActionInput actionInput) {
        // check login credentials
        for (UserInput userInput : input.getUsers()) {
            if (userInput.getCredentials().getName().equals(actionInput.getCredentials().getName())) {
                return userInput.getCredentials().getPassword().equals(actionInput.getCredentials().getPassword());
            }
        }
        return false;
    }

    public UserInput findUserInDatabase(final Input input, final ActionInput actionInput) {
        // finds user instance in input database
        for (UserInput userInput : input.getUsers()) {
            if (userInput.getCredentials().getName().equals(actionInput.getCredentials().getName()))
                return userInput;
        }
        return null;
    }

    public boolean userCanSeeMovie(final UserInput userInput, final MovieInput movieInput) {
        for (String country : movieInput.getCountriesBanned()) {
            if (userInput.getCredentials().getCountry().equals(country))
                return false;
        }
        return true;
    }
}
