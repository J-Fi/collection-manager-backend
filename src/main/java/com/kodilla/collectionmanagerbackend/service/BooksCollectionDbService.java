package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.domain.Book;
import com.kodilla.collectionmanagerbackend.domain.BooksCollection;
import com.kodilla.collectionmanagerbackend.repository.BooksCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BooksCollectionDbService {
    @Autowired
    private BooksCollectionRepository booksCollectionRepo;

    public BooksCollection saveBooksCollection (BooksCollection booksCOllection) {
        return booksCollectionRepo.save(booksCOllection);
    }

    public void deleteBooksCollection(final Long id) {
        booksCollectionRepo.deleteById(id);
    }

    public BooksCollection findById(final Long id) {
        return booksCollectionRepo.findById(id).orElse(new BooksCollection());
    }
}
