package com.kodilla.collectionmanagerbackend.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmFromFrontendDto {
    @JsonProperty("filmTitle")
    private String filmTitle;

    @JsonProperty("year")
    private String year;

    @JsonProperty("runtime")
    private String runtime;

    @JsonProperty("directorName")
    private String directorName;

    @JsonProperty("writers")
    private String writers;

    @JsonProperty("actors")
    private String actors;

    @JsonProperty("plot")
    private String plot;

    @JsonProperty("language")
    private String language;

    @JsonProperty("country")
    private String country;

    @JsonProperty("posterLink")
    private String posterLink;

    @JsonProperty("production")
    private String production;
}
