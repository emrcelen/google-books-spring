package com.googleapi.test.model;

import java.util.List;

public class Book {
    private String id;
    private String title;
    private List<String> authors;
    private String publisher;
    private String publishedDate;
    private int pageCount;
    private BookImage imageLinks;
    private String pdfLink;

    public Book (Builder builder){
        this.id = builder.id;
        this.title = builder.title;
        this.authors = builder.authors;
        this.publisher = builder.publisher;
        this.publishedDate = builder.publishedDate;
        this.pageCount = builder.pageCount;
        this.imageLinks = builder.imageLinks;
        this.pdfLink = builder.pdfLink;
    }

    //Getter:
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getPublishedDate() {
        return publishedDate;
    }
    public int getPageCount() {
        return pageCount;
    }
    public BookImage getImageLinks() {
        return imageLinks;
    }
    public String getPdfLink() {
        return pdfLink;
    }

    public static class Builder {
        private String id;
        private String title;
        private List<String> authors;
        private String publisher;
        private String publishedDate;
        private int pageCount;
        private BookImage imageLinks;
        private String pdfLink;

        public Builder id (String id){
            this.id = id;
            return this;
        }
        public Builder title (String title){
            this.title = title;
            return this;
        }
        public Builder authors (List<String> authors){
            this.authors = authors;
            return this;
        }
        public Builder publisher (String publisher){
            this.publisher = publisher;
            return this;
        }
        public Builder publishedDate (String date){
            this.publishedDate = date;
            return this;
        }
        public Builder pageCount (int pageCount){
            this.pageCount = pageCount;
            return this;
        }
        public Builder bookImage (BookImage imageLinks){
            this.imageLinks = imageLinks;
            return this;
        }
        public Builder pdfLink (String pdfLink){
            this.pdfLink = pdfLink;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
}
