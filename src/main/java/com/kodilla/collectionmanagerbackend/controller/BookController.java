package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.domain.BookFromFrontendDto;
import com.kodilla.collectionmanagerbackend.domain.BookToFrontendDto;
import com.kodilla.collectionmanagerbackend.mapper.BookMapper;
import com.kodilla.collectionmanagerbackend.service.BookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    private BookDbService bookDbService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/{bookId}")
    public BookToFrontendDto getBookById(@PathVariable Long bookId) {
        return bookMapper.mapToBookToFrontendDto(bookDbService.findById(bookId));
    }

    @GetMapping("/list/{booksCollectionId}")
    public List<BookToFrontendDto> getBooksCollection(@PathVariable Long booksCollectionId) {
        return bookMapper.mapToBookToFrontendDtoList(bookDbService.fetchBooksByBooksCollectionId(booksCollectionId));
    }

    @PostMapping("/{booksCollectionId}")
    public BookFromFrontendDto createBook(@PathVariable Long booksCollectionId, @RequestBody BookFromFrontendDto bookFromFrontendDto) {
        Book book = bookMapper.mapBookFromFrontendDtoToBook(bookFromFrontendDto);
        //System.out.println(book.toString());
        return bookMapper.mapBookToBookFromFrontendDto(bookDbService.saveBook(book, booksCollectionId));
    }

    @PutMapping("/{booksCollectionId}/{bookId}")
    public BookFromFrontendDto updateBook(@PathVariable Long booksCollectionId, @PathVariable Long bookId, @RequestBody BookFromFrontendDto bookFromFrontendDto) {
        return bookMapper.mapBookToBookFromFrontendDto(bookDbService.updateBook(booksCollectionId, bookId, bookMapper.mapBookFromFrontendDtoToBook(bookFromFrontendDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookDbService.deleteBook(id);
    }
}