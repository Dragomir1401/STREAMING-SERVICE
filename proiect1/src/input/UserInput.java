package input;

import java.util.List;
import java.util.ArrayList;

public class UserInput {
    private CredentialsInput credentials;
    private List<MovieInput> purchasedMovies = new ArrayList<>();
    private List<MovieInput> watchedMovies = new ArrayList<>();
    private List<MovieInput> likedMovies = new ArrayList<>();
    private List<MovieInput> ratedMovies = new ArrayList<>();
    private int tokensCount;
    private int numFreePremiumMovies = 15;

    public UserInput() {

    }
    public UserInput(final UserInput userInput) {
        this.credentials = new CredentialsInput();
        this.credentials.setAccountType(userInput.getCredentials().getAccountType());
        this.credentials.setPassword(userInput.getCredentials().getPassword());
        this.credentials.setBalance(userInput.getCredentials().getBalance());
        this.credentials.setCountry(userInput.getCredentials().getCountry());
        this.numFreePremiumMovies = userInput.getNumFreePremiumMovies();
        this.credentials.setName(userInput.getCredentials().getName());
        this.watchedMovies = new ArrayList<>();
        this.purchasedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
        this.purchasedMovies.addAll(userInput.getPurchasedMovies());
        this.watchedMovies.addAll(userInput.getWatchedMovies());
        this.likedMovies.addAll(userInput.getLikedMovies());
        this.ratedMovies.addAll(userInput.getRatedMovies());
        this.tokensCount = userInput.getTokensCount();
    }

    public UserInput(final CredentialsInput credentialsInput) {
        this.credentials = new CredentialsInput();
        this.credentials.setName(credentialsInput.getName());
        this.credentials.setAccountType(credentialsInput.getAccountType());
        this.credentials.setBalance(credentialsInput.getBalance());
        this.credentials.setCountry(credentialsInput.getCountry());
        this.credentials.setPassword(credentialsInput.getPassword());
        this.purchasedMovies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
        this.numFreePremiumMovies = 15;
        this.tokensCount = 0;
    }

    public void resetUser() {
        this.credentials = new CredentialsInput();
        this.purchasedMovies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
        this.tokensCount = 0;
        this.numFreePremiumMovies = 15;
    }

    public CredentialsInput getCredentials() {
        return credentials;
    }

    public void setCredentials(final CredentialsInput credentials) {
        this.credentials = credentials;
    }

    public List<MovieInput> getPurchasedMovies() {
        return purchasedMovies;
    }

    public void setPurchasedMovies(final List<MovieInput> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    public List<MovieInput> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(final List<MovieInput> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public List<MovieInput> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(final List<MovieInput> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public List<MovieInput> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(final List<MovieInput> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    public int getTokensCount() {
        return tokensCount;
    }

    public void setTokensCount(final int tokensCount) {
        this.tokensCount = tokensCount;
    }

    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public void setNumFreePremiumMovies(final int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

}
