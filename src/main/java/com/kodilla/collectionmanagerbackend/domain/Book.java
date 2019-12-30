package com.kodilla.collectionmanagerbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOKS")
public class Book {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", unique = true)
    private Long bookId;

    @NotNull
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "title")
    private String title;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "synopsys", length = 65535, columnDefinition = "text")
    private String synopsys;

    @Column(name = "image_url")
    private String image;

    @Column(name = "authors")
    private String authors;

    @Column(name = "publish_date")
    private Integer publishDate;

    @Transient
    private Long booksCollectionId;

    @ManyToOne
    @JoinColumn(name = "books_collection_id")
    private BooksCollection booksCollection;

    public Book(String isbn, String title, String publisher, String synopsys, String image, String authors, Integer publishDate) {
        this.isbn = isbn;
        this.title = title;
        this.publisher = publisher;
        this.synopsys = synopsys;
        this.image = image;
        this.authors = authors;
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", synopsys='" + synopsys + '\'' +
                ", image='" + image + '\'' +
                ", authors='" + authors + '\'' +
                ", publishDate=" + publishDate +
                '}';
    }
}
