package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.*;
import com.kodilla.collectionmanagerbackend.mapper.BookMapper;
import com.kodilla.collectionmanagerbackend.mapper.FilmMapper;
import com.kodilla.collectionmanagerbackend.service.BookDbService;
import com.kodilla.collectionmanagerbackend.service.FilmDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/film")
public class FilmController {

    @Autowired
    private FilmDbService filmDbService;

/*    @Autowired
    private BooksCollectionDbService booksCollectionDbService;*/

    @Autowired
    private FilmMapper filmMapper;

    @GetMapping("/{filmId}")
    public FilmToFrontendDto getFilmById(@PathVariable Long filmId) {
        return filmMapper.mapToFilmToFrontendDto(filmDbService.findById(filmId));
    }

    @GetMapping("/list/{filmsCollectionId}")
    public List<FilmToFrontendDto> getFilmsCollection(@PathVariable Long filmsCollectionId) {
        return filmMapper.mapToFilmToFrontendDtoList(filmDbService.fetchFilmsByFilmsCollectionId(filmsCollectionId));
    }

    @PostMapping("/{filmsCollectionId}")
    public FilmFromFrontendDto createFilm(@PathVariable Long filmsCollectionId, @RequestBody FilmFromFrontendDto filmFromFrontendDto) {
        Film film = filmMapper.mapFilmFromFrontendDtoToFilm(filmFromFrontendDto);
        System.out.println("DANE FILMU: " + film.toString());
        return filmMapper.mapFilmToFilmFromFrontendDto(filmDbService.saveFilm(film, filmsCollectionId));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        filmDbService.deleteFilm(id);
    }

}
