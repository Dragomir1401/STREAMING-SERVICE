package sorters;

import input.MovieInput;

import java.util.List;

public interface Sort {
    void run(List<MovieInput> movies, String parameter);
}