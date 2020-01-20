package com.kodilla.collectionmanagerbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.Lob;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookFromFrontendDto {
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
    private String authors;

    @Nullable
    @JsonProperty("subjects")
    private String subjects;

    @JsonProperty("publishDate")
    private Integer publishDate;
}
