package filters;

import input.MovieInput;

import java.util.ArrayList;
import java.util.List;

public class FilterByGenre implements Filter {
    @Override
    public List<MovieInput> run(final List<MovieInput> movies, final List<String> content) {
        List<MovieInput> result = new ArrayList<>();
        for (MovieInput movie : movies) {
            boolean containsGenres = true;
            for (String genre : content) {
                if (!movie.getGenres().contains(genre)) {
                    containsGenres = false;
                    break;
                }
            }
            if (containsGenres) {
                result.add(new MovieInput(movie));
            }
        }
        return result;
    }
}
