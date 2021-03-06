package com.kodilla.collectionmanagerbackend.controller;

import com.google.gson.Gson;
import com.kodilla.collectionmanagerbackend.domain.*;
import com.kodilla.collectionmanagerbackend.isbndb.client.IsbndbClient;
import com.kodilla.collectionmanagerbackend.isbndb.facade.IsbndbFacade;
import com.kodilla.collectionmanagerbackend.mapper.BookMapper;
import com.kodilla.collectionmanagerbackend.service.IsbndbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IsbndbController.class)
public class IsbndbControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IsbndbFacade isbndbFacade;

    @Test
    public void shouldFetchEmptyBookDto() throws Exception {
        //Given
        when(isbndbFacade.getJsonBookDto("1234")).thenReturn(new BookToFrontendFromIsbndbDto());
        //When & Then
        mockMvc.perform(get("/v1/isbndb/1234").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.isbn", is(nullValue())))
                .andExpect(jsonPath("$.isbn13", is(nullValue())))
                .andExpect(jsonPath("$.title", is(nullValue())))
                .andExpect(jsonPath("$.publisher", is(nullValue())))
                .andExpect(jsonPath("$.synopsys", is(nullValue())))
                .andExpect(jsonPath("$.image", is(nullValue())))
                .andExpect(jsonPath("$.authors", is(nullValue())))
                .andExpect(jsonPath("$.subjects", is(nullValue())))
                .andExpect(jsonPath("$.publishDate", is(nullValue())));
    }

    @Test
    public void shouldFetchBook() throws Exception {
        //Given
        Author author = new Author("A1");
        Subject subject = new Subject("Polska");

        List<Author> listAuthors = new ArrayList<>();
        List<Subject> listSubjects = new ArrayList<>();

        listAuthors.add(author);
        listSubjects.add(subject);

        BookToFrontendFromIsbndbDto bookToFrontendFromIsbndbDto = new BookToFrontendFromIsbndbDto("1234", "12345",
                "Title1", "Publisher1",
                "Synopsys1", "url to image",
                "A1", "Polska",
                2021);

        when(isbndbFacade.getJsonBookDto("1234")).thenReturn(bookToFrontendFromIsbndbDto);

        //When & Then
        mockMvc.perform(get("/v1/isbndb/{isbn}", "1234").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.isbn", is("1234")))
                .andExpect(jsonPath("$.isbn13", is("12345")))
                .andExpect(jsonPath("$.title", is("Title1")))
                .andExpect(jsonPath("$.publisher", is("Publisher1")))
                .andExpect(jsonPath("$.synopsys", is("Synopsys1")))
                .andExpect(jsonPath("$.image", is("url to image")))
                .andExpect(jsonPath("$.authors", is("A1")))
                .andExpect(jsonPath("$.subjects", is("Polska")))
                .andExpect(jsonPath("$.publishDate", is(2021)));
    }
}