# Sportradar Live Football Worldcup Scoreboard
This project is a **Live Football World Cup Scoreboard Library** that helps manage and display live football matches and their scores. It allows you to start new matches, update scores, finish matches, and get a summary of the ongoing games, sorted by their total scores.

---

## Features

- **Live Scores**: Keep track of the current scores for football matches happening right now.
- **Start New Match**: Set up a new football game by choosing the home and away teams, starting with both teams at 0-0.
- **Update Score**: Easily update the scores during a match as the game progresses.
- **Finish Match**: Mark a game as finished, and remove it from the list of ongoing matches.
- **Match Summary**: Get a summary of all the matches currently in progress, sorted by the total scores.

---

## Usage

### Create an Instance of `ScoreBoard`

To begin using the library, create an instance of the `ScoreBoard` class.

```java
ScoreBoardInterface scoreboard = new ScoreBoard();
```

### Start a New Match

You can start a new match by providing the home and away team names to `startMatch` function. Their default score will be 0-0.

```java
scoreboard.startMatch("Spain", "Brazil");
```

### Updating an Ongoing Match Score

To update the score of an ongoing match, use the `updateScore` method. Pass the names of the home team and away team along with their updated scores.

```java
scoreboard.updateScore("Spain", "Brazil", 2, 3);
```

**Parameters:**
- `homeTeam`: The name of the home team (case-insensitive).
- `awayTeam`: The name of the away team (case-insensitive).
- `homeScore`: The updated score for the home team (must be a non-negative integer).
- `awayScore`: The updated score for the away team (must be a non-negative integer).

**Important Notes:**
- Ensure that the match is active before updating scores.
- To update the score of a match, the team names must same as those used for starting the match.


### Finish a Match

To mark a match as finished, use the `finishMatch` method. Pass the names of the home and away teams.

```java
scoreboard.finishMatch("Spain", "Brazil");
```

**Parameters:**
- `homeTeam`: The name of the home team (case-insensitive).
- `awayTeam`: The name of the away team (case-insensitive).

**Outcome:**
- The match will be removed from the active scoreboard. However, the match progress will be there for analysis purposes.

### Retrieve a Summary of Matches in Progress

To retrieve a summary of all ongoing matches, sorted by total score, use the `matchesSummary` method.

```java
// retrieve an immutable list of all in-progress matches.
List<MatchInterface> matchesSummary = scoreBoard.matchesSummary();

// print summary
for (MatchInterface match : matchesSummary) {
    String summary = String.format("%s %2d - %s %2d", match.getHomeTeam(), match.getHomeTeamScore(), match.getAwayTeam(), match.getAwayTeamScore());
    System.out.println(summary);
}
```

**Output:**
- A read-only list of `Match` objects representing ongoing matches, sorted by total score in descending order. Matches with the same score are displayed in the order they were added.
- Print progress of all in-progress matches.

---
## Assumptions:

Please note that these assumptions were made while working on the implementation:

- We use the match number to differentiate between matches that have the same total score. Matches with higher numbers were started more recently.
- Team names are not case-sensitive and cannot be empty or just consist of spaces.
- You cannot start a new match between the same teams at the same time.
- Scores cannot be negative when updating.

---

## Running Unit Tests

To execute all unit test cases using JUnit:

1. Refer to the link to run all unit test cases via IntelliJ IDE: https://www.jetbrains.com/help/idea/work-with-tests-in-maven.html#debug_maven
2. To run unit tests in any IDE, execute the test package as a root.

This will execute all test cases and display the results.

## Suggestions
If you have any suggestions for improvements, please feel free to open an issue on the repository.
