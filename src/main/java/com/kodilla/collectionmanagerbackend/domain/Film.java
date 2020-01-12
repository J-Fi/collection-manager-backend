package com.kodilla.collectionmanagerbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FILMS")
public class Film {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "film_id", unique = true)
    private Long filmId;

    @Column(name = "Title")
    private String filmTitle;

    @Column(name = "Year")
    private String year;

    @Column(name = "Runtime")
    private String runtime;

    @Column(name = "Director")
    private String directorName;

    @Column(name = "Writer", length = 65535, columnDefinition = "text")
    private String writers;

    @Column(name = "Actors", length = 65535, columnDefinition = "text")
    private String actors;

    @Column(name = "Plot", length = 65535, columnDefinition = "text")
    private String plot;

    @Column(name = "Language")
    private String language;

    @Column(name = "Country")
    private String country;

    @Column(name = "Poster")
    private String posterLink;

    @Column(name = "Production")
    private String production;

    @ManyToOne
    @JoinColumn(name = "films_collection_id")
    private FilmsCollection filmsCollection;
}
