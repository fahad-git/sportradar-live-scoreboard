package com.sportradar.challenge.livescoreboard.match;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MatchTest {

    private Match match;

    @Before
    public void init() {
        match = new Match("TeamA", "TeamB", 1);
    }

    // test constructors for different values.
    @Test
    public void testConstructors() {
        assertEquals("TeamA", match.getHomeTeam());
        assertEquals("TeamB", match.getAwayTeam());
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
        assertTrue(match.getMatchInProgress());
        assertEquals(1, match.getMatchNumber());
    }

    // test totalScore method for successfully checking total scores.
    @Test
    public void testTotalScore() {
        match.setHomeTeamScore(2);
        match.setAwayTeamScore(3);
        assertEquals(5, match.totalScore());
    }
}