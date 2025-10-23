package com.sanjeeban.SpringCaching.controllers;


import com.sanjeeban.SpringCaching.dtos.PopularBookDto;
import com.sanjeeban.SpringCaching.dtos.RequestBookDto;
import com.sanjeeban.SpringCaching.dtos.ResponseBookDto;
import com.sanjeeban.SpringCaching.entities.Book;
import com.sanjeeban.SpringCaching.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }



    @PostMapping("/addBook")
    public ResponseEntity<?> addNewBook(@RequestBody RequestBookDto request){
        Optional<Book> response = Optional.of(new Book());
        try{
            response = bookService.addNewBook(request);
        }catch(Exception e){
            e.printStackTrace();
        }
        if(response.isPresent()){
            return ResponseEntity.ok(response.get());
        }else{
            return ResponseEntity.status(HttpStatus.CONFLICT)
                            .body("Error in adding Book"+request.getBookName());
        }
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> listOfAllBooks = new ArrayList<>();

        try{
            listOfAllBooks = bookService.getAllBooks();
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(listOfAllBooks);
    }

    @DeleteMapping("/deleteBook")
    public ResponseEntity<String> deleteBook(@RequestParam(name="BookName") String bookName){
        String response = "";

        try{
            response = bookService.deleteBookByName(bookName);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getMostPopularBook")
    public ResponseEntity<PopularBookDto> getMostPopularBook(){
        PopularBookDto response = new PopularBookDto();

        try{
            response = bookService.getMostPopularBook();
        }catch(Exception e){
            e.printStackTrace();
        }


        return ResponseEntity.ok(response);
    }




}
