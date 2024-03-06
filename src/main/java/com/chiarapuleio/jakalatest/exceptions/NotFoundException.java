package com.chiarapuleio.jakalatest.exceptions;

import java.util.UUID;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(UUID id) {
        super(id + " not found.");
    }

    public NotFoundException(int id) {
        super(id + " not found.");
    }
}
