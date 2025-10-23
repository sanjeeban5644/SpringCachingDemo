package com.sanjeeban.SpringCaching.services;


import com.sanjeeban.SpringCaching.entities.Author;
import com.sanjeeban.SpringCaching.entities.Genre;
import com.sanjeeban.SpringCaching.repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class AuthorService {


    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    public boolean doesAuthoExists(String authorName){
        return authorRepository.getAuthorByAuthorName(authorName).isPresent();
    }

    public void addAuthor(String authorName){

        try{
            Author author = new Author();
            author.setAuthorName(authorName);
            authorRepository.save(author);
        }catch(Exception e){
            e.printStackTrace();
        }

    }


    public Long getAuthorIdByAuthorName(String authorName){
        Long id = -1L;

        try{
            id = authorRepository.getAuthorIdByAuthorName(authorName).orElseThrow(() ->  new NoSuchElementException("Author Id is not present"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }


    public Author getAuthorByAuthorId(Long id) {
        return authorRepository.getAuthorByAuthorId(id)
                .orElseThrow(() -> new NoSuchElementException("Author does not exist"));
    }



}
