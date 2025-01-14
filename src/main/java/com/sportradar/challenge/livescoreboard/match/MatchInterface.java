package com.sportradar.challenge.livescoreboard.match;

public interface MatchInterface {

    // returns home team name.
    String getHomeTeam();

    // returns away team name.
    String getAwayTeam();

    // returns home team score.
    int getHomeTeamScore();

    // returns away team score.
    int getAwayTeamScore();

    boolean getMatchInProgress();

    int totalScore();

    int getMatchNumber();
}
