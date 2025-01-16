package com.sportradar.challenge.livescoreboard.match;

public interface MatchInterface {

    String getHomeTeam();

    String getAwayTeam();

    int getHomeTeamScore();

    int getAwayTeamScore();

    boolean getMatchInProgress();

    int totalScore();

    int getMatchNumber();
}
