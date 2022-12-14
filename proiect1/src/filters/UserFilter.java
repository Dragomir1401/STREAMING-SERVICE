package filters;

import input.MovieInput;
import input.UserInput;

import java.util.List;

public interface UserFilter {
    List<MovieInput> filter(final List<MovieInput> movies, final UserInput user);
}
