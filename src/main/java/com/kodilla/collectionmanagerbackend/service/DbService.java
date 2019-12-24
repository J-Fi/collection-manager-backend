package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbService {
    private List<Book> booksList = new ArrayList<>();

    private Book book1 = new Book("user1", "Title1",  "Author1", 2001, 23.34, "Nasza Księzgarnia", "Opinion1");
    private Book book2 = new Book("user2", "Title2", "Author2", 2002, 33.34, "Nowy Wydawca", "Opinion2");

    public List<Book> createList(String userId, String collectionId) {
        if (userId.equals("user1") && collectionId.equals("collection1")) {
            booksList.add(book1);
            booksList.add(book2);
        }
        return booksList;
    }

    public List<Book> createList(String userId) {
        if (userId.equals("user1")) {
            booksList.add(book1);
            booksList.add(book2);
        }
        return booksList;
    }

    public List<Book> createList() {
        booksList.add(book1);
        booksList.add(book2);
        return booksList;
    }

    public void addBook(Book book) {

    }
}
