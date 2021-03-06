package com.zlrx.am.bookservice.controller;


import com.zlrx.am.bookservice.domain.Book;
import com.zlrx.am.bookservice.service.BookService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("api/v1/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public Iterable<Book> getBooks() {
        log.info("This is a log from bookservice, instrumented by sleuth");
        return bookService.findAll();

    }

    @GetMapping("/{authorId}")
    public Book getBook(@PathVariable("authorId") Long authorId) {
        return bookService.findFirstByAuthorId(authorId);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.removeBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
