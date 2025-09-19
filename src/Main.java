import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        BotLogical game = new BotLogical(ui);
        game.start();
    }
}
