package com.kodilla.collectionmanagerbackend.repository;

import com.kodilla.collectionmanagerbackend.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    Optional<Book> findById(Long id);
}