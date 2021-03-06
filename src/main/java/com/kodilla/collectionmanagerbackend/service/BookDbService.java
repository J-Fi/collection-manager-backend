package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
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

    public Book updateBook(Long booksCollectionId, Long bookId, Book book) {
        List<Book> booksToUpdate = bookRepo.findAll().stream()
                .filter(b -> b.getBooksCollection().getBooksCollectionId().equals(booksCollectionId))
                .filter(b -> b.getBookId().equals(bookId))
                .collect(Collectors.toList());

        Book bookToUpdate = booksToUpdate.get(0);

        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setIsbn13(book.getIsbn13());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setPublisher(book.getPublisher());
        bookToUpdate.setSynopsys(book.getSynopsys());
        bookToUpdate.setImage(book.getImage());
        bookToUpdate.setAuthors(book.getAuthors());
        bookToUpdate.setSubjects(book.getSubjects());
        bookToUpdate.setPublishDate(book.getPublishDate());
        return bookRepo.save(bookToUpdate);
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
