package commands;

import input.ActionInput;
import input.Input;
import momentaryInstances.PageNow;
import output.Output;

import java.util.List;

public class CommandParser {
    public static void parse(Input input, PageNow pageNow, Output output) {
        for (ActionInput action : input.getActions()) {
            switch (action.getType()) {
                case "change page":
                    ChangePage.run(input, pageNow, action, output);
                    break;
                case "on page":
                    OnPage.run(input, pageNow, action, output);
                    break;
                default:
                    System.out.println("Default command case!");
                    break;
            }
        }

    }
}
