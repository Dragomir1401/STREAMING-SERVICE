package filters;

import input.MovieInput;

import java.util.ArrayList;
import java.util.List;

public class FilterByActors implements Filter {
    @Override
    public List<MovieInput> run(final List<MovieInput> movies, final List<String> content) {
        List<MovieInput> result = new ArrayList<>();
        for (MovieInput movie : movies) {
            boolean containsActors = true;
            for (String actor : content) {
                if (!movie.getActors().contains(actor)) {
                    containsActors = false;
                    break;
                }
            }
            if (containsActors) {
                result.add(new MovieInput(movie));
            }
        }
        return result;
    }

}
