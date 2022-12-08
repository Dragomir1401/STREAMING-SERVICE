package output;

import java.util.ArrayList;
import java.util.List;

public class Output {
    private final List<CommandOutput> output = new ArrayList();

    public List<CommandOutput> getOutput() {
        return this.output;
    }

    @Override
    public String toString() {
        return "Output{" +
                "output=" + output +
                '}';
    }
}
