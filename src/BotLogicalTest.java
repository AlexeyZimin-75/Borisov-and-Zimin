import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BotLogicalTest {

    private BotLogical bot;

    private BotLogical createBot() {
        String testInput = "dummy";
        Scanner scanner = new Scanner(new ByteArrayInputStream(testInput.getBytes()));
        return new BotLogical(scanner);
    }

    @Test
    void testGetWelcomeMessage() {
        BotLogical bot = createBot(); // Создаем здесь

        String message = bot.getWelcomeMessage();

        assertNotNull(message);
        assertTrue(message.contains("Привет"));
        assertTrue(message.contains("yes"));
    }
    @Test
    void getHelpText() {
        BotLogical bot = createBot(); // И здесь

        String help = bot.getHelpText();

        assertNotNull(help);
        assertTrue(help.contains("ИНСТРУКЦИЯ"));
    }

    @Test
    void showHelp() {
    }

    @Test
    void play() {
    }

    @Test
    void testCheckRightAnswer() {
        BotLogical bot = createBot();
        Clue clue = new Clue("Москва");

        BotLogical.GameResult result = bot.checkAnswer("Москва", "Москва", clue);

        assertTrue(result.isCorrect);
        assertFalse(result.isHelp);
    }

    @Test
    void testCheckWrongAnswer() {
        BotLogical bot = createBot();
        Clue clue = new Clue("Париж");

        BotLogical.GameResult result = bot.checkAnswer("Москва", "Париж", clue);

        assertFalse(result.isCorrect);
        assertFalse(result.isHelp);
    }

    @Test
    void exitApplication() {
    }
}