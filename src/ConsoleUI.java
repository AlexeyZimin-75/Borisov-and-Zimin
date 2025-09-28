public class ConsoleUI {
    public static String getDataOfPlayer(){
        return """ 
                Введите свое имя:""";
    }



    public static String getWelcomeMessage(String nameOfPlayer) {
        String name;
        if(nameOfPlayer != null){
            name = nameOfPlayer;
        }
        else{name = "друг";};
        return """
                Привет, %s! Помогу тебе выучить столицы
                Напиши /start,если хочешь начать
                /help - если хочешь узнать больше информации
                /exit - если хочешь закончить работу""".formatted(name);
    }

    public static String getHelpText() {
        return """
                ИНСТРУКЦИЯ ДЛЯ ИГРЫ\s
                Цель: угадать загаданную столицу
                Команды:
                /start - начать игру
                /help - показать помощь
                /exit - выйти из игры
                /change - сменить пользователя""";
    }

    public static String getContinueMessage() {
        return """
                Продолжить? (введите /start для продолжения или /exit для выхода или /change для смены пользователя)""";
    }

    public enum Commands {
        HELP ("/help"),
        START ("/start"),
        EXIT ("/exit"),
        CHANGE ("/change");

        private final String commandText;

        Commands(String commandText) {
            this.commandText = commandText;
        }

        public static Commands fromString(String text) {
            for (Commands cmd : Commands.values()) {
                if (cmd.commandText.equalsIgnoreCase(text)) {
                    return cmd;
                }
            }
            return null;
        }
    }

    public static boolean showHelp() {
        System.out.println(ConsoleUI.getHelpText());
        return true;
    }
}
