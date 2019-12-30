package com.kodilla.collectionmanagerbackend.service;

import com.kodilla.collectionmanagerbackend.isbndb.client.IsbndbClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IsbndbService {

    @Autowired
    private IsbndbClient isbndbClient;


}
