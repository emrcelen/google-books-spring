package com.googleapi.test.exception;

public class BookNotFoundException extends RuntimeException {
    private String message;
    private long page;
    private long size;

    public BookNotFoundException(String message, long page, long size) {
        super(message);
        this.message = message;
        this.page = page;
        this.size = size;
    }

    public long getPage() {
        return page;
    }
    public long getSize() {
        return size;
    }
}
