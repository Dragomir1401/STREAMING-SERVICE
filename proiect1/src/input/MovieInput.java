package input;

import java.util.ArrayList;

public class MovieInput {
    private String name;
    private int year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;

    private int numLikes;
    private double rating;
    private int numRatings;

    public MovieInput() {
        this.rating = 0;
        this.numLikes = 0;
    }

    public MovieInput(MovieInput movieNow) {
        this.name = movieNow.name;
        this.rating = movieNow.rating;
        this.numRatings = movieNow.numRatings;
        this.year = movieNow.year;
        this.numLikes = movieNow.numLikes;
        this.duration = movieNow.duration;
        this.genres = new ArrayList();
        this.genres.addAll(movieNow.genres);
        this.actors = new ArrayList();
        this.actors.addAll(movieNow.actors);
        this.countriesBanned = new ArrayList();
        this.countriesBanned.addAll(movieNow.countriesBanned);
    }

    public void resetMovies() {
        this.numLikes = 0;
        this.numRatings = 0;
        this.rating = 0;
    }

    public void increaseLikes() {
        this.numLikes++;
    }
    public void increaseNumRatings() {
        this.numRatings++;
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

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(int numRatings) {
        this.numRatings = numRatings;
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
