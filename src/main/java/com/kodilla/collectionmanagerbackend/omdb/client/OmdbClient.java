package com.kodilla.collectionmanagerbackend.omdb.client;

import com.kodilla.collectionmanagerbackend.domain.Film;
import com.kodilla.collectionmanagerbackend.domain.FilmDto;
import com.kodilla.collectionmanagerbackend.omdb.config.OmdbConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class OmdbClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OmdbConfig omdbConfig;

    public FilmDto getFilm (String filmTitle) {
        return restTemplate.getForObject(getUrl(filmTitle), FilmDto.class);
    }

    private URI getUrl(String filmTitle) {
        return UriComponentsBuilder.fromHttpUrl(omdbConfig.getOmdbApiEndpoint())
                .queryParam("apikey", "14ef4a96")
                .queryParam("t", filmTitle)
                .build().encode().toUri();
    }
}
