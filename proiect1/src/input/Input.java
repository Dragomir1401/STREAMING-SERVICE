package input;

import java.util.List;

public class Input {
    private static Input inputInstance = null;
    private List<UserInput> users;
    private List<MovieInput> movies;
    private List<ActionInput> actions;

    /**
     * Singleton structure for input initialised uniquely in the program
     * @return
     */
    public static Input getInstance() {
        if (inputInstance == null) {
            inputInstance = new Input();
        }

        return inputInstance;
    }

    public Input() {

    };

    public Input(List<UserInput> users, List<MovieInput> movies, List<ActionInput> actions) {
        this.users = users;
        this.movies = movies;
        this.actions = actions;
    }

    public static void setInputInstance(Input inputInstance) {
        Input.inputInstance = inputInstance;
    }

    public List<UserInput> getUsers() {
        return users;
    }

    public void setUsers(List<UserInput> users) {
        this.users = users;
    }

    public List<MovieInput> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieInput> movies) {
        this.movies = movies;
    }

    public List<ActionInput> getActions() {
        return actions;
    }

    public void setActions(List<ActionInput> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Input{" +
                "users=" + users +
                ", movies=" + movies +
                ", actions=" + actions +
                '}';
    }
}
