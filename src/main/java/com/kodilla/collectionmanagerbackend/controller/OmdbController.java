package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.domain.BookToFrontendDto;
import com.kodilla.collectionmanagerbackend.domain.FilmDto;
import com.kodilla.collectionmanagerbackend.domain.FilmToFrontendDto;
import com.kodilla.collectionmanagerbackend.mapper.FilmMapper;
import com.kodilla.collectionmanagerbackend.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;

import java.util.Optional;

@RestController
@RequestMapping("/v1/omdb")
public class OmdbController {

    @Autowired
    private OmdbService omdbService;

    @Autowired
    private FilmMapper filmMapper;

    @GetMapping("/{filmTitle}")
    public FilmToFrontendDto getFilmToFrontendDto (@PathVariable String filmTitle) {
        try {
            //BookDto bookResponse = ;
            return filmMapper.mapToFilmToFrontendDto2(Optional.ofNullable(omdbService.getFilm(filmTitle)).orElse(new FilmDto()));
        } catch (RestClientException e) {
            return new FilmToFrontendDto();
        }
    }
}
