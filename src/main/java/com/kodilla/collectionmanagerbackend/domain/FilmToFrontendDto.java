package com.kodilla.collectionmanagerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FilmToFrontendDto {
    private Long filmId;
    private String filmTitle;
    private String year;
    private String runtime;
    private String directorName;
    private String writers;
    private String actors;
    private String plot;
    private String language;
    private String country;
    private String posterLink;
    private String production;
    private Long filmsCollectionId;

    public FilmToFrontendDto(String filmTitle, String year, String runtime, String directorName, String writers, String actors, String plot, String language, String country, String posterLink, String production) {
        this.filmTitle = filmTitle;
        this.year = year;
        this.runtime = runtime;
        this.directorName = directorName;
        this.writers = writers;
        this.actors = actors;
        this.plot = plot;
        this.language = language;
        this.country = country;
        this.posterLink = posterLink;
        this.production = production;
    }
}
