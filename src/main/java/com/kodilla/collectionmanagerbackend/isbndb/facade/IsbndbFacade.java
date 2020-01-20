package com.kodilla.collectionmanagerbackend.isbndb.facade;

import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.domain.BookToFrontendFromIsbndbDto;
import com.kodilla.collectionmanagerbackend.mapper.BookMapper;
import com.kodilla.collectionmanagerbackend.service.IsbndbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IsbndbFacade {

    @Autowired
    private IsbndbService isbndbService;

    @Autowired
    private BookMapper bookMapper;

    public BookToFrontendFromIsbndbDto getJsonBookDto(String isbn) {
        return bookMapper.mapToBookToFrontendFromIsbndbDto(isbndbService.getJsonBookDto(isbn));
    }
}
