package com.tismo.app.exception;

public class PublisherNotFoundException extends RuntimeException {

    public PublisherNotFoundException(Long id) {
        super("Publisher not found with id: " + id);
    }

    public PublisherNotFoundException(String message) {
        super(message);
    }
}