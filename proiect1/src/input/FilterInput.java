package input;

import items.Contains;

public class FilterInput {
    private SortInput sort;
    private Contains contains;

    public SortInput getSort() {
        return sort;
    }

    public void setSort(final SortInput sort) {
        this.sort = sort;
    }

    public Contains getContains() {
        return contains;
    }

    public void setContains(final Contains movieSpecs) {
        this.contains = movieSpecs;
    }

}
