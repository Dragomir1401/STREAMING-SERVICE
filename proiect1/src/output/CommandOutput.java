package output;

import input.MovieInput;
import input.UserInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandOutput {
    private String error;
    private List<MovieInput> currentMoviesList;
    private UserInput currentUser;

    public CommandOutput() {
        this.error = "Error";
        this.currentMoviesList = new ArrayList();
    }

    public CommandOutput(List<MovieInput> currentMoviesList, UserInput currentUser) {
        this.error = "Error";
        this.currentMoviesList = currentMoviesList;
        this.currentUser = currentUser;
    }

    public CommandOutput(MovieInput movie, UserInput currentUser) {
        this.currentUser = new UserInput(currentUser);
        this.currentMoviesList = Collections.singletonList(new MovieInput(movie));
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<MovieInput> getCurrentMoviesList() {
        return currentMoviesList;
    }

    public void setCurrentMoviesList(List<MovieInput> currentMoviesList) {
        this.currentMoviesList = currentMoviesList;
    }

    public UserInput getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(UserInput currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public String toString() {
        return "CommandOutput{" +
                "error='" + error + '\'' +
                ", currentMoviesList=" + currentMoviesList +
                ", currentUser=" + currentUser +
                '}';
    }
}
