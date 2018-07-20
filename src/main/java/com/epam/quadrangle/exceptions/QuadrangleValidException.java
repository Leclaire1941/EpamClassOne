package com.epam.quadrangle.exceptions;

public class QuadrangleValidException extends Exception {

    public QuadrangleValidException(String message) {
        super(message);
    }

    public QuadrangleValidException(String message, Throwable cause) {
        super(message, cause);
    }
}
