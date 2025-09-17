
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class BotLogicalTest {

    private BotLogical createBot() {
        Scanner scanner = new Scanner(System.in);
        return new BotLogical(scanner);
    }

    @Test
    void testGetWelcomeMessage() {
        BotLogical bot = createBot(); // Создаем здесь

        String message = bot.getWelcomeMessage();

        assertNotNull(message);
        assertTrue(message.contains("Привет"));
        assertFalse(message.contains("yes"));
    }
    @Test
    void getHelpText() {
        BotLogical bot = createBot(); // И здесь

        String help = bot.getHelpText();

        assertNotNull(help);
        assertTrue(help.contains("ИНСТРУКЦИЯ"));
    }

    @Test
    void testCheckRightAnswer() {
        var bot = createBot();
        Clue clue = new Clue("Москва");

        BotLogical.GameResult result = bot.checkAnswer("Москва", "Москва", clue);

        assertTrue(result.isCorrect);
        assertFalse(result.isHelp);
    }

    @Test
    void testCheckWrongAnswer() {
        BotLogical bot = createBot();
        Clue clue = new Clue("Москва");

        BotLogical.GameResult result = bot.checkAnswer("Париж", "Москва", clue);

        assertFalse(result.isCorrect);
        assertFalse(result.isHelp);
    }

    @Test
    void testCheckHelpAnswer() {
        BotLogical bot = createBot();
        Clue clue = new Clue("Рим");

        BotLogical.GameResult result = bot.checkAnswer("/help", "Рим", clue);

        assertFalse(result.isCorrect);
        assertTrue(result.isHelp);
    }

}