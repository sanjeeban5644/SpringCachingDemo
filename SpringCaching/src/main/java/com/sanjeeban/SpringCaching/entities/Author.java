package com.sanjeeban.SpringCaching.entities;

import jakarta.persistence.*;

@Entity
@Table(
        name="t_author",
        schema = "brs",
        uniqueConstraints = {
                @UniqueConstraint(name="uniqueAuthorIdName",columnNames = {"author_id","author_name"})
        }
)
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id",nullable = false)
    private Long authorId;

    @Column(name="author_name",nullable = false)
    private String authorName;

    public Author() {
    }

    public Author(Long authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                '}';
    }
}
