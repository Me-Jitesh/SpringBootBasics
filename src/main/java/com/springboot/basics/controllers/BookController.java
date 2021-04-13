package com.springboot.basics.controllers;

import com.springboot.basics.entities.Book;
import com.springboot.basics.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("ALL")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //    @RequestMapping(value = "/books", method = RequestMethod.GET) // Below Annotation  Is Shortcut
    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        System.out.println(book);

        Book b = this.bookService.addBook(book);
        return b;
    }

    @DeleteMapping("/books/{id}")
    public void delBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        System.out.println("Deleting Completed");
    }

    @PutMapping("/books/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable("id") int bId) {
        this.bookService.updateBook(book, bId);
        return book;
    }
}
