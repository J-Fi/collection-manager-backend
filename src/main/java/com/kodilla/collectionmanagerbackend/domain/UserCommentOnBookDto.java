package com.kodilla.collectionmanagerbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCommentOnBookDto {

    @JsonProperty("content")
    private String content;

    @JsonProperty("date")
    private Date date;

    @JsonProperty("bookId")
    private Long bookId;

    public UserCommentOnBookDto(String content, Date date) {
        this.content = content;
        this.date = date;
    }
}
