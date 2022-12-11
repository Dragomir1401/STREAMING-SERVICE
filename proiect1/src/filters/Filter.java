package filters;

import input.MovieInput;

import java.util.List;

public interface Filter {
    List<MovieInput> run(List<MovieInput> movies, List<String> content);
}
