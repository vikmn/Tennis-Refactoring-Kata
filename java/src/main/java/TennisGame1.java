
public class TennisGame1 implements TennisGame {

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
        String score = "";
        if (scorePlayer1 == scorePlayer2) {
            score = switch (scorePlayer1) {
                case 0 -> "Love-All";
                case 1 -> "Fifteen-All";
                case 2 -> "Thirty-All";
                default -> "Deuce";
            };
            return score;
        }
        if (scorePlayer1 >= 4 || scorePlayer2 >= 4) {
            int minusResult = scorePlayer1 - scorePlayer2;
            if (minusResult == 1) {
                return "Advantage " + PLAYER_1;
            }
            if (minusResult == -1) {
                return "Advantage " + PLAYER_2;
            }
            if (minusResult >= 2) {
                return  "Win for " + PLAYER_1;
            }
            return  "Win for " + PLAYER_2;
        }
        switch (scorePlayer1) {
            case 0 -> score += "Love";
            case 1 -> score += "Fifteen";
            case 2 -> score += "Thirty";
            case 3 -> score += "Forty";
        }
        score += "-";
        switch (scorePlayer2) {
            case 0 -> score += "Love";
            case 1 -> score += "Fifteen";
            case 2 -> score += "Thirty";
            case 3 -> score += "Forty";
        }

        return score;
    }
}
