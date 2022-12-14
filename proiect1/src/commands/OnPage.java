package commands;

import filters.*;
import input.*;
import momentaryInstances.PageNow;
import output.CommandOutput;
import output.Output;
import sorters.SortByDuration;
import sorters.SortByRating;
import java.util.ArrayList;
import java.util.List;


public class OnPage {
    public static void run(final Input input, final PageNow pageNow, final ActionInput action, final Output output) {
        if (action.getFeature() != null) {
            switch (action.getFeature()) {
                case "register" -> register(input, pageNow, action, output);
                case "login" -> login(input, pageNow, action, output);
                case "search" -> search(input, pageNow, action, output);
                case "filter" -> filter(input, pageNow, action, output);
                case "buy tokens" -> buyTokens(pageNow, action, output);
                case "buy premium account" -> buyPremiumAccount(pageNow, output);
                case "purchase" -> purchaseMovie(input, pageNow, action, output);
                case "watch" -> watchMovie(pageNow, action, output);
                case "like" -> likeMovie(input, pageNow, action, output);
                case "rate" -> rateMovie(input, pageNow, action, output);
                default -> System.out.println("Default on page case!");
            }
        }
    }

    private static void register(final Input input, final PageNow pageNow, final ActionInput action, final Output output) {
        // if page is register and another user is not registered already
        if (pageNow.getName().equals("register") && pageNow.getUser().getUser() == null &&
                !pageNow.getUserCommands().userExists(input, action)) {
            UserInput newUser = new UserInput(action.getCredentials());
            // add user to input base
            input.getUsers().add(newUser);
            // set current user to new user
            pageNow.getUser().setUser(newUser);
            // generate output
            output.getOutput().add(new CommandOutput(pageNow.getMovieList(), pageNow.getUser().getUser()));
            // set page to homepage with authentication
            pageNow.setName("homepage");
            // exit
            return;
        }

        // set page back to homepage in case of error
        pageNow.setName("homepage");
        output.getOutput().add(new CommandOutput());
    }

    private static void login(final Input input, final PageNow pageNow, final ActionInput action, final Output output) {
        // if page is not login or user is already logged or user is not in input base
        if (pageNow.getName().equals("login") && pageNow.getUser().getUser() == null &&
                pageNow.getUserCommands().userExists(input, action)) {
            if (pageNow.getUserCommands().checkCredentials(input, action)) {
                // if credentials are found in database
                pageNow.getUser().setUser(pageNow.getUserCommands().findUserInDatabase(input, action));
                // set page to homepage with authentication
                pageNow.setName("homepage");
                // add output
                output.getOutput().add(new CommandOutput(pageNow.getMovieList(), pageNow.getUser().getUser()));
                // exit
                return;
            }
        }
        // set page back to homepage in case of error
        pageNow.setName("homepage");
        output.getOutput().add(new CommandOutput());
    }

    private static void search(final Input input, final PageNow pageNow, final ActionInput action, final Output output) {
        // check to see if we are on movies page
        if (pageNow.getName().equals("movies")) {
            // initialise filters
            FilterStartsWith filter = new FilterStartsWith();
            FilterByCountry filterByCountry = new FilterByCountry();
            // set current movie filtered list on permitted movies for that country
            List<MovieInput> permittedMovies = filterByCountry.filter(input.getMovies(), pageNow.getUser().getUser());
            // create content for filtering
            List<String> content = new ArrayList<>();
            content.add(action.getStartsWith());
            // set list to filtered movies
            pageNow.setMovieList(filter.run(permittedMovies, content));
            // set output
            output.getOutput().add(new CommandOutput(pageNow.getMovieList(), pageNow.getUser().getUser()));
            // exit
            return;
        }
        // error case
        output.getOutput().add(new CommandOutput());

    }

