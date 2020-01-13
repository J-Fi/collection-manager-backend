package com.kodilla.collectionmanagerbackend.mapper;

import com.kodilla.collectionmanagerbackend.domain.BooksCollection;
import com.kodilla.collectionmanagerbackend.domain.BooksCollectionDto;
import com.kodilla.collectionmanagerbackend.domain.FilmsCollection;
import com.kodilla.collectionmanagerbackend.domain.FilmsCollectionDto;
import org.springframework.stereotype.Component;

@Component
public class FilmsCollectionMapper {
    public FilmsCollection mapToFilmsCollection (FilmsCollectionDto filmsCollectionDto) {
        return new FilmsCollection(filmsCollectionDto.getCollectionName());
    }

    public BooksCollectionDto mapToFilmsCollectionDto(FilmsCollection filmsCollection) {
        return new BooksCollectionDto(filmsCollection.getCollectionName());
    }
}
