package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookDbService {

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BooksCollectionDbService booksCollectionDbService;

    public Book saveBook (Book book, Long booksCollectionId) {
        book.setBooksCollection(booksCollectionDbService.findById(booksCollectionId));
        return bookRepo.save(book);
    }

    public void deleteBook(final Long id) {
        bookRepo.deleteById(id);
    }

    public Book findById(final Long id) {
        return bookRepo.findById(id).orElse(new Book());
    }
}
