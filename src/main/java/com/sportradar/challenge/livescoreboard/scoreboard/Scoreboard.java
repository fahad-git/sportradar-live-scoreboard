package com.sportradar.challenge.livescoreboard.scoreboard;

import com.sportradar.challenge.livescoreboard.match.Match;
import com.sportradar.challenge.livescoreboard.match.MatchInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scoreboard implements ScoreBoardInterface{

    private List<Match> matches = new ArrayList<>();
    private int matchCounter = 1;

    @Override
    public void startMatch(String homeTeam, String awayTeam) {
        // validating team names.
        this.validateTeams(homeTeam, awayTeam);

        // check if match is already in progress throw an error.
        if(this.findMatch(homeTeam, awayTeam) != null){
            throw new Error("MATCH IN PROGRESS: Cannot start a match that is already in progress.");
        }

        // creating new object of Match and adding it to the list of matches.
        Match newMatch = new Match(homeTeam, awayTeam, matchCounter++);
        matches.add(newMatch);
    }

    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeTeamNewScore, int awayTeamNewScore) {
        new Error("Need implementation of updateScore() method");
    }

    @Override
    public void finishMatch(String homeTeam, String awayTeam) {
        new Error("Need implementation of finishMatch() method");
    }

    @Override
    public List<MatchInterface> matchesSummary() {
        // creating a new list for matches in progress.
        List<MatchInterface> matchesInProgress = new ArrayList<>();
        // extracting matches in progress.
        for (MatchInterface match : matches) {
            if(match.getMatchInProgress()){
                matchesInProgress.add(match);
            }
        }
        // sorting match in progress collection with match comparator.
        return matchesInProgress.stream().sorted(
                Comparator.comparingInt(MatchInterface::totalScore)
                        .thenComparingInt(MatchInterface::getMatchNumber).reversed()
        ).toList();
    }

    private Match findMatch(String homeTeam, String awayTeam) {
        return matches.stream()
                .filter(match -> homeTeam.equals(match.getHomeTeam()) && awayTeam.equals(match.getAwayTeam()) && match.getMatchInProgress())
                .findFirst()
                .orElse(null);
    }

    // This method is will validate team names
    private void validateTeams(String homeTeam, String awayTeam){

        homeTeam = homeTeam.trim();
        awayTeam = awayTeam.trim();

        if(homeTeam.length() == 0 || awayTeam.length() == 0){
            throw new Error("EMPTY TEAM NAME: Team name can not be empty.");
        }else if(homeTeam.toLowerCase().equals(awayTeam.toLowerCase())){
            throw new Error("SAME TEAM NAME: Both teams can not be same.");
        }
    }

}
