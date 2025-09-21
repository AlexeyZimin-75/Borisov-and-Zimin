import java.util.Map;
import java.util.Scanner;



public class BotLogical {
    private final Scanner scanner;
    private boolean isRunning = true;

    public BotLogical(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        System.out.println(ConsoleUI.getWelcomeMessage());

        while (isRunning) {
            String command = scanner.next();
            processCommand(command);
        }
    }

    public void processCommand(String command) {
        switch (ConsoleUI.Commands.fromString(command)) {
            case ConsoleUI.Commands.START -> play();
            case ConsoleUI.Commands.HELP -> ConsoleUI.showHelp();
            case ConsoleUI.Commands.EXIT -> exitApplication();
            case null, default -> System.out.println("Такой команды нет!");
        }
    }



    public boolean play() {
        Map.Entry<String, String> cityAndCapital = CountriesAndCapitals.getRandomPair();
        String capital = cityAndCapital.getValue();
        String country = cityAndCapital.getKey();

        System.out.println("Введи столицу страны " + country);

        Clue clue = new Clue(capital);

        while (Clue.getCountClue() < 4) {
            String userAnswer = scanner.next();

            if (userAnswer.equals("/exit")) {
                exitApplication();
                return false;
            }

            GameEngine.GameResult result = GameEngine.checkAnswer(userAnswer, capital, clue);

            if (result.isHelp()) {
                if (!ConsoleUI.showHelp()) {
                    return false;
                }
                continue;
            }

            if (result.isCorrect()) {
                System.out.println("Правильно");
                clue.resetGuess();
                break;
            }
            System.out.println(result.message());
        }
        clue.resetGuess();
        System.out.println(ConsoleUI.getContinueMessage());
        return true;
    }


    public void exitApplication() {
        isRunning = false;
        System.out.println("До свидания");
    }
}
