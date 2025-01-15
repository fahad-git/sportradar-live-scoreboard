package com.sportradar.challenge.livescoreboard.match;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    private Match match;

    @BeforeEach
    void init() {
        match = new Match("TeamA", "TeamB", 1);
    }

    // test constructors for different values.
    @Test
    void testConstructors() {
        assertEquals("TeamA", match.getHomeTeam());
        assertEquals("TeamB", match.getAwayTeam());
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getAwayTeamScore());
        assertTrue(match.getMatchInProgress());
        assertEquals(1, match.getMatchNumber());
    }

    // test totalScore method for successfully checking total scores.
    @Test
    void testTotalScore() {
        match.setHomeTeamScore(2);
        match.setAwayTeamScore(3);
        assertEquals(5, match.totalScore());
    }
}