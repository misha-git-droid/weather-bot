package org.example;

public class NotFoundCityException extends RuntimeException {
    public NotFoundCityException(String message) {
        super(message);
    }
}
