package com.springboot.basics.controllers;

import com.springboot.basics.entities.Book;
import com.springboot.basics.service.BookServiceForDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
@RestController
public class BookController {

    @Autowired
    private BookServiceForDb bookService;

    //    @RequestMapping(value = "/books", method = RequestMethod.GET) // Below Annotation  Is Shortcut
    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable("id") int bookId) {
        Book book = bookService.getBookById(bookId);
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

//    Sending Response Code

    @GetMapping("/respAllBooks")
    public ResponseEntity<List<Book>> allBooks() {
        List<Book> list = this.bookService.getAllBooks();
        if (list.size() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
    }

    @GetMapping("/respBook/{id}")
    public ResponseEntity<Book> respGetBook(@PathVariable("id") int bookId) {
        Book book = bookService.getBookById(bookId);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/respBooks")
    public ResponseEntity<Book> respCreateBook(@RequestBody Book book) {
        Book b = null;
        try {
            System.out.println(book);
            b = this.bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/respBook/{id}")
    public ResponseEntity<Void> respDelBook(@PathVariable("id") int id) {
        try {
            bookService.deleteBook(id);
            System.out.println("Deleting Completed");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Deleting Failed");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PutMapping("/respBook/{id}")
    public ResponseEntity<Book> respUpdateBook(@RequestBody Book book, @PathVariable("id") int bId) {
        try {
            this.bookService.updateBook(book, bId);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
