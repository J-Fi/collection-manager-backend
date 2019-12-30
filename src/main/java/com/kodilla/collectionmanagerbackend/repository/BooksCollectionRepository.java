package com.kodilla.collectionmanagerbackend.repository;

import com.kodilla.collectionmanagerbackend.domain.BooksCollection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface BooksCollectionRepository extends CrudRepository<BooksCollection, Long> {
}
