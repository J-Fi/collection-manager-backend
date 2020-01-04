package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.domain.BookToFrontendDto;
import com.kodilla.collectionmanagerbackend.isbndb.client.IsbndbClient;
import com.kodilla.collectionmanagerbackend.mapper.BookMapper;
import com.kodilla.collectionmanagerbackend.service.IsbndbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

@RestController
@RequestMapping("/v1/isbndb")
public class IsbndbController {

    @Autowired
    private IsbndbService isbndbService;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping("/{isbn}")
    public BookToFrontendDto getBookToFrontendDto(@PathVariable String isbn) {
        try {
            BookDto bookResponse = isbndbService.getJsonBookDto(isbn);
            return bookMapper.mapToBookToFrontendDto(Optional.ofNullable(bookResponse).orElse(new BookDto()));
        } catch (RestClientException e) {
            return new BookToFrontendDto();
        }
    }
}
