package com.kodilla.collectionmanagerbackend.controller;

import com.kodilla.collectionmanagerbackend.domain.FilmsCollection;
import com.kodilla.collectionmanagerbackend.domain.FilmsCollectionDto;
import com.kodilla.collectionmanagerbackend.mapper.FilmsCollectionMapper;
import com.kodilla.collectionmanagerbackend.service.FilmsCollectionDbService;
import com.kodilla.collectionmanagerbackend.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/films-collection")
public class FilmsCollectionController {

    @Autowired
    private FilmsCollectionDbService filmsCollectionDbService;

    @Autowired
    private FilmsCollectionMapper filmsCollectionMapper;

    @Autowired
    private UserDbService userDbService;

    @PostMapping("/{userId}")
    public void createFilmsCollection(@PathVariable Long userId, @RequestBody FilmsCollectionDto filmsCollectionDto) {
        FilmsCollection filmsCollection = filmsCollectionMapper.mapToFilmsCollection(filmsCollectionDto);
        filmsCollection.setUser(userDbService.findById(userId));
        filmsCollectionDbService.saveFilmsCollection(filmsCollection);
    }
}
