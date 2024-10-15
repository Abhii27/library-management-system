package com.abhii.library_management_system.service;

import com.abhii.library_management_system.model.Book;
import com.abhii.library_management_system.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public Optional<Book> findBookById(Long id){
        return bookRepository.findById(id);
    }
}
