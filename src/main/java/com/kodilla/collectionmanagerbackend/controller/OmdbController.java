package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.FilmDto;
import com.kodilla.collectionmanagerbackend.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/omdb")
public class OmdbController {

    @Autowired
    private OmdbService omdbService;

/*    @Autowired
    private FilmMapper filmMapper;*/

    @GetMapping("/{filmTitle}")
    public FilmDto getFilm(@PathVariable String filmTitle) {
        return omdbService.getFilm(filmTitle);
    }
}
