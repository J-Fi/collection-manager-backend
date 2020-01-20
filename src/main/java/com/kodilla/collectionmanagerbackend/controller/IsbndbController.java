package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.BookToFrontendFromIsbndbDto;
import com.kodilla.collectionmanagerbackend.isbndb.facade.IsbndbFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/isbndb")
public class IsbndbController {

    public static float numberOfCalls = 0;

    @Autowired
    private IsbndbFacade isbndbFacade;

    @GetMapping("/{isbn}")
    public BookToFrontendFromIsbndbDto getBookToFrontendFromIsbndbDto(@PathVariable String isbn) {
        numberOfCalls++;
        return isbndbFacade.getJsonBookDto(isbn);
    }
}
