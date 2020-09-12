package com.in28minutes.rest.webservices.restfulwebservices.user.exception;

public class NoOneUserFoundException extends RuntimeException {
    public NoOneUserFoundException(String message) {
        super(message);
    }
}
