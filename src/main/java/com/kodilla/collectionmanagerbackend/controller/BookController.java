package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.mapper.BookMapper;
import com.kodilla.collectionmanagerbackend.service.BookDbService;
import com.kodilla.collectionmanagerbackend.service.BooksCollectionDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    private BookDbService bookDbService;

    @Autowired
    private BooksCollectionDbService booksCollectionDbService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/{bookId}")
    public BookDto getBookById(@PathVariable Long bookId) {
        return bookMapper.mapToBookDto(bookDbService.findById(bookId));
    }

    @PostMapping("/{booksCollectionId}")
    public BookDto createBook(@PathVariable Long booksCollectionId, @RequestBody BookDto bookDto) {
        Book book = bookMapper.mapToBook(bookDto);
        //System.out.println(book.toString());

        return bookMapper.mapToBookDto(bookDbService.saveBook(book, booksCollectionId));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookDbService.deleteBook(id);
    }
}