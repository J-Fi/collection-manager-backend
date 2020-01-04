package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<Book> fetchBooksByBooksCollectionId(Long booksCollectionId) {
        List<Book> list = Optional.ofNullable(bookRepo.findAll()).orElse(new ArrayList<>());
        List<Book> listFiltered = list.stream()
                .filter(book -> (book.getBooksCollection().getBooksCollectionId()).equals(booksCollectionId))
                .collect(Collectors.toList());
        return listFiltered;
    }

}
