package com.googleapi.test.exception.response;

public class BookExceptionResponse extends ExceptionResponse{
    private long page;
    private long size;

    public BookExceptionResponse(String message, String exception_date, long page, long size) {
        super(message,exception_date);
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
