package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.Author;
import com.kodilla.collectionmanagerbackend.domain.BookDto;
import com.kodilla.collectionmanagerbackend.domain.Subject;
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
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.when;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IsbndbController.class)
public class IsbndbControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IsbndbService isbndbService;

    @Test
    public void shouldFetchEmptyBookDto() throws Exception {
        //Given
        BookDto bookDto = new BookDto();
        when(isbndbService.getJsonBookDto("1234")).thenReturn(bookDto);
        //When & Then
        mockMvc.perform(get("/v1/isbndb/1234").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.isbn", is(null)))
                .andExpect(jsonPath("$.isbn13", is(null)))
                .andExpect(jsonPath("$.title", is(null)))
                .andExpect(jsonPath("$.publisher", is(null)))
                .andExpect(jsonPath("$.synopsys", is(null)))
                .andExpect(jsonPath("$.image", is(null)))
                .andExpect(jsonPath("$.authors", is(null)))
                .andExpect(jsonPath("$.subjects", is(null)))
                .andExpect(jsonPath("$.date_published", is(null)));;
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

        BookDto bookDto = new BookDto("1234", "12345",
                "Title1", "Publisher1",
                "Synopsys1", "url to image",
                listAuthors, listSubjects,
                2021);

        when(isbndbService.getJsonBookDto("1234")).thenReturn(bookDto);
        //When & Then
        mockMvc.perform(get("/v1/isbndb/1234").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.isbn", is("1234")))
                .andExpect(jsonPath("$.isbn13", is("12345")))
                .andExpect(jsonPath("$.title", is("Title1")))
                .andExpect(jsonPath("$.publisher", is("Publisher1")))
                .andExpect(jsonPath("$.synopsys", is("Synopsys1")))
                .andExpect(jsonPath("$.image", is("url to image")))
                .andExpect(jsonPath("$.authors[0].author", is("A1")))
                .andExpect(jsonPath("$.subjects[0].subject", is("Polska")))
                .andExpect(jsonPath("$.date_published", is(2021)));
    }

}