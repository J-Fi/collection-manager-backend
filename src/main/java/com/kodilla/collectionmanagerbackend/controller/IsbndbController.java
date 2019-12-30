package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.isbndb.client.IsbndbClient;
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
    private IsbndbClient isbndbClient;

    @GetMapping("/{isbn}")
    public BookDto getBookDto(@PathVariable String isbn) {
        try {
            BookDto bookResponse = isbndbClient.getJsonBookDto(isbn).getBody().getBookDto();
            return Optional.ofNullable(bookResponse).orElse(new BookDto());
        } catch (RestClientException e) {
            return new BookDto();
        }
    }
}
