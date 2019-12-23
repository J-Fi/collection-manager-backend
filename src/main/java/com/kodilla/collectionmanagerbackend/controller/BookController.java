package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {

    private List<Book> booksList = new ArrayList<>();
    private Book book1 = new Book("user1", "Title1",  "Author1", 2001, 23.34, "Nasza Księzgarnia", "Opinion1");
    private Book book2 = new Book("user2", "Title2", "Author2", 2002, 33.34, "Nowy Wydawca", "Opinion2");



    @GetMapping("/{userId}/{collectionId}")
    public List<Book> findAllBooksInCollection(@PathVariable String userId, @PathVariable String collectionId) {
        System.out.println("The method findAllBooksInCollection has been just called...");
        return createList(userId, collectionId);
    }

    @GetMapping("/{userId}")
    public List<Book> findAllBooksOfUser(@PathVariable String userId) {
        System.out.println("The method findAllBooks has been just called...");
        return createList(userId);
    }

    @GetMapping
    public List<Book> findAllBooks() {
        System.out.println("The method findAllBooks has been just called...");
        return booksList;
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        booksList.add(book1);
        booksList.add(book2);
        booksList.add(book);
        return book;
    }


    public List<Book> createList(String userId, String collectionId) {
        List<Book> booksList = new ArrayList<>();
        Book book1 = new Book(userId, collectionId, "Author1", 2001, 23.34, "Nasza Księzgarnia", "Opinion1");
        Book book2 = new Book("user2", collectionId, "Author2", 2002, 33.34, "Nowy Wydawca", "Opinion2");
        booksList.add(book1);
        booksList.add(book2);
        return booksList;
    }

    public List<Book> createList(String userId) {
        List<Book> booksList = new ArrayList<>();
        Book book1 = new Book(userId, "Title1", "Author1", 2001, 23.34, "Nasza Księzgarnia", "Opinion1");
        Book book2 = new Book("user2", "Title2", "Author2", 2002, 33.34, "Nowy Wydawca", "Opinion2");
        booksList.add(book1);
        booksList.add(book2);
        return booksList;
    }

    public List<Book> createList() {
        List<Book> booksList = new ArrayList<>();
        Book book1 = new Book("user1", "Title1", "Author1", 2001, 23.34, "Nasza Księzgarnia", "Opinion1");
        Book book2 = new Book("user2", "Title2", "Author2", 2002, 33.34, "Nowy Wydawca", "Opinion2");
        booksList.add(book1);
        booksList.add(book2);
        return booksList;
    }
}
