/*
package com.kodilla.collectionmanagerbackend.controller;

import com.google.gson.Gson;
import com.kodilla.collectionmanagerbackend.domain.BooksCollection;
import com.kodilla.collectionmanagerbackend.domain.BooksCollectionDto;
import com.kodilla.collectionmanagerbackend.mapper.BooksCollectionMapper;
import com.kodilla.collectionmanagerbackend.service.BooksCollectionDbService;
import com.kodilla.collectionmanagerbackend.service.UserDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BooksCollectionController.class)
public class BooksCollectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BooksCollectionMapper booksCollectionMapper;

    @MockBean
    private BooksCollectionDbService booksCollectionDbService;

    @MockBean
    private UserDbService userDbService;

    @Test
    public void shouldCreateBooksCollection() throws Exception {
        //Given
        BooksCollectionDto booksCollectionDto = new BooksCollectionDto("My Collection");

        Gson gson = new Gson();
        String jsonContent = gson.toJson(booksCollectionDto);
        //When & Then
        mockMvc.perform(post("/v1/books-collection/1").contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andDo(print())
                .andExpect(status().isOk());
    }
}*/
