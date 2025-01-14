package com.sportradar.challenge.livescoreboard;

import com.sportradar.challenge.livescoreboard.match.MatchInterface;
import com.sportradar.challenge.livescoreboard.scoreboard.ScoreBoardInterface;
import com.sportradar.challenge.livescoreboard.scoreboard.Scoreboard;

import java.util.List;

public class LiveScoreboardApplication {

    public static void main(String[] args) {
        ScoreBoardInterface scoreBoard = new Scoreboard();

        scoreBoard.startMatch("Maxico", "Canada");

        List<MatchInterface> matchesInProgress = scoreBoard.matchesSummary();

        System.out.println("\nMatches in progress:");
        for (MatchInterface match : matchesInProgress) {
            String summary = String.format("%s %2d - %s %2d", match.getHomeTeam(), match.getHomeTeamScore(), match.getAwayTeam(), match.getAwayTeamScore());
            System.out.println(summary);
        }
    }

}
