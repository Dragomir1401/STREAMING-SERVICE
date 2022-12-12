import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import commands.HomepageSetter;
import input.Input;
import commands.CommandParser;
import input.MovieInput;
import input.UserInput;
import momentaryInstances.PageNow;
import output.Output;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // initialise mapper
        ObjectMapper objectMapper = new ObjectMapper();
        // extract test output file for debug
        String numberOnly = args[0].replaceAll("[^0-9]", "");
        numberOnly = numberOnly.substring(2);

        // test filename and out filename
        String outputFile = "./checker/resources/out/basic_" + numberOnly + ".json";
        // create output dir
        File file = new File(outputFile);
        file.getParentFile().mkdirs();

        // parse input for given test
        Input programInput = objectMapper.readValue(new File(args[0]), Input.class);

        // initialise output
        Output programOutput = new Output();

        // set homepage
        PageNow pageNow = HomepageSetter.run(programInput);

        // differentiate commands and begin program ENTRY POINT
        CommandParser.parse(programInput, pageNow, programOutput);

        // generate output
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(args[1]), programOutput.getOutput());
        writer.writeValue(new File(outputFile), programOutput.getOutput());

        // reset current user
        pageNow.getUser().setUser(null);

        // reset input
        programInput.getUsers().forEach(UserInput::resetUser);
        programInput.getMovies().forEach(MovieInput::resetMovies);
    }
}
