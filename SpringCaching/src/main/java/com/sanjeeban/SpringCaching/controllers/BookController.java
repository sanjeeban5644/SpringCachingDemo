package com.sanjeeban.SpringCaching.controllers;


import com.sanjeeban.SpringCaching.dtos.BookDto;
import com.sanjeeban.SpringCaching.dtos.PopularBookDto;
import com.sanjeeban.SpringCaching.dtos.RequestBookDto;
import com.sanjeeban.SpringCaching.dtos.ResponseBookDto;
import com.sanjeeban.SpringCaching.entities.Book;
import com.sanjeeban.SpringCaching.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

    @GetMapping("/getTheBook")
    public ResponseEntity<?> getBook(@RequestParam(name="bookName") String bookName){

        try{
            BookDto response = bookService.getBook(bookName);

            if (response != null) {
                return ResponseEntity.ok(response);
            }else{
                Map<String, Object> error = new HashMap<>();
                error.put("status", HttpStatus.NOT_FOUND.value());
                error.put("message", "Book not found with name: " + bookName);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
