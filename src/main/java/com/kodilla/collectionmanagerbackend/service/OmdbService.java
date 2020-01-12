package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.FilmDto;
import com.kodilla.collectionmanagerbackend.omdb.client.OmdbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OmdbService {

    @Autowired
    private OmdbClient omdbClient;

    public FilmDto getFilm(String filmTitle) {
        return omdbClient.getFilm(filmTitle);
    }

}
