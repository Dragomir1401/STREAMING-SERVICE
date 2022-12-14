package momentaryInstances;

import commands.MovieCommands;
import commands.TokenCommands;
import commands.UserCommands;
import input.MovieInput;

import java.util.List;

public class PageNow {
    private final UserNow user;
    private String name;
    private final UserCommands userCommands;
    private final TokenCommands tokensCommands;
    private final MovieCommands moviesCommands;
    private List<MovieInput> movieList;
    private MovieInput movie;

    public PageNow(final UserNow user, final String name, final UserCommands userCommands,
                   final TokenCommands tokensCommands, final MovieCommands moviesActions,
                   final List<MovieInput> movieInputList, final MovieInput movieInput) {
        this.user = user;
        this.name = name;
        this.userCommands = userCommands;
        this.tokensCommands = tokensCommands;
        this.moviesCommands = moviesActions;
        this.movieList = movieInputList;
        this.movie = movieInput;
    }

    public PageNow(final String name) {
        this.user = UserNow.getInstance();
        this.name = name;
        this.userCommands = UserCommands.getInstance();
        this.tokensCommands = TokenCommands.getInstance();
        this.moviesCommands = MovieCommands.getInstance();
        this.movieList = null;
        this.movie = null;
    }

    public UserNow getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public UserCommands getUserCommands() {
        return userCommands;
    }

    public TokenCommands getTokensCommands() {
        return tokensCommands;
    }

    public MovieCommands getMoviesCommands() {
        return moviesCommands;
    }

    public List<MovieInput> getMovieList() {
        return movieList;
    }

    public void setMovieList(final List<MovieInput> movieInputList) {
        this.movieList = movieInputList;
    }

    public MovieInput getMovie() {
        return movie;
    }

    public void setMovie(final MovieInput movieInput) {
        this.movie = movieInput;
    }
}
