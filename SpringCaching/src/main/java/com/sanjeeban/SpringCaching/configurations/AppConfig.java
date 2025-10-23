package com.sanjeeban.SpringCaching.configurations;

import com.sanjeeban.SpringCaching.dtos.BookDto;
import com.sanjeeban.SpringCaching.dtos.PopularBookDto;
import com.sanjeeban.SpringCaching.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


        @Bean
        public ModelMapper modelMapper() {
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.typeMap(Book.class, PopularBookDto.class).addMappings(mapper -> {
                mapper.map(src -> src.getAuthor().getAuthorName(), PopularBookDto::setBookAuthor);
                mapper.map(src -> src.getGenre().getGenreName(), PopularBookDto::setBookGenre);
            });
            modelMapper.typeMap(Book.class, BookDto.class).addMappings(mapper -> {
                mapper.map(src -> src.getAuthor().getAuthorName(), BookDto::setBookAuthor);
                mapper.map(src -> src.getGenre().getGenreName(), BookDto::setBookGenre);
            });
            return modelMapper;
        }

}
