package com.kodilla.collectionmanagerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String isbn;
    private String title;
    private List<String> authorsList;
    private Integer publishYear;
    private Double price;
    private String publisherName;
    private String opinion;
}
