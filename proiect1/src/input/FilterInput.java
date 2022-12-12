package input;

import filters.Filter;
import items.Contains;

public class FilterInput {
    private SortInput sort;
    private Contains contains;

    public SortInput getSort() {
        return sort;
    }

    public void setSort(SortInput sort) {
        this.sort = sort;
    }

    public Contains getContains() {
        return contains;
    }

    public void setContains(Contains movieSpecs) {
        this.contains = movieSpecs;
    }

    @Override
    public String toString() {
        return "FilterInput{" +
                "sort=" + sort +
                ", contains=" + contains +
                '}';
    }
}
