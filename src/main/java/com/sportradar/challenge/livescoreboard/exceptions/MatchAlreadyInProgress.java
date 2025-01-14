package com.sportradar.challenge.livescoreboard.exceptions;

public class MatchAlreadyInProgress extends RuntimeException {
    public MatchAlreadyInProgress(String message) {
        super(message);
    }

    public MatchAlreadyInProgress(String message, Throwable cause) {
        super(message, cause);
    }
}


