package com.kodilla.collectionmanagerbackend.mapper;

import com.kodilla.collectionmanagerbackend.domain.BooksCollection;
import com.kodilla.collectionmanagerbackend.domain.BooksCollectionDto;
import com.kodilla.collectionmanagerbackend.domain.BooksCollectionToFrontendDto;
import org.springframework.stereotype.Component;

@Component
public class BooksCollectionMapper {

    public BooksCollection mapToBooksCollection(BooksCollectionDto booksCollectionDto) {
        return new BooksCollection(booksCollectionDto.getCollectionName());
    }

    public BooksCollectionDto mapToBooksCollectionDto(BooksCollection booksCollection) {
        return new BooksCollectionDto(booksCollection.getCollectionName());
    }

    public BooksCollectionToFrontendDto mapToBooksCollectionToFrontend(BooksCollection booksCollection) {
        return new BooksCollectionToFrontendDto(booksCollection.getBooksCollectionId(),
                                                booksCollection.getCollectionName(),
                                                booksCollection.getUser().getUserId());
    }
}
