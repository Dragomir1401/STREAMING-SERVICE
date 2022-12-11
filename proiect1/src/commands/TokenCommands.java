package commands;

import input.ActionInput;
import input.Input;
import input.UserInput;
import output.CommandOutput;
import output.Output;

public class TokenCommands {
    private static TokenCommands instance;

    public static TokenCommands getInstance() {
        if (instance == null) {
            instance = new TokenCommands();
        }

        return instance;
    }

    public void buyTokens(UserInput userInput, ActionInput actionInput, Output output) {
        // case for not enough tokens
        if (actionInput.getCount() > Integer.parseInt(userInput.getCredentials().getBalance())) {
            output.getOutput().add(new CommandOutput());
            return;
        }
        // buy tokens action
        Integer balance = Integer.parseInt(userInput.getCredentials().getBalance());
        balance -= actionInput.getCount();
        userInput.getCredentials().setBalance(balance.toString());
        userInput.setTokensCount(userInput.getTokensCount() + actionInput.getCount());
    }

    public void buyPremiumAccount(UserInput userInput, ActionInput actionInput, Output output) {
        // case for not enough tokens
        if (10 > userInput.getTokensCount()) {
            output.getOutput().add(new CommandOutput());
            return;
        }

        // case for already having premium
        if (userInput.getCredentials().getAccountType().equals("premium")) {
            output.getOutput().add(new CommandOutput());
            return;
        }

        // buy premium account action
        userInput.setTokensCount(userInput.getTokensCount() - 10);
        userInput.getCredentials().setAccountType("premium");
    }
}
