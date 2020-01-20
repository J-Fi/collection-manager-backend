package com.kodilla.collectionmanagerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BooksCollectionToFrontendDto {
    private Long booksCollectionId;
    private String collectionName;
    private Long userId;

}
