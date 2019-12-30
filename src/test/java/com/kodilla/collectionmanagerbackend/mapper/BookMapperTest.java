package com.kodilla.collectionmanagerbackend.mapper;

import com.kodilla.collectionmanagerbackend.domain.Author;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookMapperTest {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testMapAuthorsListToStringTwoItems() {
        //Given
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("A1"));
        authors.add(new Author("A2"));

        //When
        String s = bookMapper.mapAuthorsListToString(authors);
        System.out.println(s);

        //Then
        assertEquals("A1; A2", s);
    }

    @Test
    public void testMapAuthorsListToStringOneItem() {
        //Given
        List<Author> authors = new ArrayList<>();
        authors.add(new Author("A1"));

        //When
        String s = bookMapper.mapAuthorsListToString(authors);
        //System.out.println(s);

        //Then
        assertEquals("A1", s);
    }

    @Test
    public void testMapStringToAuthorsList() {
        //Given
        String authors = "A1; A2";

        //When
        List<Author> authorsAsList = bookMapper.mapStringToAuthorsList(authors);
        System.out.println(authorsAsList.toString());

        //Then
        assertEquals(2, authorsAsList.size());
    }

}