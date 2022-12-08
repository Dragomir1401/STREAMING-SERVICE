package filters;

import input.MovieInput;
import input.UserInput;

import java.util.ArrayList;
import java.util.List;

public class FilterByCountry implements UserFilter {
    @Override
    public List<MovieInput> filter(List<MovieInput> movies, UserInput user) {
        List<MovieInput> result = new ArrayList<>();
        for (MovieInput movie : movies) {
            if (!movie.getCountriesBanned().contains(user.getCredentials().getCountry()))
                result.add(movie);
        }
        return result;
    }
}
