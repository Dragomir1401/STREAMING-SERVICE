package commands;

import input.ActionInput;
import input.Input;
import momentaryInstances.PageNow;
import output.Output;


public class CommandParser {
    public static void parse(final Input input, final PageNow pageNow, final Output output) {
        for (ActionInput action : input.getActions()) {
            switch (action.getType()) {
                case "change page" -> ChangePage.run(input, pageNow, action, output);
                case "on page" -> OnPage.run(input, pageNow, action, output);
                default -> System.out.println("Default command case!");
            }
        }

    }
}
