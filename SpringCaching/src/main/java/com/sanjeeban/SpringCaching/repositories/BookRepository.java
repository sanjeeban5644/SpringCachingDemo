package com.sanjeeban.SpringCaching.repositories;

import com.sanjeeban.SpringCaching.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

    @Query("SELECT t FROM Book t where t.bookName = :bookName")
    public Optional<Book> findBookByBookName(@Param("bookName") String bookName);
}
