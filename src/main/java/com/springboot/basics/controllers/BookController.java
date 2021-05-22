package com.springboot.basics.controllers;

import com.springboot.basics.entities.Book;
import com.springboot.basics.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //    @RequestMapping(value = "/books", method = RequestMethod.GET) // Below Is Shortcut
    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int bookId) {
        return bookService.getBookById(bookId);
    }
}
