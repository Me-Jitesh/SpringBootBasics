package com.springboot.basics.service;

import com.springboot.basics.entities.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//      This Fake Service , In Real App Must add Data From  Database
@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "DoDo", "Dodo"));
        list.add(new Book(2, "HoBo", "hobo"));
        list.add(new Book(3, "GoGo", "Gogo"));
        list.add(new Book(4, "Jholo", "jholo"));
        list.add(new Book(5, "Hola", "hola"));
        list.add(new Book(6, "DoJo", "Dojo"));
    }

    //    Get All Books
    public List<Book> getAllBooks() {
        return list;
    }

    //    Get Book By ID
    public Book getBookById(int id) {
        Book book = null;
        try {
            //        We Can Perform Filter Here By Many Ways like for each loop , stream.filter , stream.map function etc
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    //    Add Book
    public Book addBook(Book book) {
        list.add(book);
        return book;
    }

    //    Delete Book
    public void deleteBook(int bId) {
        //        We Can Perform Filter Here By Many Ways like for each loop , stream class ,map function etc
        list = list.stream().filter(book -> book.getId() != bId).collect(Collectors.toList());
    }

    //      Update Book
    public void updateBook(Book book, int bId) {
        //        We Can Perform Filter Here By Many Ways like for each loop , stream.filter function , map function etc
        list = list.stream().map(b -> {
            if (b.getId() == bId) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
