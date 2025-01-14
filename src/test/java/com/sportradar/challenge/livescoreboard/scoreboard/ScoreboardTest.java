package com.sportradar.challenge.livescoreboard.scoreboard;

import com.sportradar.challenge.livescoreboard.match.MatchInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreboardTest {

    private ScoreBoardInterface scoreBoard;

    @Before
    public void init() {
        scoreBoard = new Scoreboard();
    }

    // test startMatch method for successfully starting match.
    @Test
    public void testStartMatchSuccessfully() {
        scoreBoard.startMatch("TeamA", "TeamB");
        List<MatchInterface> matches = scoreBoard.matchesSummary();

        assertEquals(1, matches.size());
        assertEquals("TeamA", matches.get(0).getHomeTeam());
        assertEquals("TeamB", matches.get(0).getAwayTeam());
    }


    // test startMatch method for validating for duplicate team match. Throws error.
    @Test
    public void testStartMatchDuplicate() {
        scoreBoard.startMatch("TeamA", "TeamB");
        assertThrows(Error.class, () -> scoreBoard.startMatch("TeamA", "TeamB"));
    }

    // test StartMatch for empty name of team. Throws error.
    @Test
    public void testStartMatchEmptyNames() {
        assertThrows(Error.class, () -> scoreBoard.startMatch("", "TeamB"));
        assertThrows(Error.class, () -> scoreBoard.startMatch("TeamA", ""));
    }

    // test startMatch for same team name. Throws error.
    @Test
    public void testStartMatchSameTeamName() {
        assertThrows(Error.class, () -> scoreBoard.startMatch("TeamB", "TeamB"));
        assertThrows(Error.class, () -> scoreBoard.startMatch("TeamA", "TeamA"));
    }

    // test updateScore method for successfully updating match scores.
    @Test
    public void testUpdateScoreSuccessful() {
        scoreBoard.startMatch("TeamA", "TeamB");
        scoreBoard.updateScore("TeamA", "TeamB", 2, 3);

        List<MatchInterface> matches = scoreBoard.matchesSummary();
        assertEquals(2, matches.get(0).getHomeTeamScore());
        assertEquals(3, matches.get(0).getAwayTeamScore());
    }


    // test updateScore method for updated score of match which has ended. Throws error.
    @Test
    public void testUpdateScoreFailure() {
        assertThrows(Error.class, () -> scoreBoard.updateScore("TeamA", "TeamB", 2, 3));
    }

    // test finishMatch for successfully finishing match.
    @Test
    public void testFinishMatchSuccessfully() {
        scoreBoard.startMatch("TeamA", "TeamB");
        scoreBoard.finishMatch("TeamA", "TeamB");

        List<MatchInterface> matches = scoreBoard.matchesSummary();
        assertTrue(matches.isEmpty(), "The matches list should be empty.");
    }

    //  test finishMatch for finishing a match which is already finished. Throws error.
    @Test
    public void testFinishMatchFailure() {
        assertThrows(Error.class, () -> scoreBoard.finishMatch("TeamA", "TeamB"));
    }

    // test matchesSummary for providing matches in progress in the correct order.
    @Test
    public void testMatchesSummary() {
        scoreBoard.startMatch("TeamA", "TeamB");
        scoreBoard.updateScore("TeamA", "TeamB", 1, 1);

        scoreBoard.startMatch("TeamC", "TeamD");
        scoreBoard.updateScore("TeamC", "TeamD", 3, 2);

        scoreBoard.startMatch("TeamE", "TeamF");
        scoreBoard.updateScore("TeamE", "TeamF", 1, 1);

        List<MatchInterface> matchesInProgress = scoreBoard.matchesSummary();
        assertEquals(3, matchesInProgress.size());

        // Check the order based on total score
        assertEquals("TeamD", matchesInProgress.get(0).getAwayTeam());
        assertEquals("TeamE", matchesInProgress.get(1).getHomeTeam());
        assertEquals("TeamA", matchesInProgress.get(2).getHomeTeam());
    }
}