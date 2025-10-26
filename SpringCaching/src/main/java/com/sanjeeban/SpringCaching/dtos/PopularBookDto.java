package com.sanjeeban.SpringCaching.dtos;


import java.io.Serializable;

public class PopularBookDto implements Serializable {

    private String bookName;
    private String bookAuthor;
    private String bookGenre;
    private double avgRating;

    private String remarks;


    public PopularBookDto() {
    }

    public PopularBookDto(String bookName, String bookAuthor, String bookGenre, double avgRating,String remarks) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
        this.avgRating = avgRating;
        this.remarks = remarks;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "PopularBookDto{" +
                "bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookGenre='" + bookGenre + '\'' +
                ", avgRating=" + avgRating +
                '}';
    }
}


