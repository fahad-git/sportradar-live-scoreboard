package com.sportradar.challenge.livescoreboard.scoreboard;

import com.sportradar.challenge.livescoreboard.exceptions.*;
import com.sportradar.challenge.livescoreboard.match.Match;
import com.sportradar.challenge.livescoreboard.match.MatchInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Scoreboard implements ScoreBoardInterface{

    private final List<Match> matches = new ArrayList<>();
    private int matchCounter = 1;

    @Override
    public void startMatch(String homeTeam, String awayTeam) {
        // validating team names.
        this.validateTeams(homeTeam, awayTeam);

        // check if match is already in progress throw an error.
        if(this.findMatch(homeTeam, awayTeam) != null){
            throw new MatchAlreadyInProgress("MATCH IN PROGRESS: Cannot start a match that is already in progress.");
        }

        // creating new object of Match and adding it to the list of matches.
        Match newMatch = new Match(homeTeam, awayTeam, matchCounter++);
        matches.add(newMatch);
    }

    @Override
    public void updateScore(String homeTeam, String awayTeam, int homeTeamNewScore, int awayTeamNewScore) {
        // validating team names.
        this.validateTeams(homeTeam, awayTeam);

        // validating team scores
        if(homeTeamNewScore < 0 || awayTeamNewScore < 0){
            throw new NegativeScoreValueException("NEGATIVE SCORE VALUE: Team score can not be negative.");
        }

        // retrieving an existing match
        Match existingMatch = findMatch(homeTeam, awayTeam);

        if(existingMatch == null){
            throw new MatchNotFound("MATCH NOT FOUND: No match between " + homeTeam + " and " + awayTeam + " in progress.");
        } else if(!existingMatch.getMatchInProgress()){
            throw new MatchNotInProgress("MATCH NOT IN PROGRESS: No match between " + homeTeam + " and " + awayTeam + " in progress.");
        } else{
            existingMatch.setHomeTeamScore(homeTeamNewScore);
            existingMatch.setAwayTeamScore(awayTeamNewScore);
        }
    }

    @Override
    public void finishMatch(String homeTeam, String awayTeam) {
        // validating team name
        this.validateTeams(homeTeam, awayTeam);

        // retrieving existing match and make match in progress to false.
        Match existingMatch = findMatch(homeTeam, awayTeam);

        if(existingMatch != null){
            existingMatch.setMatchInProgress(false);
        } else {
            throw new MatchNotFound("MATCH NOT FOUND: No match between " + homeTeam + " and " + awayTeam + " in progress.");
        }
    }

    @Override
    public List<MatchInterface> matchesSummary() {
        // creating a new list for matches in progress. MatchInterface only supports read but not write/update.
        List<MatchInterface> matchesInProgress = matches.stream()
                .filter(MatchInterface::getMatchInProgress)
                .collect(Collectors.toList());

        // sorting matches in progress and returning MatchInterface which only support getter methods.
        return matchesInProgress.stream().sorted(
                Comparator.comparingInt(MatchInterface::totalScore)
                        .thenComparingInt(MatchInterface::getMatchNumber).reversed()
        ).toList();
    }

    private Match findMatch(String homeTeam, String awayTeam) {
        // find specific match (if in progress) otherwise returns null.
        return matches.stream()
                .filter(match -> homeTeam.equals(match.getHomeTeam()) && awayTeam.equals(match.getAwayTeam()) && match.getMatchInProgress())
                .findFirst()
                .orElse(null);
    }


    private void validateTeams(String homeTeam, String awayTeam){
        // trim and validate team names
        homeTeam = homeTeam.trim();
        awayTeam = awayTeam.trim();

        if(homeTeam.isEmpty() || awayTeam.isEmpty()){
            throw new EmptyTeamNameException("Empty Team Name: Team name can not be empty.");
        }else if(homeTeam.equalsIgnoreCase(awayTeam.toLowerCase())){
            throw new SameTeamNameException("Same Team Name: Both teams can not be same.");
        }
    }

}
