package com.sanjeeban.SpringCaching.repositories;


import com.sanjeeban.SpringCaching.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT T FROM Author T where T.authorName = :authorName")
    public Optional<Author> getAuthorByAuthorName(@Param("authorName") String authorName);

    @Query("SELECT T FROM Author T where T.authorId = :authorId")
    public Optional<Author> getAuthorByAuthorId(@Param("authorId") Long authorId);

    @Query("SELECT T.authorId FROM Author T WHERE T.authorName = :authorName")
    Optional<Long> getAuthorIdByAuthorName(@Param("authorName") String authorName);

}
