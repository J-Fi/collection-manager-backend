package com.kodilla.collectionmanagerbackend.repository;

import com.kodilla.collectionmanagerbackend.domain.FilmsCollection;
import org.springframework.data.repository.CrudRepository;

public interface FilmsCollectionRepository extends CrudRepository<FilmsCollection, Long> {

}
