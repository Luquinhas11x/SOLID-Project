package com.training.rh.exception;

public class ValidationException extends RuntimeException {
    private final long serialVersionUID = 1L;

    public ValidationException(String message) {
        super(message);
    }
}
