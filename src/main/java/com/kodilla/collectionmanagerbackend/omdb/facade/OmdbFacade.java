package com.kodilla.collectionmanagerbackend.omdb.facade;

import com.kodilla.collectionmanagerbackend.domain.FilmToFrontendDto;
import com.kodilla.collectionmanagerbackend.mapper.FilmMapper;
import com.kodilla.collectionmanagerbackend.service.OmdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OmdbFacade {

    @Autowired
    private OmdbService omdbService;

    @Autowired
    private FilmMapper filmMapper;

    public FilmToFrontendDto getFilmToFrontendDto(String filmTitle) {
        return filmMapper.mapToFilmToFrontendDto2(omdbService.getFilm(filmTitle));
    }
}
