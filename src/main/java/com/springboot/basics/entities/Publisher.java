package com.springboot.basics.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int publisherId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToOne(mappedBy = "publisher")       //  mappedBy for preventing Extra Column
    @JsonBackReference
    private Book book;

    public Publisher() {
    }

    public Publisher(int publisherId, String firstName, String lastName) {
        this.publisherId = publisherId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int id) {
        this.publisherId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
