package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.FilmToFrontendDto;
import com.kodilla.collectionmanagerbackend.omdb.facade.OmdbFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/omdb")
public class OmdbController {

    private OmdbFacade omdbFacade;

    @Autowired
    public OmdbController (OmdbFacade omdbFacade) {
        this.omdbFacade = omdbFacade;
    }

    @GetMapping("/{filmTitle}")
    public FilmToFrontendDto getFilmToFrontendDto (@PathVariable String filmTitle) {
        return omdbFacade.getFilmToFrontendDto(filmTitle);
    }
}
