package com.kodilla.collectionmanagerbackend.mapper;

import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBook;
import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBookDto;
import com.kodilla.collectionmanagerbackend.service.BookDbService;
import com.kodilla.collectionmanagerbackend.service.CommentOnBookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserCommentOnBookMapper {

    @Autowired
    private BookDbService bookDbService;

    public UserCommentOnBook mapToUserCommentOnBook(UserCommentOnBookDto userCommentOnBookDto) {
        return new UserCommentOnBook(userCommentOnBookDto.getDate(),
                userCommentOnBookDto.getContent());
    }

    public UserCommentOnBook mapToUserCommentOnBookForUpdate (UserCommentOnBookDto userCommentOnBookDto) {
        return new UserCommentOnBook(userCommentOnBookDto.getDate(),
                userCommentOnBookDto.getContent(),
                bookDbService.findById(userCommentOnBookDto.getBookId()));
    }

    public UserCommentOnBookDto mapToUserCommentOnBookDto (UserCommentOnBook userCommentOnBook) {
        return new UserCommentOnBookDto(userCommentOnBook.getContent(),
                userCommentOnBook.getDate(),
                userCommentOnBook.getBook().getBookId());
    }

    public List<UserCommentOnBookDto> mapToCommentListDto (List<UserCommentOnBook> commentOnBookList) {
        return commentOnBookList.stream().map(userCommentOnBook -> new UserCommentOnBookDto(userCommentOnBook.getContent(),
                userCommentOnBook.getDate())).collect(Collectors.toList());
    }
}
