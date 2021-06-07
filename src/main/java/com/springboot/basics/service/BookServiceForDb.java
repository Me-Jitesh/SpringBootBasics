package com.springboot.basics.service;

import com.springboot.basics.dao.BookRepository;
import com.springboot.basics.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceForDb {

    @Autowired
    private BookRepository bookRepository;

    //    Get All Books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    //    Get Book By ID
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    //    Add Book
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    //    Delete Book
    public void deleteBook(int bId) {
        bookRepository.deleteById(bId);
    }

    //      Update Book
    public void updateBook(Book book, int bId) {
        book.setId(bId);
        bookRepository.save(book);
    }
}

