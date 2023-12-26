package com.googleapi.test.service;

import com.google.api.services.books.Books;
import com.google.api.services.books.Books.Volumes.Get;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import com.googleapi.test.exception.BookNotFoundException;
import com.googleapi.test.exception.GeneralException;
import com.googleapi.test.mapper.BookResponseConverter;
import com.googleapi.test.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.io.IOException;

@Service
public class GoogleBookService {
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    private final BookResponseConverter converter;
    private final Books books;

    public GoogleBookService(BookResponseConverter converter, Books books) {
        this.converter = converter;
        this.books = books;
    }

    public List<Book> getBooks(String query,
                               Long page,
                               Long size) {
        Volumes volumesBook = searchBooks(query, page - 1,size);
        if (volumesBook != null && volumesBook.getItems() != null && !volumesBook.getItems().isEmpty())
                return converter.convertToResponse(volumesBook);
        throw new BookNotFoundException("Arama kriterlerine uygun kitap bulunamadı.",page,size);
    }

    public Book getBook(String id){
        Volume volume = searchBook(id);
        if(volume != null)
            return converter.convertToResponse(volume);
        throw new GeneralException(String.format("%s id'li kitap sistemde bulunamadı.",id));
    }
    private Volume searchBook(String id){
        try {
            Get get = this.books.volumes().get(id);
            return get.execute();
        } catch (IOException e) {
            throw new GeneralException(String.format("%s id'li kitap sistemde bulunamadı.",id));
        }
    }

    private Volumes searchBooks(String query,
                                Long page,
                                Long size) {
        size = size > 0 && size <= 40 ? size : 40;
        page = page > 0 ? page * size : 0;
        try {
            Books.Volumes.List bookList = this.books.volumes().list("filter:".concat(query))
                    .setStartIndex(page)
                    .setMaxResults(size);
            return bookList.execute();
        } catch (IOException e) {
            throw new GeneralException("İstekte bulunurken beklenmedik bir hata ile karşılaşıldı.");
        }
    }
}
