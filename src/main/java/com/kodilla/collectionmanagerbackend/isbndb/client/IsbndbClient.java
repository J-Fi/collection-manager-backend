package com.kodilla.collectionmanagerbackend.isbndb.client;

import com.kodilla.collectionmanagerbackend.domain.JsonBookDto;
import com.kodilla.collectionmanagerbackend.isbndb.config.IsbndbConfig;
//import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class IsbndbClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private IsbndbConfig isbndbConfig;

    public ResponseEntity<JsonBookDto> getJsonBookDto(String isbn) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Host", "api2.isbndb.com");
        headers.add("User-Agent","insomnia/5.12.4");
        headers.add("Authorization", "43705_7acf1129c6d7b89b9e4c467fc3d74355");
        headers.add("Accept", "*/*");
        HttpEntity request = new HttpEntity<>(headers);
        return restTemplate.exchange(isbndbConfig.getIsbndbApiEndpoint() + "/" + isbn, HttpMethod.GET, request, JsonBookDto.class);
    }
//
/*    private URI getUrl(String isbn) {
        return UriComponentsBuilder.fromHttpUrl(isbndbConfig.getIsbndbApiEndpoint())
                .queryParam("q", isbn)
                .queryParam("fields", "items/volumeInfo/title,items/volumeInfo/subtitle,items/volumeInfo/authors").build().encode().toUri();
                //.queryParam("format", "json").build().encode().toUri();
    }*/


}
