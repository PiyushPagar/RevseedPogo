package com.revnomix.revseed.model;

import org.springframework.boot.autoconfigure.SpringBootApplication;
public class StorageException  extends RuntimeException {

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}