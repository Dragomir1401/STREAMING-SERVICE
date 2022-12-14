package filters;

import input.MovieInput;

import java.util.ArrayList;
import java.util.List;

public class FilterStartsWith implements Filter {

    @Override
    public List<MovieInput> run(final List<MovieInput> movies, final List<String> content) {
        List<MovieInput> result = new ArrayList<>();
        // content[0] contains startsWith parameter
        for (MovieInput movie : movies) {
            if (movie.getName().startsWith(content.get(0))) {
                result.add(movie);
            }
        }
        return result;
    }
}
