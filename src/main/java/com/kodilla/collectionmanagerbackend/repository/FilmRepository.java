package com.kodilla.collectionmanagerbackend.repository;

import com.kodilla.collectionmanagerbackend.domain.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface FilmRepository extends CrudRepository<Film, Long> {
    @Override
    Optional<Film> findById(Long id);

    @Override
    List<Film> findAll();
}
