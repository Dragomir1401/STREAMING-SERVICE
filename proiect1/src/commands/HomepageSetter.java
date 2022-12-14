package commands;

import momentaryInstances.PageNow;

public class HomepageSetter {
    public static PageNow run() {
        PageNow pageNow = new PageNow("homepage");
        return pageNow;
    }
}
