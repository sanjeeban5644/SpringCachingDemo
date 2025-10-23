package com.sanjeeban.SpringCaching.entities;


import jakarta.persistence.*;

@Entity
@Table(
        name="t_genre",
        schema = "brs",
        uniqueConstraints = {
                @UniqueConstraint(name="uniqueGenreIdName",columnNames = {"genre_id","genre_name"})
        }
)
public class Genre {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id",nullable = false)
    private Long genreId;

    @Column(name="genre_name",nullable = false)
    private String genreName;

    public Genre() {
    }

    public Genre(Long genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                '}';
    }
}
