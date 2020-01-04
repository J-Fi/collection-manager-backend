package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.domain.BookToFrontendDto;
import com.kodilla.collectionmanagerbackend.mapper.BookMapper;
import com.kodilla.collectionmanagerbackend.service.BookDbService;
import com.kodilla.collectionmanagerbackend.service.BooksCollectionDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/book")
public class BookController {

    @Autowired
    private BookDbService bookDbService;

/*    @Autowired
    private BooksCollectionDbService booksCollectionDbService;*/

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
    public BookToFrontendDto createBook(@PathVariable Long booksCollectionId, @RequestBody BookToFrontendDto bookToFrontendDto) {
        Book book = bookMapper.mapToBook(bookToFrontendDto);
        //System.out.println(book.toString());
        return bookMapper.mapToBookToFrontendDto(bookDbService.saveBook(book, booksCollectionId));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookDbService.deleteBook(id);
    }
}