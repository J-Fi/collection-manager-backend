package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.FilmToFrontendDto;
import com.kodilla.collectionmanagerbackend.omdb.facade.OmdbFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(OmdbController.class)
public class OmdbControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OmdbFacade omdbFacade;

    @Test
    public void shouldFetchEmptyFilm() throws Exception {
        //Given
        when(omdbFacade.getFilmToFrontendDto("Up")).thenReturn(new FilmToFrontendDto());

        //When & Then
        mockMvc.perform(get("/v1/omdb/{filmTitle}", "Up").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //.andExpect(jsonPath("$", is(nullValue())));
                .andExpect(jsonPath("$.filmTitle", is(nullValue())))
                .andExpect(jsonPath("$.year", is(nullValue())))
                .andExpect(jsonPath("$.runtime", is(nullValue())))
                .andExpect(jsonPath("$.directorName", is(nullValue())))
                .andExpect(jsonPath("$.writers", is(nullValue())))
                .andExpect(jsonPath("$.actors", is(nullValue())))
                .andExpect(jsonPath("$.plot", is(nullValue())))
                .andExpect(jsonPath("$.language", is(nullValue())))
                .andExpect(jsonPath("$.country", is(nullValue())))
                .andExpect(jsonPath("$.posterLink", is(nullValue())))
                .andExpect(jsonPath("$.production", is(nullValue())));
    }

    @Test
    public void shouldFetchFilm() throws Exception {
        //Given
        FilmToFrontendDto filmToFrontendDto = new FilmToFrontendDto("Up", "2020", "120 min", "Director1",
                "Writers", "Actors1", "Plot1", "PL", "Country1", "PosterLink",
                "Dreamworks");

        when(omdbFacade.getFilmToFrontendDto("Up")).thenReturn(filmToFrontendDto);

        //When & Then
        mockMvc.perform(get("/v1/omdb/{title}", "Up").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.filmTitle", is("Up")))
                .andExpect(jsonPath("$.year", is("2020")))
                .andExpect(jsonPath("$.runtime", is("120 min")))
                .andExpect(jsonPath("$.directorName", is("Director1")))
                .andExpect(jsonPath("$.writers", is("Writers")))
                .andExpect(jsonPath("$.actors", is("Actors1")))
                .andExpect(jsonPath("$.plot", is("Plot1")))
                .andExpect(jsonPath("$.language", is("PL")))
                .andExpect(jsonPath("$.country", is("Country1")))
                .andExpect(jsonPath("$.posterLink", is("PosterLink")))
                .andExpect(jsonPath("$.production", is("Dreamworks")));
    }
}