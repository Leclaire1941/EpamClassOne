package com.epam.quadrangle.exceptions;

import java.io.FileNotFoundException;

public class NoFileException extends FileNotFoundException {
    public NoFileException(String message) {
        super(message);
    }
}
