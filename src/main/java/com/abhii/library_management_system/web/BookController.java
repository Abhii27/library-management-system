package com.abhii.library_management_system.web;

import com.abhii.library_management_system.model.Book;
import com.abhii.library_management_system.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books =  bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public Optional<Book> getBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }

    @PostMapping("add")
    public ResponseEntity<Book> addNewBook(@RequestBody Book book){
        Book saveBook =  bookService.createBook(book);

        if(saveBook == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(saveBook,HttpStatus.OK);

    }

    @PutMapping("update")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
