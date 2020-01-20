/*
package com.kodilla.collectionmanagerbackend.controller;

import com.google.gson.Gson;
import com.kodilla.collectionmanagerbackend.domain.User;
import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBook;
import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBookDto;
import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBookJsonDto;
import com.kodilla.collectionmanagerbackend.mapper.UserCommentOnBookJsonDtoMapper;
import com.kodilla.collectionmanagerbackend.mapper.UserCommentOnBookMapper;
import com.kodilla.collectionmanagerbackend.service.BookDbService;
import com.kodilla.collectionmanagerbackend.service.CommentOnBookDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserCommentOnBookController.class)
public class UserCommentOnBookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentOnBookDbService commentOnBookDbService;

    @MockBean
    private UserCommentOnBookJsonDtoMapper userCommentOnBookJsonDtoMapper;

    @MockBean
    private UserCommentOnBookMapper userCommentOnBookMapper;

    @MockBean
    private BookDbService bookDbService;

    @Test
    public void shouldGetAllUserCommentsOnBook() throws Exception{
        //Given
        UserCommentOnBookJsonDto userCommentOnBookJsonDto = new UserCommentOnBookJsonDto(LocalDate.of(2020,1,20),"Content");
        List<UserCommentOnBookJsonDto> list = new ArrayList<>();
        list.add(userCommentOnBookJsonDto);

        when(userCommentOnBookJsonDtoMapper.mapCommentDtoToJson(commentOnBookDbService.getAllUserCommentsOnBook(1L))).thenReturn(list);

        //When & Then
        mockMvc.perform(get("/v1/comment/{bookId}", 1L)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

    @Test
    public void shouldSaveComment() throws Exception {
        //Given
        UserCommentOnBookDto userCommentOnBookDtoTo = new UserCommentOnBookDto("Comment"
                , LocalDate.of(2020,1,20));

        UserCommentOnBookDto userCommentOnBookDtoFrom = new UserCommentOnBookDto("Comment"
                , LocalDate.of(2020,1,20), 1L);

        UserCommentOnBook userCommentOnBook = new UserCommentOnBook(LocalDate.of(2020,1,20),
                "Comment");

        when(userCommentOnBookMapper.mapToUserCommentOnBookDto(commentOnBookDbService.saveComment(userCommentOnBook)))
                .thenReturn(userCommentOnBookDtoFrom);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userCommentOnBookDtoTo);

        //When & Then
        mockMvc.perform(post("/v1/comment/1")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comment", is("Comment")))
                .andExpect(jsonPath("$.date", is(LocalDate.of(2020,1,20))))
                .andExpect(jsonPath("$.bookId", is(1L)));

    }

}*/
