package com.sanjeeban.SpringCaching.dtos;

public class RequestBookDto {
    private String bookName;
    private String authorName;
    private String genre;

    public RequestBookDto() {
    }

    public RequestBookDto(String bookName, String authorName, String genre) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.genre = genre;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