    private static void filter(final Input input, final PageNow pageNow, final ActionInput action, final Output output) {
        if (pageNow.getName().equals("movies")) {
            // initialise filter
            FilterByCountry filterByCountry = new FilterByCountry();
            // get permitted movies in that country
            List<MovieInput> permittedMovies = filterByCountry.filter(input.getMovies(), pageNow.getUser().getUser());

            // filter by contains if necessary
            if (action.getFilters().getContains() != null) {
                // filter by contains given genre
                if (action.getFilters().getContains().getGenre() != null) {
                    FilterByGenre filter = new FilterByGenre();
                    if (filter.run(permittedMovies, action.getFilters().getContains().getGenre()) != null)
                        permittedMovies = new ArrayList<>(filter.run(permittedMovies, action.getFilters().getContains().getGenre()));
                }

                // filter by contains given actors
                if (action.getFilters().getContains().getActors() != null) {
                    FilterByActors filter = new FilterByActors();
                    if (filter.run(permittedMovies, action.getFilters().getContains().getActors()) != null)
                        permittedMovies = new ArrayList<>(filter.run(permittedMovies, action.getFilters().getContains().getActors()));
                }
            }

            if (action.getFilters().getSort() != null) {

                boolean sortedByDuration = false;
                // case for sorters
                if (action.getFilters().getSort().getDuration() != null) {
                    // initialise sorter
                    SortByDuration sort = new SortByDuration();
                    // run the sort on permitted movies
                    sort.run(permittedMovies, action.getFilters().getSort().getDuration());
                    sortedByDuration = true;
                }

                // case for sorters
                if (action.getFilters().getSort().getRating() != null) {
                    // initialise sorter
                    SortByRating sort = new SortByRating();
                    // run the sort on permitted movies
                    if (sortedByDuration) {
                        sort.runForEqualCases(permittedMovies, action.getFilters().getSort().getRating());
                    } else {
                        sort.run(permittedMovies, action.getFilters().getSort().getRating());
                    }
                }

            }

            // set current movie list
            pageNow.setMovieList(new ArrayList<>(permittedMovies));

            // manage output
            output.getOutput().add(new CommandOutput(pageNow.getMovieList(), pageNow.getUser().getUser()));
            return;
        }
        // error case
        output.getOutput().add(new CommandOutput());
    }

    private static void buyTokens(final PageNow pageNow, final ActionInput action, final Output output) {
        // check to see if we are on correct page
        if (pageNow.getName().equals("upgrades")) {
            pageNow.getTokensCommands().buyTokens(pageNow.getUser().getUser(), action, output);
            return;
        }
        // error case
        output.getOutput().add(new CommandOutput());
    }

    private static void buyPremiumAccount(final PageNow pageNow, final Output output) {
        // check to see if we are on correct page
        if (pageNow.getName().equals("upgrades")) {
            pageNow.getTokensCommands().buyPremiumAccount(pageNow.getUser().getUser(), output);
            return;
        }
        // error case
        output.getOutput().add(new CommandOutput());
    }

    private static void purchaseMovie(final Input input, final PageNow pageNow, final ActionInput actionInput, final Output output) {
        // check to see if we are on correct page
        if (pageNow.getName().equals("see details") || pageNow.getName().equals("upgrades")) {
            pageNow.getMoviesCommands().purchaseMovie(input, output, pageNow, actionInput);
            return;
        }
        // error case
        output.getOutput().add(new CommandOutput());
    }

    private static void watchMovie(final PageNow pageNow, final ActionInput actionInput, final Output output) {
        // check to see if we are on correct page
        if (pageNow.getName().equals("see details") || pageNow.getName().equals("upgrades")) {
            pageNow.getMoviesCommands().watchMovie(pageNow, output, actionInput);
            return;
        }
        // error case
        output.getOutput().add(new CommandOutput());
    }

    private static void likeMovie(final Input input, final PageNow pageNow, final ActionInput actionInput, final Output output) {
        // check to see if we are on correct page
        if (pageNow.getName().equals("see details") || pageNow.getName().equals("upgrades")) {
            pageNow.getMoviesCommands().likeMovie(input, pageNow, output, actionInput);
            return;
        }
        // error case
        output.getOutput().add(new CommandOutput());

    }

    private static void rateMovie(final Input input, final PageNow pageNow, final ActionInput actionInput, final Output output) {
        // check to see if we are on correct page
        if (pageNow.getName().equals("see details") || pageNow.getName().equals("upgrades")) {
            pageNow.getMoviesCommands().rateMovie(input, pageNow, output, actionInput);
            return;
        }
        // error case
        output.getOutput().add(new CommandOutput());
    }

}