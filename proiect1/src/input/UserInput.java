package input;

import java.util.List;
import java.util.ArrayList;

public class UserInput {
    private CredentialsInput credentials;
    private List<MovieInput> purchasedMovies = new ArrayList();
    private List<MovieInput> watchedMovies = new ArrayList();
    private List<MovieInput> likedMovies = new ArrayList();
    private List<MovieInput> ratedMovies = new ArrayList();
    private int tokensCount;
    private int numFreePremiumMovies = 15;

    public UserInput() {

    }
    public UserInput(UserInput currentUser) {
        this.credentials = new CredentialsInput();
        this.credentials.setName(currentUser.getCredentials().getName());
        this.credentials.setAccountType(currentUser.getCredentials().getAccountType());
        this.credentials.setBalance(currentUser.getCredentials().getBalance());
        this.credentials.setCountry(currentUser.getCredentials().getCountry());
        this.credentials.setPassword(currentUser.getCredentials().getPassword());
        this.tokensCount = currentUser.tokensCount;
        this.numFreePremiumMovies = currentUser.numFreePremiumMovies;
        this.purchasedMovies = new ArrayList();
        this.purchasedMovies.addAll(currentUser.purchasedMovies);
        this.watchedMovies = new ArrayList();
        this.watchedMovies.addAll(currentUser.watchedMovies);
        this.likedMovies = new ArrayList();
        this.likedMovies.addAll(currentUser.likedMovies);
        this.ratedMovies = new ArrayList();
        this.ratedMovies.addAll(currentUser.ratedMovies);
    }

    public UserInput(CredentialsInput credentials) {
        this.credentials = new CredentialsInput();
        this.credentials.setName(credentials.getName());
        this.credentials.setAccountType(credentials.getAccountType());
        this.credentials.setBalance(credentials.getBalance());
        this.credentials.setCountry(credentials.getCountry());
        this.credentials.setPassword(credentials.getPassword());
        this.tokensCount = 0;
        this.numFreePremiumMovies = 15;
        this.purchasedMovies = new ArrayList();
        this.watchedMovies = new ArrayList();
        this.likedMovies = new ArrayList();
        this.ratedMovies = new ArrayList();
    }

    public void resetUser() {
        this.purchasedMovies = new ArrayList();
        this.watchedMovies = new ArrayList();
        this.likedMovies = new ArrayList();
        this.ratedMovies = new ArrayList();
        this.tokensCount = 0;
        this.numFreePremiumMovies = 15;
    }

    public CredentialsInput getCredentials() {
        return credentials;
    }

    public void setCredentials(CredentialsInput credentials) {
        this.credentials = credentials;
    }

    public List<MovieInput> getPurchasedMovies() {
        return purchasedMovies;
    }

    public void setPurchasedMovies(List<MovieInput> purchasedMovies) {
        this.purchasedMovies = purchasedMovies;
    }

    public List<MovieInput> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(List<MovieInput> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public List<MovieInput> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(List<MovieInput> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public List<MovieInput> getRatedMovies() {
        return ratedMovies;
    }

    public void setRatedMovies(List<MovieInput> ratedMovies) {
        this.ratedMovies = ratedMovies;
    }

    public int getTokensCount() {
        return tokensCount;
    }

    public void setTokensCount(int tokensCount) {
        this.tokensCount = tokensCount;
    }

    public int getNumFreePremiumMovies() {
        return numFreePremiumMovies;
    }

    public void setNumFreePremiumMovies(int numFreePremiumMovies) {
        this.numFreePremiumMovies = numFreePremiumMovies;
    }

    @Override
    public String toString() {
        return "UserInput{" +
                "credentials=" + credentials +
                ", purchasedMovies=" + purchasedMovies +
                ", watchedMovies=" + watchedMovies +
                ", likedMovies=" + likedMovies +
                ", ratedMovies=" + ratedMovies +
                ", tokensCount=" + tokensCount +
                ", numFreePremiumMovies=" + numFreePremiumMovies +
                '}';
    }
}
