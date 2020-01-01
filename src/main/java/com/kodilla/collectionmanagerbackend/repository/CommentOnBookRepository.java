package com.kodilla.collectionmanagerbackend.repository;

import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface CommentOnBookRepository extends CrudRepository<UserCommentOnBook, Long> {

    List<UserCommentOnBook> findAll();
}
