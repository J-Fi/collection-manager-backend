package com.kodilla.collectionmanagerbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDto {

    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("isbn13")
    private String isbn13;

    @JsonProperty("title")
    private String title;

    @JsonProperty("publisher")
    private String publisher;

    @Lob
    @JsonProperty("synopsys")
    private String synopsys;

    @JsonProperty("image")
    private String image;

    @JsonProperty("authors")
    private List<Author> authors;

    @JsonProperty("subjects")
    private List<Subject> subjects;

    @JsonProperty("date_published")
    private Integer publishDate;

}
