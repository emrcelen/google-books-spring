package com.googleapi.test.exception.response;

public class ExceptionResponse{
    private String message;
    private String exception_date;

    public ExceptionResponse(String message, String exception_date) {
        this.message = message;
        this.exception_date = exception_date;
    }
    public String getMessage() {
        return message;
    }
    public String getException_date() {
        return exception_date;
    }
}
