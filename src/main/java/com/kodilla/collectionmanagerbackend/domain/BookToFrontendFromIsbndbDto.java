package com.kodilla.collectionmanagerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookToFrontendFromIsbndbDto {
    private String isbn;
    private String isbn13;
    private String title;
    private String publisher;
    private String synopsys;
    private String image;
    private String authors;
    private String subjects;
    private Integer publishDate;
}
