package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.BooksCollection;
import com.kodilla.collectionmanagerbackend.domain.BooksCollectionDto;
import com.kodilla.collectionmanagerbackend.domain.BooksCollectionToFrontendDto;
import com.kodilla.collectionmanagerbackend.mapper.BooksCollectionMapper;
import com.kodilla.collectionmanagerbackend.service.BooksCollectionDbService;
import com.kodilla.collectionmanagerbackend.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books-collection")
public class BooksCollectionController {

    @Autowired
    private BooksCollectionMapper booksCollectionMapper;

    @Autowired
    private BooksCollectionDbService booksCollectionDbService;

    @Autowired
    private UserDbService userDbService;

    @PostMapping("/{userId}")
    public void createBooksCollection(@PathVariable Long userId, @RequestBody BooksCollectionDto booksCollectionDto) {
        BooksCollection booksCollection = booksCollectionMapper.mapToBooksCollection(booksCollectionDto);
        booksCollection.setUser(userDbService.findById(userId));
        booksCollectionDbService.saveBooksCollection(booksCollection);
    }

    @GetMapping("/collectionid/{userId}")
    public BooksCollectionToFrontendDto getBooksCollectionId (@PathVariable Long userId) {
        return booksCollectionMapper.mapToBooksCollectionToFrontend(booksCollectionDbService.findBooksCollectionIdByUserId(userId));
    }
}
