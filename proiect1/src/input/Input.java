package input;

import java.util.List;

public class Input {
    private List<UserInput> users;
    private List<MovieInput> movies;
    private List<ActionInput> actions;

    public Input() {

    }

    public Input(final List<UserInput> users, final List<MovieInput> movies, final List<ActionInput> actions) {
        this.users = users;
        this.movies = movies;
        this.actions = actions;
    }

    public List<UserInput> getUsers() {
        return users;
    }

    public void setUsers(final List<UserInput> users) {
        this.users = users;
    }

    public List<MovieInput> getMovies() {
        return movies;
    }

    public void setMovies(final List<MovieInput> movies) {
        this.movies = movies;
    }

    public List<ActionInput> getActions() {
        return actions;
    }

    public void setActions(final List<ActionInput> actions) {
        this.actions = actions;
    }

}
