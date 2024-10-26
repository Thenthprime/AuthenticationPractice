package edu.psu.swen888.authenticationpractice;

import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String publisher;
    private String publication;
    private Long isbn;

    public Book(String title, String author, String publication, String publisher, Long isbn){
        this.title = title;
        this.author = author;
        this.publication = publication;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublication() {
        return publication;
    }

    public String getPublisher() {
        return publisher;
    }

    public Long getIsbn() {
        return isbn;
    }
}
