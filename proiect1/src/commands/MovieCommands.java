package commands;

import filters.FilterByCountry;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import input.UserInput;
import momentaryInstances.PageNow;
import output.CommandOutput;
import output.Output;
import java.util.List;

public class MovieCommands {
    private static MovieCommands instance;

    public static MovieCommands getInstance() {
        if (instance == null) {
            instance = new MovieCommands();
        }

        return instance;
    }

    public MovieInput findMovieInstance(List<MovieInput> movies, String movieName) {
        for (MovieInput movie : movies) {
            if (movie.getName().equals(movieName))
                return movie;
        }
        return null;
    }

    public int findMovieIndex(List<MovieInput> movies, String movieName) {
        int index = 0;
        for (MovieInput movie : movies) {
            if (movie.getName().equals(movieName))
                return index;
            index++;
        }
        return -1;
    }

    public void getMovieDetails(MovieInput movieInput, Output output, UserInput user, PageNow pageNow) {

        if (movieInput != null && pageNow.getUserCommands().userCanSeeMovie(user, movieInput)) {
            output.getOutput().add(new CommandOutput(new MovieInput(movieInput), user));
            return;
        }

        output.getOutput().add(new CommandOutput());
    }

    public void purchaseMovie(Input input, Output output, PageNow pageNow, ActionInput actionInput) {
        // check to see if user has already purchased movie
        for (MovieInput movieInput : pageNow.getUser().getUser().getPurchasedMovies()) {
            if (movieInput.getName().equals(actionInput.getMovie())) {
                output.getOutput().add(new CommandOutput());
                return;
            }
        }

        // initialise filter
        FilterByCountry filterByCountry = new FilterByCountry();
        // get permitted movies in that country
        List<MovieInput> permittedMovies = filterByCountry.filter(input.getMovies(), pageNow.getUser().getUser());

        // find movie instance
        MovieInput movie = null;
        if (pageNow.getName().equals("upgrades")) {
            movie = findMovieInstance(permittedMovies, actionInput.getMovie());
        } else if (pageNow.getName().equals("see details")) {
            movie = findMovieInstance(permittedMovies, pageNow.getMovie().getName());
        }

        if (movie == null) {
            // movie does not exist or is not visible for the user country
            output.getOutput().add(new CommandOutput());
            return;
        }

        // case for premium account take from free movies
        if (pageNow.getUser().getUser().getCredentials().getAccountType().equals("premium")) {
            // check to see if user has free movies left
            if (pageNow.getUser().getUser().getNumFreePremiumMovies() > 0) {
                pageNow.getUser().getUser().setNumFreePremiumMovies(pageNow.getUser().getUser().getNumFreePremiumMovies() - 1);
                // add movie to purchased list
                pageNow.getUser().getUser().getPurchasedMovies().add(new MovieInput(movie));
                // create output
                output.getOutput().add(new CommandOutput(new MovieInput(movie), pageNow.getUser().getUser()));
                return;
            }
            // else purchase as normal user
            purchaseMovieStandardAccount(pageNow, output, movie);
            return;
        }
        // case for standard user
        if (pageNow.getUser().getUser().getCredentials().getAccountType().equals("standard")) {
            purchaseMovieStandardAccount(pageNow, output, movie);
        }
    }

    public void purchaseMovieStandardAccount(PageNow pageNow, Output output, MovieInput movie) {
        // case for standard account buy with tokens
        if (pageNow.getUser().getUser().getTokensCount() < 2) {
            // not enough tokens
            output.getOutput().add(new CommandOutput());
            return;
        }
        // decrease tokens
        pageNow.getUser().getUser().setTokensCount(pageNow.getUser().getUser().getTokensCount() - 2);
        // add movie to purchased list
        pageNow.getUser().getUser().getPurchasedMovies().add(new MovieInput(movie));
        // create output
        output.getOutput().add(new CommandOutput(new MovieInput(movie), pageNow.getUser().getUser()));
    }

    public void watchMovie(PageNow pageNow, Output output, ActionInput actionInput) {
        // check to see if movie is in purchased movies
        MovieInput movieInstance = null;
        if (pageNow.getName().equals("upgrades")) {
            movieInstance = findMovieInstance(pageNow.getUser().getUser().getPurchasedMovies(), actionInput.getMovie());
        } else if (pageNow.getName().equals("see details")) {
            movieInstance = findMovieInstance(pageNow.getUser().getUser().getPurchasedMovies(), pageNow.getMovie().getName());
        }

        if (movieInstance == null) {
            output.getOutput().add(new CommandOutput());
            return;
        }
        MovieInput movie = new MovieInput(movieInstance);

        // watch movie action
        pageNow.getUser().getUser().getWatchedMovies().add(new MovieInput(movie));
        // create output
        output.getOutput().add(new CommandOutput(new MovieInput(movie), pageNow.getUser().getUser()));
    }

