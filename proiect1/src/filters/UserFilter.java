package filters;

import input.MovieInput;
import input.UserInput;

import java.util.List;

public interface UserFilter {
    public List<MovieInput> filter(List<MovieInput> movies,  UserInput user);
}
