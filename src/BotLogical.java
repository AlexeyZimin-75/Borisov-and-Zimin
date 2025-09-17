import java.util.Map;
import java.util.Scanner;

public class BotLogical {
    private final Scanner scanner;
    private boolean isRunning = true;

    public BotLogical(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getWelcomeMessage() {
        return """
                Привет, помогу тебе выучить столицы
                Напиши /start,если хочешь начать
                /help - если хочешь узнать больше информации
                /exit - если хочешь закончить работу""";
    }


    public void start() {
        System.out.println(getWelcomeMessage());

        while (isRunning) {
            String command = scanner.next();
            processCommand(command);
            System.out.println("""
                    Хотите начать новую игру? (/start - для продолжения, \
                    /exit - для выхода""");
        }
    }

    public void processCommand(String command) {
        switch (command) {
            case "/start" -> play();
            case "/help" -> showHelp();
            case "/exit" -> exitApplication();
            default -> {
            }
        }
    }

    public String getHelpText() {
        return """
                ИНСТРУКЦИЯ ДЛЯ ИГРЫ\s
                Цель: угадать загаданную столицу
                Команды:
                /start - начать игру
                /help - показать помощь
                /exit - выйти из игры
                /continue - продолжить играть""";
    }

    public boolean showHelp() {
        System.out.println(getHelpText());

        String command = scanner.next();
        switch (command) {
            case "/help" -> {
                return showHelp();
            }
            case "/start", "/continue" -> {
                return play();
            }
            case "/exit" -> {
                exitApplication();
                return false;
            }
            default -> {
                System.out.println("Такой команды нет!");
                return showHelp();
            }
        }
    }


    public boolean play() {
        Map.Entry<String, String> cityAndCapital = CitiesAndCapitals.getRandomPair();
        String capital = cityAndCapital.getValue();
        String country = cityAndCapital.getKey();

        System.out.println("Введи столицу страны " + country);

        Clue clue = new Clue(capital);

        for (var i = 0; i < 4; i++) {
            String userAnswer = scanner.next();

            GameResult result = checkAnswer(userAnswer, capital, clue);

            if (result.isHelp) {
                return showHelp();
            }

            if (result.isCorrect) {
                System.out.println("Правильно");
                return true;
            } else {
                System.out.println(result.message);
            }
        }
        return true;
    }

    public static class GameResult {
        public boolean isCorrect;
        public boolean isHelp;
        public String message;

        public GameResult(boolean isCorrect, boolean isHelp, String message) {
            this.isCorrect = isCorrect;
            this.isHelp = isHelp;
            this.message = message;
        }
    }

    public GameResult checkAnswer(String userAnswer, String correctAnswer, Clue clue) {
        if (userAnswer.equals("/help")) {
            return new GameResult(false, true, "");
        }

        if (userAnswer.equals(correctAnswer)) {
            return new GameResult(true, false, "");
        }

        return new GameResult(false, false, clue.getclue());
    }


    public void exitApplication() {
        isRunning = false;
        System.out.println("До свидания");
    }

}
