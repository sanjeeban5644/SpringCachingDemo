package com.sanjeeban.SpringCaching.services;


import com.sanjeeban.SpringCaching.entities.Genre;
import com.sanjeeban.SpringCaching.repositories.GenreRepository;
import jdk.jshell.spi.ExecutionControlProvider;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GenreService {

    private GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository){
     this.genreRepository = genreRepository;
    }

    public boolean doesGenreExists(String genre) {
        return genreRepository.getGenreByGenreName(genre).isPresent();
    }

    public void addGenre(String genreName){
        try{
            Genre genre = new Genre();
            genre.setGenreName(genreName);
            genreRepository.save(genre);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Long getGenreIdByGenreName(String genreName){
        Long id = -1L;

        try{
            id = genreRepository.getGenreIdByGenreName(genreName).orElseThrow(() ->  new NoSuchElementException("Genre Id is not present"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }


    public Genre getGenreByGenreId(Long id){
        return genreRepository.getGenreByGenreId(id)
                .orElseThrow(() -> new NoSuchElementException("Genre not present"));
    }



}
