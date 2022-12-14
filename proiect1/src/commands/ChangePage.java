package commands;

import filters.FilterByCountry;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import momentaryInstances.PageNow;
import output.CommandOutput;
import output.Output;

import java.util.List;


public class ChangePage {
    public static void run(final Input input, final PageNow pageNow, final ActionInput action, final Output output) {
        boolean inHomepage = pageNow.getName().equals("homepage");
        // switch to log in or register not possible if current page is not homepage
        switch (action.getPage()) {
            case "register":
                if (inHomepage && pageNow.getUser().getUser() == null) {
                    setPageNow(pageNow, "register");
                } else {
                    output.getOutput().add(new CommandOutput());
                }
                break;
            case "login":
                if (inHomepage && pageNow.getUser().getUser() == null) {
                    setPageNow(pageNow, "login");
                } else {
                    output.getOutput().add(new CommandOutput());
                }
                break;
            case "logout":
                if (pageNow.getUser().getUser() != null) {
                    setPageNow(pageNow, "homepage");
                } else {
                    output.getOutput().add(new CommandOutput());
                }
                break;
            case "upgrades":
                if (pageNow.getUser().getUser() != null) {
                    setPageNow(pageNow, "upgrades");
                } else {
                    output.getOutput().add(new CommandOutput());
                }
                break;
            case "movies":
                if (pageNow.getUser().getUser() != null) {
                    setPageNow(pageNow, input.getMovies(), new FilterByCountry(), output);
                } else {
                    output.getOutput().add(new CommandOutput());
                }
                break;
            case "see details":
                if (pageNow.getName().equals("movies") &&
                        pageNow.getMoviesCommands().findMovieInstance(pageNow.getMovieList(), action.getMovie()) != null) {
                    setPageNow(pageNow, pageNow.getMoviesCommands().findMovieInstance(pageNow.getMovieList(),
                            action.getMovie()), output);
                } else {
                    output.getOutput().add(new CommandOutput());
                }
                break;
            default:
                System.out.println("Default change page case!");
                break;
        }
    }

    private static void setPageNow(PageNow pageNow, String name) {
        pageNow.setName(name);
        pageNow.setMovie(null);
        pageNow.setMovieList(null);
        if (name.equals("homepage")) {
            // logout case
            pageNow.getUser().setUser(null);
        }
    }

    private static void setPageNow(PageNow pageNow, List<MovieInput> movieList,
                                   FilterByCountry filterByCountry, Output output) {
        pageNow.setName("movies");
        pageNow.setMovie(null);
        pageNow.setMovieList(filterByCountry.filter(movieList, pageNow.getUser().getUser()));
        output.getOutput().add(new CommandOutput(pageNow.getMovieList(), pageNow.getUser().getUser()));
    }

    private static void setPageNow(PageNow pageNow, MovieInput movieInput, Output output) {
        pageNow.setName("see details");
        pageNow.setMovie(new MovieInput(movieInput));
        pageNow.getMoviesCommands().getMovieDetails(movieInput, output, pageNow.getUser().getUser(), pageNow);
    }

}

