package com.inditex.storeapp.domain.exceptions;

public class InvalidInputParametersException extends RuntimeException {
    public InvalidInputParametersException(String message, Throwable cause) {
        super(message, cause);
    }
}
