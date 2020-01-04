package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDbServiceTest {

    @Autowired
    private BookDbService bookDbService;

    @MockBean
    private BookRepository bookRepo;

    @Test
    public void shouldFetchBooksByBooksCollectionId() {
        //Given
        List<Book> list = new ArrayList<>();
        list.add(new Book("isbn1", "isbn131", "title1", "publisher1", "synopsys1", "image1", "authors1", "subjects1", 2012, 2L));
        list.add(new Book("isbn2", "isbn132", "title2", "publisher2", "synopsys2", "image2", "authors2", "subjects2", 2011, 3L));
        list.add(new Book("isbn3", "isbn133", "title3", "publisher3", "synopsys3", "image3", "authors3", "subjects3", 2003, 3L));

        when(bookRepo.findAll()).thenReturn(list);
        //When
        List<Book> listReturned = bookDbService.fetchBooksByBooksCollectionId(3L);
        System.out.println(listReturned.get(0));
        System.out.println(listReturned.get(1));
        //Then
        assertEquals(2, listReturned.size());
        assertEquals("isbn2", listReturned.get(0).getIsbn());
        assertEquals("isbn3", listReturned.get(1).getIsbn());

    }

}