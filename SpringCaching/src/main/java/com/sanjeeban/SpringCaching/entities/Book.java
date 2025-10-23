package com.sanjeeban.SpringCaching.entities;


import jakarta.persistence.*;

@Entity
@Table(
        name="t_book",
        schema="brs",
        uniqueConstraints = {
                @UniqueConstraint(name="uniqueBookIdName",columnNames={"book_id","book_name"})
        }
)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id",nullable = false)
    private Long bookId;

    @Column(name="book_name",length=255,nullable=false)
    private String bookName;

    @ManyToOne
    @JoinColumn(
            name = "author_id_fk",                   // this will be created in Book table
            referencedColumnName = "author_id",      // matches the @Column name in Author entity
            foreignKey = @ForeignKey(name = "fk_book_author")
    )
    private Author author;


    @ManyToOne
    @JoinColumn(
            name="genre_id_fk",
            referencedColumnName = "genre_id",
            foreignKey = @ForeignKey(name="fk_book_genre")
    )
    private Genre genre;

    @Column(name="avg_rating",nullable=true)
    private double avgRating;

    @Column(name="total_views",nullable=true)
    private int totalViews;

    public Book() {
    }

    public Book(Long bookId, String bookName, Author author, Genre genre, double avgRating, int totalViews) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.avgRating = avgRating;
        this.totalViews = totalViews;
    }

    public Long getbookId() {
        return bookId;
    }

    public void setbookId(Long bId) {
        this.bookId = bookId;
    }

    public String getbookName() {
        return bookName;
    }

    public void setbookName(String bName) {
        this.bookName = bookName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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


    @Override
    public String toString() {
        return "Book{" +
                "bId=" + bookId +
                ", bName='" + bookName + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", avgRating=" + avgRating +
                ", totalViews=" + totalViews +
                '}';
    }
}
