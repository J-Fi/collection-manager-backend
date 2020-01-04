package com.kodilla.collectionmanagerbackend.controller;

import com.google.gson.Gson;
import com.kodilla.collectionmanagerbackend.domain.*;
import com.kodilla.collectionmanagerbackend.mapper.BookMapper;
import com.kodilla.collectionmanagerbackend.service.BookDbService;
import com.kodilla.collectionmanagerbackend.service.BooksCollectionDbService;
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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @MockBean
    public BookDbService bookDbService;

    @MockBean
    public BooksCollectionDbService booksCollectionDbService;

    @MockBean
    public BookMapper bookMapper;

    @Test
    public void shouldGetBookById() throws Exception {
        //Given
        Author author = new Author("A1");
        Subject subject = new Subject("Polska");

        List<Author> listAuthors = new ArrayList<>();
        List<Subject> listSubjects = new ArrayList<>();

        listAuthors.add(author);
        listSubjects.add(subject);

        BookToFrontendDto bookToFrontendDto = new BookToFrontendDto("1234", "12345",
                "Title1", "Publisher1",
                "Synopsys1", "url to image",
                "A1", "S1",
                2021);

        when(bookMapper.mapToBookToFrontendDto(bookDbService.findById(1L))).thenReturn(bookToFrontendDto);

        //When & Then
        mockMvc.perform(get("/v1/book/{id}", 1L).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isbn", is("1234")))
                .andExpect(jsonPath("$.isbn13", is("12345")))
                .andExpect(jsonPath("$.title", is("Title1")))
                .andExpect(jsonPath("$.publisher", is("Publisher1")))
                .andExpect(jsonPath("$.synopsys", is("Synopsys1")))
                .andExpect(jsonPath("$.image", is("url to image")))
                .andExpect(jsonPath("$.authors", hasSize(1)))
                .andExpect(jsonPath("$.subjects", hasSize(1)))
                .andExpect(jsonPath("$.date_published", is(2021)));
    }

    @Test
    public void shouldGetBooksCollection() throws Exception {

    }

    @Test
    public void shouldCreateBook() throws Exception {
        //Given
        Author author = new Author("A1");
        Subject subject = new Subject("Polska");

        List<Author> listAuthors = new ArrayList<>();
        List<Subject> listSubjects = new ArrayList<>();

        listAuthors.add(author);
        listSubjects.add(subject);


        BookToFrontendDto bookToFrontendDto = new BookToFrontendDto("1234", "12345",
                "Title1", "Publisher1",
                "Synopsys1", "url to image",
                "A1", "S1",
                2021);

        Book book = new Book("1234", "12345",
                "Title1", "Publisher1",
                "Synopsys1", "url to image",
                "A1", "S1",
                2021);

        when(bookMapper.mapToBookToFrontendDto(bookDbService.saveBook(book, 1L))).thenReturn(bookToFrontendDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookToFrontendDto);

        //When & Then
        mockMvc.perform(post("/v1/book/{booksCollectionId}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isbn", is("1234")))
                .andExpect(jsonPath("$.isbn13", is("12345")))
                .andExpect(jsonPath("$.title", is("Title1")))
                .andExpect(jsonPath("$.publisher", is("Publisher1")))
                .andExpect(jsonPath("$.synopsys", is("Synopsys1")))
                .andExpect(jsonPath("$.image", is("url to image")))
                .andExpect(jsonPath("$.authors", hasSize(1)))
                .andExpect(jsonPath("$.subjects", hasSize(1)))
                .andExpect(jsonPath("$.date_published", is(2021)));
    }

    @Test
    public void shouldDeleteBook() throws Exception {
        //Given
        //When & Then
        mockMvc.perform(delete("/v1/book/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}