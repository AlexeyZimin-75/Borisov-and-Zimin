import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClueTest {

    @Test
    void getclue() {
        Clue clue = new Clue("Москва");
        assertAll(() -> assertEquals("Первая буква: М", clue.getclue()),
                () -> assertEquals("Вторая буква: ", clue.getclue()),
                () -> assertEquals("Третья буква: Мо", clue.getclue()));
    }
}