package com.sportradar.challenge.livescoreboard.exceptions;

public class MatchNotFound extends RuntimeException {
    public MatchNotFound(String message) {
        super(message);
    }

    public MatchNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}


