public class Clue {

    private static String capital;
    private static int guess = 0;

    public Clue(String capital) {
        this.capital = capital;
    }

    public static String getclue() { // дать подсказку
        guess++;

        if (guess == 1) {
            return "Первая буква: " + capital.charAt(0);
        } else if (guess == 2) {
            return "Вторая буква: " + capital.substring(0, 2);
        } else if (guess == 3) {
            return "Третья буква: " + capital.substring(0, 3);
        } else {
            return "Подсказки закончились! Столица: " + capital;
        }
    }

    public void resetGuess() {
        guess = 0;
    }
}
