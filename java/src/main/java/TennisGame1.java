import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private static final Map<Integer, String> scoreDictionary = new HashMap<>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    private static final String PLAYER_1 = "player1";
    private static final String PLAYER_2 = "player2";
    private int scorePlayer1 = 0;
    private int scorePlayer2 = 0;

    public void wonPoint(String playerName) {
        if (playerName.equals(PLAYER_1)) {
            scorePlayer1 += 1;
            return;
        }
        scorePlayer2 += 1;
    }

    public String getScore() {
        if (isTie()) {
            return displayTie();
        }
        if (isAdvantage()) {
            return displayAdvantage();
        }
        if (isWin()) {
            return displayWin();
        }

        return displayRunning();
    }

    private String displayAdvantage() {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult == 1) {
            return "Advantage " + PLAYER_1;
        }
        return "Advantage " + PLAYER_2;
    }

    private boolean isAdvantage() {
        if (isEitherPlayerAboveForty()) {
            return Math.abs(scorePlayer1 - scorePlayer2) == 1;
        }
        return false;
    }

    private boolean isWin() {
        if (isEitherPlayerAboveForty()) {
            return Math.abs(scorePlayer1 - scorePlayer2) > 1;
        }
        return false;
    }

    private String displayRunning() {
        return getScoreString(scorePlayer1) + "-" + getScoreString(scorePlayer2);
    }

    private String displayWin() {
        int minusResult = scorePlayer1 - scorePlayer2;
        if (minusResult >= 2) {
            return "Win for " + PLAYER_1;
        }
        return "Win for " + PLAYER_2;
    }

    private boolean isEitherPlayerAboveForty() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private String displayTie() {
        String score;
        score = switch (scorePlayer1) {
            case 0 -> "Love-All";
            case 1 -> "Fifteen-All";
            case 2 -> "Thirty-All";
            default -> "Deuce";
        };
        return score;
    }

    private boolean isTie() {
        return scorePlayer1 == scorePlayer2;
    }

    private String getScoreString(int score) {
        return scoreDictionary.get(score);
    }
}
