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

    public boolean userExists(Input input, ActionInput actionInput) {
        // user with the same name exists
        for (UserInput userInput : input.getUsers()) {
            if (userInput.getCredentials().getName().equals(actionInput.getCredentials().getName()))
                return true;
        }
        return false;
    }

    public boolean checkCredentials(Input input, ActionInput actionInput) {
        // check login credentials
        for (UserInput userInput : input.getUsers()) {
            if (userInput.getCredentials().getName().equals(actionInput.getCredentials().getName())) {
                if (userInput.getCredentials().getPassword().equals(actionInput.getCredentials().getPassword()))
                    return true;
                return false;
            }
        }
        return false;
    }

    public UserInput findUserInDatabase(Input input, ActionInput actionInput) {
        // finds user instance in input database
        for (UserInput userInput : input.getUsers()) {
            if (userInput.getCredentials().getName().equals(actionInput.getCredentials().getName()))
                return userInput;
        }
        return null;
    }

    public boolean userCanSeeMovie(UserInput userInput, MovieInput movieInput) {
        for (String country : movieInput.getCountriesBanned()) {
            if (userInput.getCredentials().getCountry().equals(country))
                return false;
        }
        return true;
    }
}
