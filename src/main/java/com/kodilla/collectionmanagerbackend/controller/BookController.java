package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BookController {

    @Autowired
    private DbService dbService;

    @GetMapping("/{userId}/{collectionId}")
    public List<Book> findAllBooksInCollection(@PathVariable String userId, @PathVariable String collectionId) {
        System.out.println("The method findAllBooksInCollection has been just called...");
        return dbService.createList(userId, collectionId);
    }

    @GetMapping("/{userId}")
    public List<Book> findAllBooksOfUser(@PathVariable String userId) {
        System.out.println("The method findAllBooks has been just called...");
        return dbService.createList(userId);
    }

    @GetMapping
    public List<Book> findAllBooks() {
        System.out.println("The method findAllBooks has been just called...");
        return dbService.createList();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return book;
    }

    @DeleteMapping("/{userId}/{collectionId}/{isbn}")
    public void deleteBook(@PathVariable String userId, @PathVariable String collectionId, @PathVariable String isbn) {

    }

    @PutMapping
    public Book updateBook() {
        return new Book("1", "Title4", "Author4", 1990,43.22, "Czarna owca", "Opinion 4");
    }
}
