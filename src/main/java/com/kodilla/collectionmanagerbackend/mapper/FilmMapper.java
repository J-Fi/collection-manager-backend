package com.kodilla.collectionmanagerbackend.mapper;

import com.kodilla.collectionmanagerbackend.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class FilmMapper {

    public FilmToFrontendDto mapToFilmToFrontendDto(Film film) {
        return new FilmToFrontendDto(film.getFilmId(), film.getFilmTitle(),
                film.getYear(), film.getRuntime(),
                film.getDirectorName(), film.getWriters(),
                film.getActors(), film.getPlot(), film.getLanguage(),
                film.getCountry(), film.getPosterLink(),
                film.getProduction(), film.getFilmsCollection().getFilmsCollectionId());
    }

    public List<FilmToFrontendDto> mapToFilmToFrontendDtoList(List<Film> filmList) {
        return filmList.stream().
                map(film -> new FilmToFrontendDto(film.getFilmId(), film.getFilmTitle(),
                        film.getYear(), film.getRuntime(),
                        film.getDirectorName(), film.getWriters(),
                        film.getActors(), film.getPlot(), film.getLanguage(),
                        film.getCountry(), film.getPosterLink(),
                        film.getProduction(), film.getFilmsCollection().getFilmsCollectionId())).
                collect(Collectors.toList());
    }

    public Film mapFilmFromFrontendDtoToFilm(FilmFromFrontendDto filmFromFrontendDto) {
        return new Film(filmFromFrontendDto.getFilmTitle(), filmFromFrontendDto.getYear(),
                filmFromFrontendDto.getRuntime(), filmFromFrontendDto.getDirectorName(),
                filmFromFrontendDto.getWriters(), filmFromFrontendDto.getActors(),
                filmFromFrontendDto.getPlot(), filmFromFrontendDto.getLanguage(),
                filmFromFrontendDto.getCountry(), filmFromFrontendDto.getPosterLink(),
                filmFromFrontendDto.getProduction());
    }

    public FilmFromFrontendDto mapFilmToFilmFromFrontendDto(Film film) {
        return new FilmFromFrontendDto(film.getFilmTitle(), film.getYear(),
                film.getRuntime(), film.getDirectorName(), film.getWriters(),
                film.getActors(), film.getPlot(), film.getLanguage(),
                film.getCountry(), film.getPosterLink(), film.getProduction());
    }

    public FilmToFrontendDto mapToFilmToFrontendDto2(FilmDto filmDto) {
        return new FilmToFrontendDto(
                filmDto.getFilmTitle(), filmDto.getYear(),
                filmDto.getRuntime(), filmDto.getDirectorName(),
                filmDto.getWriters(), filmDto.getActors(),
                filmDto.getPlot(), filmDto.getLanguage(),
                filmDto.getCountry(), filmDto.getPosterLink(),
                filmDto.getProduction());
    }
}
