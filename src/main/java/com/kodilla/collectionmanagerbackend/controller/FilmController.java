package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.Film;
import com.kodilla.collectionmanagerbackend.domain.FilmFromFrontendDto;
import com.kodilla.collectionmanagerbackend.domain.FilmToFrontendDto;
import com.kodilla.collectionmanagerbackend.mapper.FilmMapper;
import com.kodilla.collectionmanagerbackend.service.FilmDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/film")
public class FilmController {

    @Autowired
    private FilmDbService filmDbService;

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
        return filmMapper.mapFilmToFilmFromFrontendDto(filmDbService.saveFilm(film, filmsCollectionId));
    }

    @PutMapping("/{filmsCollectionId}/{filmId}")
    public FilmFromFrontendDto updateFilm(@PathVariable Long filmsCollectionId, @PathVariable Long filmId, @RequestBody FilmFromFrontendDto filmFromFrontendDto) {
        return filmMapper.mapFilmToFilmFromFrontendDto(filmDbService.updateFilm(filmsCollectionId, filmId, filmMapper.mapFilmFromFrontendDtoToFilm(filmFromFrontendDto)));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        filmDbService.deleteFilm(id);
    }

}
