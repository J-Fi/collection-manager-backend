package com.kodilla.collectionmanagerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookToFrontendDto {
    private Long bookId;
    private String isbn;
    private String isbn13;
    private String title;
    private String publisher;
    private String synopsys;
    private String image;
    private String authors;
    private String subjects;
    private Integer publishDate;
    private Long booksCollectionId;

    public BookToFrontendDto(String isbn, String isbn13, String title, String publisher, String synopsys, String image, String authors, String subjects, Integer publishDate) {
        this.isbn = isbn;
        this.isbn13 = isbn13;
        this.title = title;
        this.publisher = publisher;
        this.synopsys = synopsys;
        this.image = image;
        this.authors = authors;
        this.subjects = subjects;
        this.publishDate = publishDate;
    }
}
