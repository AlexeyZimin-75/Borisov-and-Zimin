import java.util.Map;
import java.util.Scanner;

public class BotLogical {
    private final ConsoleUI ui;

    public BotLogical(ConsoleUI ui) {
        this.ui = ui;
    }


    public void start(){
            ui.showMainMessage();
            String command = ui.getPutUserInput();
            if(command.equals("yes")){
                play();
            }
            else if (command.equals("/help")) {
                help();
            }
            else {
                ui.exit();
            }
    }

    public void help() {

        ui.showHelp();

        String command = ui.getPutUserInput();
        if(command.equals("/help")){
            help();
        }
        else if(command.equals("/start")){
            start();
        }
        else if(command.equals("/exit")){
            ui.exit();
        }
        else if(command.equals("/continue")){
            play();
        }
        else{
            ui.showUnknownCommandMessage();
            help();
        }

    }


    public void play() {
        Map.Entry<String, String> cityAndCapital = CitiesAndCapitals.getRandomPair();
        String capital = cityAndCapital.getValue();
        ui.askForCapital(cityAndCapital.getKey());
        String command = ui.getPutUserInput();

        Clue clue = new Clue(capital);

        for (var i = 0; i < 4; i++) {
            if(command.equals("/help")){
                help();
            }
            else if (command.equals(capital)) {
                ui.showCorrectAnswerMessage();
                play();
            } else {
                ui.showClue(clue.getclue());
            }
        }
        play();
    }
}
