package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.domain.Film;
import com.kodilla.collectionmanagerbackend.repository.BookRepository;
import com.kodilla.collectionmanagerbackend.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmDbService {

    @Autowired
    private FilmRepository filmRepo;

    @Autowired
    private FilmsCollectionDbService filmsCollectionDbService;

    public Film saveFilm (Film film, Long filmsCollectionId) {
        film.setFilmsCollection(filmsCollectionDbService.findById(filmsCollectionId));
        return filmRepo.save(film);
    }

    public void deleteFilm(final Long id) {
        filmRepo.deleteById(id);
    }

    public Film findById(final Long id) {
        return filmRepo.findById(id).orElse(new Film());
    }

    public List<Film> fetchFilmsByFilmsCollectionId(Long filmsCollectionId) {
        List<Film> list = Optional.ofNullable(filmRepo.findAll()).orElse(new ArrayList<>());
        List<Film> listFiltered = list.stream()
                .filter(film -> (film.getFilmsCollection().getFilmsCollectionId()).equals(filmsCollectionId))
                .collect(Collectors.toList());
        return listFiltered;
    }
}
