package com.sanjeeban.SpringCaching.dtos;

public class BookDto {
    private String bookName;
    private String bookAuthor;
    private String bookGenre;
    private double avgRating;
    private int totalViews;

    public BookDto() {
    }

    public BookDto(String bookName, String bookAuthor, String bookGenre, double avgRating, int totalViews) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.avgRating = avgRating;
        this.totalViews = totalViews;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookGenre() {
        return bookGenre;
    }

    public void setBookGenre(String bookGenre) {
        this.bookGenre = bookGenre;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }
}
