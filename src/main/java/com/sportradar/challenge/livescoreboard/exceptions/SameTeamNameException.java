package com.sportradar.challenge.livescoreboard.exceptions;

public class SameTeamNameException extends RuntimeException {
    public SameTeamNameException(String message) {
        super(message);
    }

    public SameTeamNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
