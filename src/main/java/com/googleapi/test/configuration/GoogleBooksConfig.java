package com.googleapi.test.configuration;

import com.fasterxml.jackson.core.JsonFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class GoogleBooksConfig {
    @Value("${google.books.api.key}")
    private String apiKey;

    @Bean
    public Books googleBooksApiClient () throws IOException{
        return new Books.Builder(
                new NetHttpTransport(),new JacksonFactory(),null)
                .setGoogleClientRequestInitializer(new BooksRequestInitializer(apiKey))
                .build();
    }
}
