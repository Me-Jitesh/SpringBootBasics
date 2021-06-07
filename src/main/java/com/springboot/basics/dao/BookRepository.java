package com.springboot.basics.dao;

import com.springboot.basics.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
