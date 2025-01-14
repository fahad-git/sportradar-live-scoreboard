package com.sportradar.challenge.livescoreboard.scoreboard;

import com.sportradar.challenge.livescoreboard.match.MatchInterface;

import java.util.List;

public interface ScoreBoardInterface {

    // This interface is created for scoreboard.

    void startMatch(String homeTeam, String awayTeam);

    void updateScore(String homeTeam, String awayTeam, int homeTeamNewScore, int awayTeamNewScore);

    void finishMatch(String homeTeam, String awayTeam);

    List<MatchInterface> matchesSummary();
}
