package com.stackroute.springJdbc.domain;

public class Movie {

    int movieId;
    String movieName;
    int releaseYear;
     double ratings;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Movie()
     {

     }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(float ratings) {
        this.ratings = ratings;
    }


    public Movie(int movieId, String movieName, int releaseYear, double ratings) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.ratings = ratings;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", movieId=" + movieId +
                ", releaseYear=" + releaseYear +
                ", Ratings=" + ratings +
                '}';
    }
}
