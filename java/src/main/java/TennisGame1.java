import java.util.HashMap;
import java.util.Map;

public class TennisGame1 implements TennisGame {

    private static final Map<Integer, String> scoreDictionary = new HashMap<>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    private static final String DEUCE = "Deuce";
    private static final Map<Integer, String> tieDictionary = new HashMap<>() {{
        put(0, "Love-All");
        put(1, "Fifteen-All");
        put(2, "Thirty-All");
        put(3, DEUCE);
    }};

    private static final String PLAYER_1 = "player1";
    private static final String PLAYER_2 = "player2";
    private static final String WIN_FOR = "Win for ";
    private static final String ADVANTAGE = "Advantage ";
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
        if (getScoreDistance() == 1) {
            return ADVANTAGE + PLAYER_1;
        }
        return ADVANTAGE + PLAYER_2;
    }

    private int getScoreDistance() {
        return scorePlayer1 - scorePlayer2;
    }

    private boolean isAdvantage() {
        return isEitherPlayerAboveForty() && Math.abs(getScoreDistance()) == 1;
    }

    private boolean isWin() {
        if (isEitherPlayerAboveForty()) {
            return Math.abs(getScoreDistance()) > 1;
        }
        return false;
    }

    private String displayRunning() {
        return getScoreString(scorePlayer1) + "-" + getScoreString(scorePlayer2);
    }

    private String displayWin() {
        if (getScoreDistance() >= 2) {
            return WIN_FOR + PLAYER_1;
        }
        return WIN_FOR + PLAYER_2;
    }

    private boolean isEitherPlayerAboveForty() {
        return scorePlayer1 >= 4 || scorePlayer2 >= 4;
    }

    private String displayTie() {
        if (tieDictionary.containsKey(scorePlayer1)) {
            return tieDictionary.get(scorePlayer1);
        }
        return DEUCE;
    }

    private boolean isTie() {
        return scorePlayer1 == scorePlayer2;
    }

    private String getScoreString(int score) {
        return scoreDictionary.get(score);
    }
}
