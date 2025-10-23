package com.sanjeeban.SpringCaching.services;


import com.sanjeeban.SpringCaching.dtos.PopularBookDto;
import com.sanjeeban.SpringCaching.dtos.RequestBookDto;
import com.sanjeeban.SpringCaching.entities.Book;
import com.sanjeeban.SpringCaching.repositories.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {


    private AuthorService authorService;

    private GenreService genreService;

    private BookRepository bookRepository;
    private ModelMapper modelMapper;

    @Autowired
    public BookService(AuthorService authorService,GenreService genreService,BookRepository bookRepository,ModelMapper modelMapper){
        this.authorService = authorService;
        this.genreService = genreService;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<Book> addNewBook(RequestBookDto request) {

        Book response = new Book();

        boolean isPresent = isBookPresent(request.getBookName());
        if(isPresent){
            Optional<Book> presentBook = bookRepository.findBookByBookName(request.getBookName());
            System.out.print("Book is present with name : "+request.getBookName());
            return presentBook;
        }

        String bookName = request.getBookName();
        String authorName = request.getAuthorName();
        String genre = request.getGenre();

        boolean authorExists = authorService.doesAuthoExists(authorName);
        boolean genreExists = genreService.doesGenreExists(genre);

        if(!authorExists){
            authorService.addAuthor(authorName);
        }
        if(!genreExists){
            genreService.addGenre(genre);
        }

        Long genreId = genreService.getGenreIdByGenreName(genre);
        Long authorId = authorService.getAuthorIdByAuthorName(authorName);


        response.setbookName(request.getBookName());
        response.setAuthor(authorService.getAuthorByAuthorId(authorId));
        response.setGenre(genreService.getGenreByGenreId(genreId));

        response.setAvgRating(0);
        response.setTotalViews(0);

        bookRepository.save(response);

        return Optional.ofNullable(response);
    }

    public List<Book> getAllBooks() {
        List<Book> listOfAllBooks = new ArrayList<>();

        try{
            listOfAllBooks = bookRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listOfAllBooks;
    }

    public String deleteBookByName(String bookName) {
        String response = "";
        if(isBookPresent(bookName)){
            Optional<Book> toBeDeletedBook = bookRepository.findBookByBookName(bookName);
            String toBeAppended = toBeDeletedBook.toString();
            bookRepository.delete(toBeDeletedBook.get());
            response+="Deleted Book details : "+toBeAppended;
        }else{
            response = "Book does not exist.";
        }
        return response;
    }

    public boolean isBookPresent(String bookName){
        Optional<Book> book = Optional.of(new Book());
        try{
            book = bookRepository.findBookByBookName(bookName);
        }catch (Exception e){
            e.printStackTrace();
        }

        return book.isPresent();
    }


    public PopularBookDto getMostPopularBook() {

        PopularBookDto response = new PopularBookDto();


        List<Book> listOfAllBooks = new ArrayList<>();
        listOfAllBooks = bookRepository.findAll();
        String bookName = "";
        int maxViews = 0;
        if(listOfAllBooks.isEmpty()){
            response.setRemarks("There are no Books to compare");
        }else{
            for(Book book : listOfAllBooks){
                if(book.getTotalViews()>maxViews){
                    bookName = book.getbookName();
                    maxViews = book.getTotalViews();
                }
            }
        }
        Optional<Book> mostPopularBook = bookRepository.findBookByBookName(bookName);

        if(mostPopularBook.isPresent()){
            response = modelMapper.map(mostPopularBook.get(), PopularBookDto.class);
        }
        return response;


    }
}
