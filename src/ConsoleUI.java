public class ConsoleUI {
    public static String getWelcomeMessage() {
        return """
                Привет, помогу тебе выучить столицы
                Напиши /start,если хочешь начать
                /help - если хочешь узнать больше информации
                /exit - если хочешь закончить работу""";
    }

    public static String getHelpText() {
        return """
                ИНСТРУКЦИЯ ДЛЯ ИГРЫ\s
                Цель: угадать загаданную столицу
                Команды:
                /start - начать игру
                /help - показать помощь
                /exit - выйти из игры
                /continue - продолжить играть""";
    }

    public static String getContinueMessage() {
        return """
                Продолжить? (введите /start для продолжения или /exit для выхода)""";
    }

    public enum Commands {
        HELP ("/help"),
        START ("/start"),
        EXIT ("/exit"),
        CONTINUE ("/continue");

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
}
