package input;

import sorters.Sort;

public class SortInput {
    private String rating;
    private String duration;
    private Sort sort;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "SortInput{" +
                "rating='" + rating + '\'' +
                ", duration='" + duration + '\'' +
                ", sort=" + sort +
                '}';
    }
}
