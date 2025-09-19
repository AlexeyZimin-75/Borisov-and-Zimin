import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    public String getPutUserInput(){
        return scanner.next();
    }

    public void showMainMessage(){
        System.out.println(
                "Привет, помогу тебе выучить столицы\n" +
                        "Напиши yes, если хочешь начать\n" +
                        "/help - если хочешь узнать больше информации\n" +
                        "/exit - если хочешь закончить работу");
    };

    public void showHelp(){
        System.out.println("ИНСТРУКЦИЯ ДЛЯ ИГРЫ ");
        System.out.println("Цель: угадать загаданную столицу");
        System.out.println("Команды:");
        System.out.println("/start - начать игру");
        System.out.println("/help - показать помощь");
        System.out.println("/exit - выйти из игры");
        System.out.println("/continue - продолжить играть");
    }

    public void askForCapital(String country){
        System.out.println("Введи столицу страны " + country);
    }

    public void showClue(String clue){
        System.out.println(clue);
    }

    public void showCorrectAnswerMessage() {
        System.out.println("Правильно");
    }

    public void showUnknownCommandMessage() {
        System.out.println("Такой команды нет!");
    }

    public void exit() {
        System.exit(0);
    }




}


