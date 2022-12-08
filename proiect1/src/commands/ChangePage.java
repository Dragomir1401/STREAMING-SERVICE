package commands;

import filters.Filter;
import filters.FilterByCountry;
import input.ActionInput;
import input.Input;
import input.MovieInput;
import momentaryInstances.PageNow;
import output.CommandOutput;
import output.Output;

import java.util.List;

import static commands.MovieCommands.findMovieInstance;

public class ChangePage {
    public static void run(Input input, PageNow pageNow, ActionInput action, Output output) {
        boolean inHomepage = pageNow.getName().equals("homepage");
        // switch to log in or register not possible if current page is not homepage
        switch (action.getPage()) {
            case "register":
                if (inHomepage && pageNow.getUser() == null) {
                    setPageNow(pageNow, "register");
                } else {
                    output.getOutput().add(new CommandOutput());
                }
                break;
            case "login":
                if (inHomepage && pageNow.getUser() == null) {
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
                    setPageNow(pageNow, "movies", input.getMovies(), new FilterByCountry());
                } else {
                    output.getOutput().add(new CommandOutput());
                }
                break;
            case "see details":
                if (pageNow.getName().equals("movies") && findMovieInstance(input, action.getMovie()) != null) {
                    setPageNow(pageNow, "see details", findMovieInstance(input, action.getMovie()), output);
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

    private static void setPageNow(PageNow pageNow, String name, List<MovieInput> movieList,
                                   FilterByCountry filterByCountry) {
        pageNow.setName(name);
        pageNow.setMovie(null);
        pageNow.setMovieList(filterByCountry.filter(movieList, pageNow.getUser().getUser()));
    }

    private static void setPageNow(PageNow pageNow, String name, MovieInput movieInput, Output output) {
        pageNow.setName(name);
        pageNow.setMovie(movieInput);
        pageNow.getMoviesCommands().getMovieDetails(movieInput, output, pageNow.getUser().getUser());
    }

}

