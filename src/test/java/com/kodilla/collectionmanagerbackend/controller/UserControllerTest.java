package com.kodilla.collectionmanagerbackend.controller;

import com.google.gson.Gson;
import com.kodilla.collectionmanagerbackend.domain.UserDto;
import com.kodilla.collectionmanagerbackend.mapper.UserMapper;
import com.kodilla.collectionmanagerbackend.service.UserDbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserDbService userDbService;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void shouldGetUserById() throws Exception {
        //Given
        UserDto userDto = new UserDto("Jan", "Kal", LocalDate.of(1973,1,20).toString(), "email", "login", "password");

        when(userMapper.mapToUserDto(userDbService.findById(1L))).thenReturn(userDto);
        //When & Then

        mockMvc.perform(get("/v1/user/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Jan")))
                .andExpect(jsonPath("$.lastName", is("Kal")))
                //.andExpect(jsonPath("$.date", is(1973-1-20)))
                .andExpect(jsonPath("$.email", is("email")))
                .andExpect(jsonPath("$.login", is("login")))
                .andExpect(jsonPath("$.password", is("password")));
    }

    @Test
    public void shouldCreateUser() throws Exception {
        //Given
        UserDto userDto = new UserDto("Jan", "Kal", LocalDate.of(1973,1,20).toString(), "email", "login", "password");
        UserDto userDtoCreated = new UserDto("Jan", "Kal", LocalDate.of(1973,1,20).toString(), "email", "login", "password");

        when(userMapper.mapToUserDto(userDbService.saveUser(userMapper.mapToUser(ArgumentMatchers.any(UserDto.class))))).thenReturn(userDtoCreated);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        //When & Then
        mockMvc.perform(post("/v1/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Jan")))
                .andExpect(jsonPath("$.lastName", is("Kal")))
                .andExpect(jsonPath("$.birthday", is("1973-01-20")))
                .andExpect(jsonPath("$.email", is("email")))
                .andExpect(jsonPath("$.login", is("login")))
                .andExpect(jsonPath("$.password", is("password")));
    }

}