package commands;

import input.Input;
import momentaryInstances.PageNow;

public class HomepageSetter {
    public static PageNow run(Input input) {
        PageNow pageNow = new PageNow("homepage", input);
        return pageNow;
    }
}
