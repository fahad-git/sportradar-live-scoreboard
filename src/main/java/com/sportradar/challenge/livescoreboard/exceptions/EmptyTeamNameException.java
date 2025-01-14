package com.sportradar.challenge.livescoreboard.exceptions;

public class EmptyTeamNameException extends RuntimeException {
    public EmptyTeamNameException(String message) {
        super(message);
    }

    public EmptyTeamNameException(String message, Throwable cause) {
        super(message, cause);
    }
}
