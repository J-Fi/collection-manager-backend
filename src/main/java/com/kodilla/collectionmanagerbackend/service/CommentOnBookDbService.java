package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBook;
import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBookDto;
import com.kodilla.collectionmanagerbackend.mapper.UserCommentOnBookMapper;
import com.kodilla.collectionmanagerbackend.repository.CommentOnBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentOnBookDbService {

    @Autowired
    private CommentOnBookRepository commentOnBookRepo;

    @Autowired
    private UserCommentOnBookMapper userCommentOnBookMapper;

    public UserCommentOnBook saveComment(UserCommentOnBook userCommentOnBook) {
        return commentOnBookRepo.save(userCommentOnBook);
    }

    public List<UserCommentOnBook> getAllUserCommentsOnBook(final Long bookId) {
        return commentOnBookRepo.findAll().stream()
                .filter(c -> (c.getBook().getBookId()).equals(bookId))
                .collect(Collectors.toList());
    }

    public UserCommentOnBook updateComment(UserCommentOnBook userCommentOnBook, final Long commentId) {
        UserCommentOnBook userCommentOnBookToUpdate = commentOnBookRepo.findById(commentId).orElse(new UserCommentOnBook());
        userCommentOnBookToUpdate.setCommentId(commentId);
        userCommentOnBookToUpdate.setContent(userCommentOnBook.getContent());
        userCommentOnBookToUpdate.setDate(userCommentOnBook.getDate());
        userCommentOnBookToUpdate.setBook(userCommentOnBook.getBook());
        return commentOnBookRepo.save(userCommentOnBookToUpdate);
    }

}
