package com.example.leilao_produtos_spring_boot.exceptions;

public class InvalidAuctionDataException extends RuntimeException {
    public InvalidAuctionDataException(String message) {
        super(message);
    }

}
