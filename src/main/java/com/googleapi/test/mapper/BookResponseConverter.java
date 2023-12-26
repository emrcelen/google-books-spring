package com.googleapi.test.mapper;

import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.googleapi.test.model.Book;
import com.googleapi.test.model.BookImage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class BookResponseConverter {
    public final Book convertToResponse(Volume book) {
        Book responseBook = new Book.Builder()
                .id(book.getId())
                .title(book.getVolumeInfo() != null ? book.getVolumeInfo().getTitle() : null)
                .authors(book.getVolumeInfo() != null ? book.getVolumeInfo().getAuthors() : null)
                .publisher(book.getVolumeInfo() != null ? book.getVolumeInfo().getPublisher() : null)
                .publishedDate(book.getVolumeInfo() != null ? book.getVolumeInfo().getPublishedDate() : null)
                .pageCount(book.getVolumeInfo().getPageCount() != null ? book.getVolumeInfo().getPageCount() : 0)
                .bookImage(book.getVolumeInfo().getImageLinks() != null ? convertBookImage(book.getVolumeInfo().getImageLinks()) : null)
                .pdfLink(book.getAccessInfo().getPdf() != null ? book.getAccessInfo().getPdf().getAcsTokenLink(): null)
                .build();
        return responseBook;
    }
    public final List<Book> convertToResponse(Volumes books) {
        return books.getItems().stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }
    private final BookImage convertBookImage(Volume.VolumeInfo.ImageLinks imageLinks) {
        return new BookImage.Builder()
                .smallThumbnail(imageLinks.getSmallThumbnail())
                .thumbnail(imageLinks.getThumbnail())
                .build();
    }
}
