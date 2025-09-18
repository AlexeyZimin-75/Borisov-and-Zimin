public class GameEngine {
    public record GameResult(boolean isCorrect, boolean isHelp, String message) {
    }

    public static GameResult checkAnswer(String userAnswer, String correctAnswer, Clue clue) {
        if (userAnswer.equals("/help")) {
            return new GameResult(false, true, "");
        }

        if (userAnswer.equals(correctAnswer)) {
            return new GameResult(true, false, "");
        }

        if (userAnswer.equals("/exit")) {
            return new GameResult(false, false, "");
        }

        return new GameResult(false, false, Clue.getclue());
    }
}
