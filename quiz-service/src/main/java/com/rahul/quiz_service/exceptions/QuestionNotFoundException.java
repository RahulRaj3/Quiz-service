package com.rahul.quiz_service.exceptions;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException(String exception) {
        super(exception);
    }
}
