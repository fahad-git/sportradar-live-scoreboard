package com.sportradar.challenge.livescoreboard.exceptions;

public class MatchNotInProgress extends RuntimeException {
    public MatchNotInProgress(String message) {
        super(message);
    }

    public MatchNotInProgress(String message, Throwable cause) {
        super(message, cause);
    }
}


