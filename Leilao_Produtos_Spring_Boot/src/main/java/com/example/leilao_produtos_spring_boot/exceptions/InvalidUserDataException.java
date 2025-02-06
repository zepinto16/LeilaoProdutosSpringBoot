package com.example.leilao_produtos_spring_boot.exceptions;

import java.io.Serializable;

public class InvalidUserDataException extends RuntimeException {
    public InvalidUserDataException(String message) {
        super();
    }
}
