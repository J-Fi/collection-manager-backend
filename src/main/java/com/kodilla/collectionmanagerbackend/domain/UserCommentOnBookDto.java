package com.kodilla.collectionmanagerbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCommentOnBookDto {

    @JsonProperty("content")
    private String content;

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("bookId")
    private Long bookId;

    public UserCommentOnBookDto(String content, LocalDate date) {
        this.content = content;
        this.date = date;
    }
}
