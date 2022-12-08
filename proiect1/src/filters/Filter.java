package filters;

import input.MovieInput;

import java.util.List;

public interface Filter {
    List<MovieInput> filter(List<MovieInput> movies, List<MovieInput> content);
}
