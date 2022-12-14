package filters;

import input.MovieInput;

import java.util.List;

public interface Filter {
    List<MovieInput> run(final List<MovieInput> movies, final List<String> content);
}
