package commands;

import input.Input;
import input.MovieInput;
import input.UserInput;
import momentaryInstances.PageNow;
import output.CommandOutput;
import output.Output;
import commands.UserCommands;

public class MovieCommands {
    private static MovieCommands instance;
    public static void run() {

    }

    public static MovieCommands getInstance() {
        if (instance == null) {
            instance = new MovieCommands();
        }

        return instance;
    }

    public MovieInput findMovieInstance(Input input, String movieName) {
        for (MovieInput movie : input.getMovies()) {
            if (movie.getName().equals(movieName))
                return movie;
        }
        return null;
    }

    public void getMovieDetails(MovieInput movieInput, Output output, UserInput user, PageNow pageNow) {

        if (movieInput != null && pageNow.getUserCommands().userCanSeeMovie(user, movieInput)) {
            output.getOutput().add(new CommandOutput(movieInput, user));
            return;
        }

        output.getOutput().add(new CommandOutput());
    }


}
