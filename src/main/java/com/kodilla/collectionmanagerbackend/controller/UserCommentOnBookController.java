package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBook;
import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBookDto;
import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBookJsonDto;
import com.kodilla.collectionmanagerbackend.mapper.UserCommentOnBookJsonDtoMapper;
import com.kodilla.collectionmanagerbackend.mapper.UserCommentOnBookMapper;
import com.kodilla.collectionmanagerbackend.service.BookDbService;
import com.kodilla.collectionmanagerbackend.service.CommentOnBookDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/comment")
public class UserCommentOnBookController {

    @Autowired
    private UserCommentOnBookMapper userCommentOnBookMapper;

    @Autowired
    private CommentOnBookDbService commentOnBookDbService;

    @Autowired
    private BookDbService bookDbService;

    @Autowired
    private UserCommentOnBookJsonDtoMapper userCommentOnBookJsonDtoMapper;

    @GetMapping("{bookId}")
    public List<UserCommentOnBookJsonDto> getAllUserCommentsOnBook(@PathVariable Long bookId) {
        return userCommentOnBookJsonDtoMapper.mapCommentDtoToJson(commentOnBookDbService.getAllUserCommentsOnBook(bookId));
    }

    @PutMapping("/{commentId}")
    public UserCommentOnBookDto updateComment(@RequestBody UserCommentOnBookDto userCommentOnBookDto, @PathVariable Long commentId) {
        return userCommentOnBookMapper.mapToUserCommentOnBookDto(commentOnBookDbService.updateComment(userCommentOnBookMapper.mapToUserCommentOnBookForUpdate(userCommentOnBookDto), commentId));
    }

    @PostMapping("/{bookId}")
    public UserCommentOnBookDto saveComment(@RequestBody UserCommentOnBookDto userCommentOnBookDto, @PathVariable Long bookId) {
        UserCommentOnBook userCommentOnBook = userCommentOnBookMapper.mapToUserCommentOnBook(userCommentOnBookDto);
        userCommentOnBook.setBook(bookDbService.findById(bookId));
        return userCommentOnBookMapper.mapToUserCommentOnBookDto(commentOnBookDbService.saveComment(userCommentOnBook));
    }

}
