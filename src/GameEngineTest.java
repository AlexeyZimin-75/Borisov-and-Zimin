import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameEngineTest {

    @Test
    void testCheckRightAnswer() {
        String capital = "Москва";
        Clue clue = new Clue(capital);
        GameEngine.GameResult result = GameEngine.checkAnswer("Москва", "Москва", clue);
        assertAll(() -> assertTrue(result.isCorrect()),
                () -> assertFalse(result.isHelp()),
                () -> assertEquals("", result.message()));
    }

    @Test
    void testCheckWrongAnswer() {
        String capital = "Москва";
        Clue clue = new Clue(capital);
        GameEngine.GameResult result = GameEngine.checkAnswer("Рим", capital, clue);
        assertAll(() -> assertFalse(result.isCorrect()),
                () -> assertFalse(result.isHelp()),
                () -> assertEquals("Первая буква: М", result.message()));
    }

    @Test
    void testCheckHelpAnswer() {
        String capital = "Москва";
        Clue clue = new Clue(capital);
        GameEngine.GameResult result = GameEngine.checkAnswer("/help", capital, clue);
        assertAll(() -> assertFalse(result.isCorrect()),
                () -> assertTrue(result.isHelp()),
                () -> assertEquals("", result.message()));
    }

}