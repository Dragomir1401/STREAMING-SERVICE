package sorters;

import input.MovieInput;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class SortByRating implements Sort {
    @Override
    public void run(List<MovieInput> movies, String parameter) {

        if (parameter.equals("increasing")) {
            movies.sort(Comparator.comparingDouble(MovieInput::getRating));
        }
        else if (parameter.equals("decreasing")){
            movies.sort(Comparator.comparingDouble(MovieInput::getRating).reversed());
        }
    }

    public void runForEqualCases(List<MovieInput> movies, String parameter) {
        if (parameter.equals("increasing")) {
            movies.sort((o1, o2) -> {
                int cmp = o1.getDuration() - o2.getDuration();
                if (cmp != 0)
                    return -cmp;
                else
                    cmp = Double.compare(o1.getRating(), o2.getRating());
                return cmp;
            });
        }
        else if (parameter.equals("decreasing")){
            movies.sort((o1, o2) -> {
                int cmp = o1.getDuration() - o2.getDuration();
                if (cmp != 0)
                    return -cmp;
                else
                    cmp = Double.compare(o1.getRating(), o2.getRating());
                return -cmp;
            });
        }
    }
}