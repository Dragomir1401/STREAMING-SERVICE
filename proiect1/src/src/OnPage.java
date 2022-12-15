package commands;

import actions.BuyTokens;
import actions.BuyPremium;
import actions.Command;
import actions.Filter;
import actions.Login;
import actions.Like;
import actions.Purchase;
import actions.Register;
import actions.Rate;
import actions.Watch;
import actions.Search;
import input.Input;
import input.ActionInput;
import momentary.PageNow;
import output.Output;


public final class OnPage {
    private OnPage() {

    }
    /**
     * runs on page type commands
     * @param input - input structure
     * @param pageNow - current page
     * @param action - action input
     * @param output - output structure
     */
    public static void run(final Input input, final PageNow pageNow, final ActionInput action,
                           final Output output) {
        if (action.getFeature() != null) {
            Command command;
            // select command type and factory its class
            switch (action.getFeature()) {
                case "register" -> command = new Register(input, pageNow, action, output);
                case "login" -> command = new Login(input, pageNow, action, output);
                case "filter" -> command = new Filter(input, pageNow, action, output);
                case "buy tokens" -> command = new BuyTokens(input, pageNow, action, output);
                case "like" -> command = new Like(input, pageNow, action, output);
                case "rate" -> command = new Rate(input, pageNow, action, output);
                case "purchase" -> command = new Purchase(input, pageNow, action, output);
                case "watch" -> command = new Watch(input, pageNow, action, output);
                case "search" -> command = new Search(input, pageNow, action, output);
                case "buy premium account" -> command = new BuyPremium(input, pageNow, action,
                        output);
                default -> throw new IllegalArgumentException("The command type "
                        + action.getFeature() + " is not recognized.");
            }
            // run command
            command.run();
        }
    }

}
