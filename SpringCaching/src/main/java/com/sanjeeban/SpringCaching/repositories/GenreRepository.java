package com.sanjeeban.SpringCaching.repositories;

import com.sanjeeban.SpringCaching.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,Long> {

    @Query("SELECT g FROM Genre g WHERE g.genreName = :genreName")
    Optional<Genre> getGenreByGenreName(@Param("genreName") String genreName);


    @Query("SELECT g FROM Genre g WHERE g.genreId = :genreId")
    Optional<Genre> getGenreByGenreId(@Param("genreId") Long genreId);


    @Query("SELECT T.genreId FROM Genre T WHERE T.genreName = :genreName")
    Optional<Long> getGenreIdByGenreName(@Param("genreName") String genreName);



}
