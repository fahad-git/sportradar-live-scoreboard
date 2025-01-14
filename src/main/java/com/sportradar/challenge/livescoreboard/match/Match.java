package com.sportradar.challenge.livescoreboard.match;

import lombok.Data;

@Data
public class Match implements MatchInterface{

    private String homeTeam;
    private String awayTeam;

    private int homeTeamScore;
    private int awayTeamScore;

    private int matchNumber;
    private boolean matchInProgress;

    public Match(String homeTeam, String awayTeam, int matchNumber){

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        this.homeTeamScore = 0;
        this.awayTeamScore = 0;

        this.matchNumber = matchNumber;

        this.matchInProgress = true;
    }

    @Override
    public boolean getMatchInProgress() {
        return this.matchInProgress;
    }

    // calculating total score for match sorting.
    public int totalScore(){
        return this.homeTeamScore + this.awayTeamScore;
    }
}