    public void likeMovie(Input input, PageNow pageNow, Output output, ActionInput actionInput) {
        // check to see if movie is in watched movies
        MovieInput movieInstance = findMovieInstanceForEdgeCase(pageNow, actionInput);
        if (movieInstance == null) {
            output.getOutput().add(new CommandOutput());
            return;
        }
        MovieInput movie = new MovieInput(movieInstance);

        // like movie action
        movie.increaseLikes();
        pageNow.getUser().getUser().getLikedMovies().add(new MovieInput(movie));

        // modify movie in all its appearances
        modifyAppearances(input, pageNow, movie, "rate");

        // create output
        output.getOutput().add(new CommandOutput(new MovieInput(movie), pageNow.getUser().getUser()));
    }

    public void rateMovie(Input input, PageNow pageNow, Output output, ActionInput actionInput) {
        // check to see if movie is in watched movies
        MovieInput movieInstance = findMovieInstanceForEdgeCase(pageNow, actionInput);
        if (movieInstance == null) {
            output.getOutput().add(new CommandOutput());
            return;
        }
        MovieInput movie = new MovieInput(movieInstance);

        // keep user rating in user rated movie class
        movie.setRating(actionInput.getRate());

        // add movie to rated movies for user
        movie.increaseNumRatings();
        pageNow.getUser().getUser().getRatedMovies().add(new MovieInput(movie));

        // create rating for movie
        double rating;
        double sum = 0;
        for (UserInput userInput : input.getUsers()) {
            // find rated movie for user
            MovieInput ratedMovie = findMovieInstance(userInput.getRatedMovies(), movie.getName());

            // create sum for rating
            if (ratedMovie != null) {
                sum += ratedMovie.getRating();
            }
        }

        // calculate rating
        rating = sum / movie.getNumRatings();

        // set rating
        movie.setRating(rating);

        // modify all appearances
        modifyAppearances(input, pageNow, movie, "like");

        // create output
        output.getOutput().add(new CommandOutput(new MovieInput(movie), pageNow.getUser().getUser()));
    }

    public void modifyAppearances(Input input, PageNow pageNow, MovieInput movie, String rateOrLike) {
        // modify movie in all its appearances
        int index = findMovieIndex(pageNow.getUser().getUser().getPurchasedMovies(), movie.getName());
        if (index >= 0) {
            pageNow.getUser().getUser().getPurchasedMovies().set(index, new MovieInput(movie));
        }
        index = findMovieIndex(pageNow.getUser().getUser().getWatchedMovies(), movie.getName());
        if (index >= 0) {
            pageNow.getUser().getUser().getWatchedMovies().set(index, new MovieInput(movie));
        }
        if (rateOrLike.equals("like")) {
            index = findMovieIndex(pageNow.getUser().getUser().getLikedMovies(), movie.getName());
            if (index >= 0) {
                pageNow.getUser().getUser().getLikedMovies().set(index, new MovieInput(movie));
            }
        } else if (rateOrLike.equals("rate")) {
            index = findMovieIndex(pageNow.getUser().getUser().getRatedMovies(), movie.getName());
            if (index >= 0) {
                pageNow.getUser().getUser().getRatedMovies().set(index, new MovieInput(movie));
            }
        }
        index = findMovieIndex(pageNow.getMovieList(), movie.getName());
        if (index >= 0) {
            pageNow.getMovieList().set(index, new MovieInput(movie));
        }
        index = findMovieIndex(input.getMovies(), movie.getName());
        if (index >= 0) {
            input.getMovies().set(index, new MovieInput(movie));
        }
    }

    public MovieInput findMovieInstanceForEdgeCase(PageNow pageNow, ActionInput actionInput) {
        MovieInput movieInstance = null;
        if (pageNow.getName().equals("upgrades")) {
            movieInstance = findMovieInstance(pageNow.getUser().getUser().getWatchedMovies(), actionInput.getMovie());
        } else if (pageNow.getName().equals("see details")) {
            movieInstance = findMovieInstance(pageNow.getUser().getUser().getWatchedMovies(), pageNow.getMovie().getName());
        }
        return movieInstance;
    }
}
