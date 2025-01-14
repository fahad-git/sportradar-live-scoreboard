package com.sportradar.challenge.livescoreboard;

import com.sportradar.challenge.livescoreboard.match.MatchInterface;
import com.sportradar.challenge.livescoreboard.scoreboard.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ScoreBoardInterface scoreBoard = new Scoreboard();

        scoreBoard.startMatch("Maxico", "Canada");
        scoreBoard.updateScore("Maxico", "Canada", 0, 5);

        scoreBoard.startMatch("Spain", "Brazil");
        scoreBoard.updateScore("Spain", "Brazil", 10, 2);

        scoreBoard.startMatch("Germany", "France");
        scoreBoard.updateScore("Germany", "France", 2, 2);

        scoreBoard.startMatch("Uruguay", "Italy");
        scoreBoard.updateScore("Uruguay", "Italy", 6, 6);

        scoreBoard.startMatch("Argentina", "Australia");
        scoreBoard.updateScore("Argentina", "Australia", 3, 1);

        List<MatchInterface> matchesInProgress = scoreBoard.matchesSummary();

        System.out.println("\nMatches in progress:");
        for (MatchInterface match : matchesInProgress) {
            String summary = String.format("%s %2d - %s %2d", match.getHomeTeam(), match.getHomeTeamScore(), match.getAwayTeam(), match.getAwayTeamScore());
            System.out.println(summary);
        }
    }

}
