import java.util.Map;
import java.util.Scanner;

public class BotLogical {
    private Scanner scanner;
    private boolean isRunning = true;

    public BotLogical(Scanner scanner) {
        this.scanner = scanner;
    }


    public String getWelcomeMessage() {
        return "Привет, помогу тебе выучить столицы\n" +
                "Напиши yes,если хочешь начать\n" +
                "/help - если хочешь узнать больше информации\n" +
                "/exit - если хочешь закончить работу";
    }

    public void start() {
        System.out.println(getWelcomeMessage());

        while (isRunning) {
            String command = scanner.next();
            processCommand(command);
        }
    }

    public boolean processCommand(String command) {
        if(command.equals("yes")){
            return play();
        }
        else if (command.equals("/help")) {
            return showHelp();
        }
        else if (command.equals("/exit")) {
            exitApplication();
            return false;
        }
        else {
            return true; // Продолжаем работу
        }
    }

    public String getHelpText() {
        return "ИНСТРУКЦИЯ ДЛЯ ИГРЫ \n" +
                "Цель: угадать загаданную столицу\n" +
                "Команды:\n" +
                "/start - начать игру\n" +
                "/help - показать помощь\n" +
                "/exit - выйти из игры\n" +
                "/continue - продолжить играть";
    }

    public boolean showHelp() {
        System.out.println(getHelpText());

        String command = scanner.next();
        if(command.equals("/help")){
            return showHelp();
        }
        else if(command.equals("/start")){
            return play();
        }
        else if(command.equals("/exit")){
            exitApplication();
            return false;
        }
        else if(command.equals("/continue")){
            return play();
        }
        else{
            System.out.println("Такой команды нет!");
            return showHelp();
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
                return askToContinue();
            } else {
                System.out.println(result.message);
            }
        }
        return askToContinue();
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

    public boolean askToContinue() {
        System.out.println("Хотите продолжить? (yes/no)");
        String answer = scanner.next();
        return answer.equals("yes");
    }

    public void exitApplication() {
        isRunning = false;
        System.out.println("До свидания");
    }

    public boolean isRunning() {
        return isRunning;
    }
}
