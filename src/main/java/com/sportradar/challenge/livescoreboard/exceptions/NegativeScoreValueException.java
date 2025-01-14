package com.sportradar.challenge.livescoreboard.exceptions;

public class NegativeScoreValueException extends RuntimeException {
    public NegativeScoreValueException(String message) {
        super(message);
    }

    public NegativeScoreValueException(String message, Throwable cause) {
        super(message, cause);
    }
}
