import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import commands.HomepageSetter;
import commands.UserCommands;
import input.Input;
import input.ActionInput;
import commands.CommandParser;
import input.MovieInput;
import input.UserInput;
import momentaryInstances.PageNow;
import output.Output;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        // variable for number of tests
        final int numberOfTests = 10;
        // initialise mapper
        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 1; i <= numberOfTests; i++) {
                System.out.println("----------------TEST NO " + i + "----------------");
                // test filename and out filename
                String inputFile = "./checker/resources/in/basic_" + i + ".json";
                String outputFile = "./checker/resources/out/basic_" + i + ".json";
                File file = new File(outputFile);
                file.getParentFile().mkdirs();

                // parse input for given test
                Input programInput = objectMapper.readValue(new File(inputFile), Input.class);

                // initialise output
                Output programOutput = new Output();

                // set homepage
                PageNow pageNow = HomepageSetter.run(programInput);

                // differentiate commands and begin program ENTRY POINT
                CommandParser.parse(programInput, pageNow, programOutput);

                // generate output
                ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
                writer.writeValue(new File(outputFile), programOutput.getOutput());

                // reset current user
                pageNow.getUser().setUser(null);

                // reset input
                programInput.getUsers().forEach(UserInput::resetUser);
                programInput.getMovies().forEach(MovieInput::resetMovies);
        }
    }
}
