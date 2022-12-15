import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import commands.HomepageSetter;
import momentary.PageNow;
import commands.CommandParser;
import input.Input;
import input.UserInput;
import input.MovieInput;
import output.Output;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public final class Main {

    private Main() {

    }

    /**
     * main function
     * @param argv - args[0] - input; args[1] - output
     * @throws IOException - file opening exception
     */
    public static void main(final String[] argv) throws IOException {
        // initialise mapper
        ObjectMapper objectMapper = new ObjectMapper();
        // extract test output file for debug
        String numberOnly = argv[0].replaceAll("[^0-9]", "");
        numberOnly = numberOnly.substring(2);

        // test filename and out filename
        String outputFile = "./checker/resources/out/basic_" + numberOnly + ".json";
        // create output dir
        File file = new File(outputFile);
        boolean resCode = file.getParentFile().mkdirs();
        if (resCode) {
            return;
        }

        // parse input for given test
        Input programInput = objectMapper.readValue(new File(argv[0]), Input.class);

        // initialise output
        Output programOutput = new Output();

        // set homepage
        PageNow pageNow = HomepageSetter.run();

        // differentiate commands and begin program ENTRY POINT
        CommandParser.parse(programInput, pageNow, programOutput);

        // generate output
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(new File(argv[1]), programOutput.getOutput());
        writer.writeValue(new File(outputFile), programOutput.getOutput());

        // reset current user
        pageNow.getUser().setUser(null);

        // reset input
        programInput.getUsers().forEach(UserInput::resetUser);
        programInput.getMovies().forEach(MovieInput::resetMovie);
    }
}
