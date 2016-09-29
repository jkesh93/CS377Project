package com.example.jay.cs377project;

/**
 * Created by Jay on 9/28/2016.
 */

public class DataProvider {
    private String title, category, rating, review;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public DataProvider(String title, String category, String rating, String review) {
        this.title = title;
        this.category = category;
        this.rating = rating;
        this.review = review;
    }

    public DataProvider(String title, String category) {
        this.title = title;
        this.category = category;
    }
}
