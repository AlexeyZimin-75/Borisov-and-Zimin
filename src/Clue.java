public class Clue {

    private String capital;
    private int guess = 0;

    public Clue(String capital) {
        this.capital = capital;
    }

    public String getclue() { // дать подсказку
        guess++;

        if (guess == 1) {
            return "Первая буква: " + capital.charAt(0);
        } else if (guess == 2) {
            return "Вторая буква: " + capital.charAt(1);
        } else if (guess == 3) {
            return "Третья буква: " + capital.charAt(2);
        } else {
            return "Подсказки закончились! Столица: " + capital;
        }
    }

    public void reset() { // сброс
        guess = 0;
    }
}
