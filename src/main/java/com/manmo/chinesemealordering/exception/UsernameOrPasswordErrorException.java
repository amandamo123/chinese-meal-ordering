package com.manmo.chinesemealordering.exception;

public class UsernameOrPasswordErrorException extends RuntimeException {
    public UsernameOrPasswordErrorException(String message) {
        super(message);
    }
}
