package filters;

import input.MovieInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterByActors implements Filter {
    @Override
    public List<MovieInput> run(List<MovieInput> movies, List<String> content) {
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
