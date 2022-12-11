package sorters;

import input.MovieInput;

import java.util.Comparator;
import java.util.List;

public class SortByRating implements Sort {

    @Override
    public void run(List<MovieInput> movies, String parameter) {

        if (parameter.equals("increasing")) {
            movies.sort(Comparator.comparingInt(MovieInput::getRating));
        }
        else if (parameter.equals("decreasing")){
            movies.sort(Comparator.comparingInt(MovieInput::getRating).reversed());
        }
    }
}