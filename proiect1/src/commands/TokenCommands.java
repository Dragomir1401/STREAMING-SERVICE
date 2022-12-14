package commands;

import input.ActionInput;
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

    public void buyTokens(final UserInput userInput, final ActionInput actionInput, final Output output) {
        // case for not enough tokens
        if (actionInput.getCount() > Integer.parseInt(userInput.getCredentials().getBalance())) {
            output.getOutput().add(new CommandOutput());
            return;
        }
        // buy tokens action
        int balance = Integer.parseInt(userInput.getCredentials().getBalance());
        balance -= actionInput.getCount();
        userInput.getCredentials().setBalance(Integer.toString(balance));
        userInput.setTokensCount(userInput.getTokensCount() + actionInput.getCount());
    }

    public void buyPremiumAccount(final UserInput userInput, final Output output) {
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
