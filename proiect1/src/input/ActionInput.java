package input;

public class ActionInput {
    private String type;
    private String page;
    private String feature;
    private CredentialsInput credentials;
    private String startsWith;
    private FilterInput filters;
    private int rate;
    private String movie;
    private  int count;

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getPage() {
        return page;
    }

    public void setPage(final String page) {
        this.page = page;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(final String feature) {
        this.feature = feature;
    }

    public CredentialsInput getCredentials() {
        return credentials;
    }

    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

    public String getStartsWith() {
        return startsWith;
    }

    public FilterInput getFilters() {
        return filters;
    }

    public void setFilters(FilterInput filters) {
        this.filters = filters;
    }

    public int getRate() {
        return rate;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(final String movie) {
        this.movie = movie;
    }

    public int getCount() {
        return count;
    }


}
