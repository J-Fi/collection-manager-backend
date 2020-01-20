package com.kodilla.collectionmanagerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COMMENTS_ON_BOOKS")
public class UserCommentOnBook {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "content", length = 65535, columnDefinition = "text")
    private String content;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Book book;

    public UserCommentOnBook(LocalDate date, String content) {
        this.date = date;
        this.content = content;
    }

    public UserCommentOnBook(LocalDate date, String content, Book book) {
        this.date = date;
        this.content = content;
        this.book = book;
    }
}
