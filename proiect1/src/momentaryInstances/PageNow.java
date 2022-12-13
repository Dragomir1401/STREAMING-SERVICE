package momentaryInstances;

import commands.MovieCommands;
import commands.TokenCommands;
import commands.UserCommands;
import input.Input;
import input.MovieInput;

import java.util.List;

public class PageNow {
    private UserNow user;
    private String name;
    private UserCommands userCommands;
    private TokenCommands tokensCommands;
    private MovieCommands moviesCommands;
    private List<MovieInput> movieList;
    private MovieInput movie;

    public PageNow(UserNow user, String name, UserCommands userCommands,
                   TokenCommands tokensCommands, MovieCommands moviesActions,
                   Input input, List<MovieInput> movieInputList, MovieInput movieInput) {
        this.user = user;
        this.name = name;
        this.userCommands = userCommands;
        this.tokensCommands = tokensCommands;
        this.moviesCommands = moviesActions;
        this.movieList = movieInputList;
        this.movie = movieInput;
    }

    public PageNow(String name, Input input) {
        this.user = UserNow.getInstance();
        this.name = name;
        this.userCommands = UserCommands.getInstance();
        this.tokensCommands = TokenCommands.getInstance();
        this.moviesCommands = MovieCommands.getInstance();
    }

    public UserNow getUser() {
        return user;
    }

    public void setUser(UserNow user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserCommands getUserCommands() {
        return userCommands;
    }

    public void setUserCommands(UserCommands userCommands) {
        this.userCommands = userCommands;
    }

    public TokenCommands getTokensCommands() {
        return tokensCommands;
    }

    public void setTokensCommands(TokenCommands tokensCommands) {
        this.tokensCommands = tokensCommands;
    }

    public MovieCommands getMoviesCommands() {
        return moviesCommands;
    }

    public void setMoviesCommands(MovieCommands moviesActions) {
        this.moviesCommands = moviesActions;
    }

    public List<MovieInput> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieInput> movieInputList) {
        this.movieList = movieInputList;
    }

    public MovieInput getMovie() {
        return movie;
    }

    public void setMovie(MovieInput movieInput) {
        this.movie = movieInput;
    }
}
