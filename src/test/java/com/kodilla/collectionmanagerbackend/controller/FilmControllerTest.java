package com.kodilla.collectionmanagerbackend.controller;

import com.google.gson.Gson;
import com.kodilla.collectionmanagerbackend.domain.*;
import com.kodilla.collectionmanagerbackend.mapper.FilmMapper;
import com.kodilla.collectionmanagerbackend.service.FilmDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FilmController.class)
public class FilmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FilmDbService filmDbService;

    @MockBean
    private FilmMapper filmMapper;

    @Test
    public void shouldGetFilmById() throws Exception {
        //Given
        FilmToFrontendDto filmToFrontendDto = new FilmToFrontendDto(1L, "Title1", "2020", "60 min",
                "Director1", "Writer1",
                "Actor1", "plot",
                "PL", "Poland",
                "poster link","Dreamworks", 2L);

        when(filmMapper.mapToFilmToFrontendDto(filmDbService.findById(1L))).thenReturn(filmToFrontendDto);

        //When & Then
        mockMvc.perform(get("/v1/film/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.filmId", is(1)))
                .andExpect(jsonPath("$.filmTitle", is("Title1")))
                .andExpect(jsonPath("$.year", is("2020")))
                .andExpect(jsonPath("$.runtime", is("60 min")))
                .andExpect(jsonPath("$.directorName", is("Director1")))
                .andExpect(jsonPath("$.writers", is("Writer1")))
                .andExpect(jsonPath("$.actors", is("Actor1")))
                .andExpect(jsonPath("$.plot", is("plot")))
                .andExpect(jsonPath("$.language", is("PL")))
                .andExpect(jsonPath("$.country", is("Poland")))
                .andExpect(jsonPath("$.posterLink", is("poster link")))
                .andExpect(jsonPath("$.production", is("Dreamworks")))
                .andExpect(jsonPath("$.filmsCollectionId", is(2)));
    }

    @Test
    public void shouldGetFilmsCollection() throws Exception {
        //Given
        List<FilmToFrontendDto> filmsCollection = new ArrayList<>();
        FilmToFrontendDto filmToFrontendDto = new FilmToFrontendDto(1L, "Title1", "2020", "60 min",
                "Director1", "Writer1",
                "Actor1", "plot",
                "PL", "Poland",
                "poster link","Dreamworks", 2L);
        filmsCollection.add(filmToFrontendDto);

        when(filmMapper.mapToFilmToFrontendDtoList(filmDbService.fetchFilmsByFilmsCollectionId(1L))).thenReturn(filmsCollection);

        //When & Then
        mockMvc.perform(get("/v1/film/list/{filmsCollectionId}", 1L).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void shouldCreateFilm() throws Exception {
        //Given
        FilmFromFrontendDto filmFromFrontendDto = new FilmFromFrontendDto("Title1", "2020", "60 min",
                "Director1", "Writer1",
                "Actor1", "plot",
                "PL", "Poland",
                "poster link","Dreamworks");

        Film film = new Film("Title1", "2020", "60 min",
                "Director1", "Writer1",
                "Actor1", "plot",
                "PL", "Poland",
                "poster link","Dreamworks");

        when(filmMapper.mapFilmToFilmFromFrontendDto(filmDbService.saveFilm(film, 1L))).thenReturn(filmFromFrontendDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(filmFromFrontendDto);

        //When & Then
        mockMvc.perform(post("/v1/film/{filmsCollectionId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                //.andExpect(jsonPath("$.filmId", is(1)))
                .andExpect(jsonPath("$.filmTitle", is("Title1")))
                .andExpect(jsonPath("$.year", is("2020")))
                .andExpect(jsonPath("$.runtime", is("60 min")))
                .andExpect(jsonPath("$.directorName", is("Director1")))
                .andExpect(jsonPath("$.writers", is("Writer1")))
                .andExpect(jsonPath("$.actors", is("Actor1")))
                .andExpect(jsonPath("$.plot", is("plot")))
                .andExpect(jsonPath("$.language", is("PL")))
                .andExpect(jsonPath("$.country", is("Poland")))
                .andExpect(jsonPath("$.posterLink", is("poster link")))
                .andExpect(jsonPath("$.production", is("Dreamworks")));
                //.andExpect(jsonPath("$.filmsCollectionId", is(2)));
    }

    @Test
    public void shouldUpdateBook() throws Exception {
        //Given
        FilmFromFrontendDto filmFromFrontendDto = new FilmFromFrontendDto("Title1", "2020", "60 min",
                "Director1", "Writer1",
                "Actor1", "plot",
                "PL", "Poland",
                "poster link","Dreamworks");

        FilmFromFrontendDto filmFromFrontendDtoUpdated = new FilmFromFrontendDto("Title1", "2020", "60 min",
                "Director2", "Writer2",
                "Actor1", "plot",
                "PL", "Poland",
                "poster link","Dreamworks");

        when(filmMapper.mapFilmToFilmFromFrontendDto(filmDbService
                .updateFilm(1L, 1L, filmMapper.mapFilmFromFrontendDtoToFilm(filmFromFrontendDto))))
                .thenReturn(filmFromFrontendDtoUpdated);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(filmFromFrontendDtoUpdated);

        //When & Then
        mockMvc.perform(put("/v1/film/{filmsCollectionId}/{filmId}", 1L, 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.filmTitle", is("Title1")))
                .andExpect(jsonPath("$.year", is("2020")))
                .andExpect(jsonPath("$.runtime", is("60 min")))
                .andExpect(jsonPath("$.directorName", is("Director2")))
                .andExpect(jsonPath("$.writers", is("Writer2")))
                .andExpect(jsonPath("$.actors", is("Actor1")))
                .andExpect(jsonPath("$.plot", is("plot")))
                .andExpect(jsonPath("$.language", is("PL")))
                .andExpect(jsonPath("$.country", is("Poland")))
                .andExpect(jsonPath("$.posterLink", is("poster link")))
                .andExpect(jsonPath("$.production", is("Dreamworks")));

    }

    @Test
    public void shouldDeleteBook() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(delete("/v1/film/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}