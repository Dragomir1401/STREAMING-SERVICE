package input;

import java.util.ArrayList;

public class MovieInput {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    private int numberOfLikes;
    private int rating;
    private int numberOfRatings;

    public MovieInput() {

    }

    public MovieInput(MovieInput movieNow) {
        this.name = movieNow.name;
        this.rating = movieNow.rating;
        this.numberOfRatings = movieNow.numberOfRatings;
        this.year = movieNow.year;
        this.numberOfLikes = movieNow.numberOfLikes;
        this.duration = movieNow.duration;
        this.genres = new ArrayList();
        this.genres.addAll(movieNow.genres);
        this.actors = new ArrayList();
        this.actors.addAll(movieNow.actors);
        this.countriesBanned = new ArrayList();
        this.countriesBanned.addAll(movieNow.countriesBanned);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public void setCountriesBanned(ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    @Override
    public String toString() {
        return "MovieInput{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", genres=" + genres +
                ", actors=" + actors +
                ", countriesBanned=" + countriesBanned +
                '}';
    }
}
