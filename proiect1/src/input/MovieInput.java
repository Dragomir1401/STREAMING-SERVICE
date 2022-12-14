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
    private Double rating;
    private int numRatings;

    public MovieInput() {
        this.rating = 0.00;
        this.numLikes = 0;
    }

    public MovieInput(final MovieInput movieInput) {
        this.name = movieInput.name;
        this.numLikes = movieInput.numLikes;
        this.rating = movieInput.rating;
        this.duration = movieInput.duration;
        this.numRatings = movieInput.numRatings;
        this.year = movieInput.year;
        this.genres = new ArrayList<>();
        this.genres.addAll(movieInput.genres);
        this.actors = new ArrayList<>();
        this.actors.addAll(movieInput.actors);
        this.countriesBanned = new ArrayList<>();
        this.countriesBanned.addAll(movieInput.countriesBanned);
    }

    public void resetMovie() {
        this.year = 0;
        this.duration = 0;
        this.name = null;
        this.numLikes = 0;
        this.numRatings = 0;
        this.rating = 0.00;
        this.genres = null;
        this.actors = null;
        this.countriesBanned = null;
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

    public void setName(final String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(final int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(final int numLikes) {
        this.numLikes = numLikes;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(final double rating) {
        this.rating = rating;
    }

    public int getNumRatings() {
        return numRatings;
    }

    public void setNumRatings(final int numRatings) {
        this.numRatings = numRatings;
    }

}
