package output;

import input.MovieInput;
import input.UserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandOutput {
    private String error;
    private List<MovieInput> moviesList;
    private UserInput user;

    public CommandOutput() {
        this.error = "Error";
        this.moviesList = new ArrayList<>();
    }

    public CommandOutput(final List<MovieInput> moviesList, final UserInput user) {
        this.moviesList = new ArrayList<>();
        if (moviesList != null) {
            for (MovieInput movie : moviesList) {
                this.moviesList.add(new MovieInput(movie));
            }
        }
        this.user = new UserInput(user);
    }

    public CommandOutput(final MovieInput movie, final UserInput user) {
        this.user = new UserInput(user);
        this.moviesList = Collections.singletonList(new MovieInput(movie));
    }

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public List<MovieInput> getCurrentMoviesList() {
        return moviesList;
    }

    public void setCurrentMoviesList(final List<MovieInput> moviesList) {
        this.moviesList = moviesList;
    }

    public UserInput getCurrentUser() {
        return user;
    }

    public void setCurrentUser(final UserInput user) {
        this.user = user;
    }
}