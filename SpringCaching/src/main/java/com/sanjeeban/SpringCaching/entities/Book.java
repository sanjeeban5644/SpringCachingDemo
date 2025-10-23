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
    private Long bId;

    @Column(name="book_name",length=255,nullable=false)
    private String bName;

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

    public Book(Long bId, String bName, Author author, Genre genre, double avgRating, int totalViews) {
        this.bId = bId;
        this.bName = bName;
        this.author = author;
        this.genre = genre;
        this.avgRating = avgRating;
        this.totalViews = totalViews;
    }

    public Long getbId() {
        return bId;
    }

    public void setbId(Long bId) {
        this.bId = bId;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
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
                "bId=" + bId +
                ", bName='" + bName + '\'' +
                ", author=" + author +
                ", genre=" + genre +
                ", avgRating=" + avgRating +
                ", totalViews=" + totalViews +
                '}';
    }
}
