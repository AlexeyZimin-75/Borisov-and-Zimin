import java.util.*;

public class CitiesAndCapitals {


    public static Map.Entry<String,String> getRandomPair(){
        Random random = new Random();
        List<Map.Entry<String, String>> entryList = new ArrayList<>(storage.entrySet());
        int randomIndex = random.nextInt(entryList.size());

        return entryList.get(randomIndex);


    }


    private static final Map<String, String> storage = new HashMap<>();
    static {
        storage.put("Аргентина", "Буэнос-Айрес");
        storage.put("Австралия", "Канберра");
        storage.put("Австрия", "Вена");
        storage.put("Бельгия", "Брюссель");
        storage.put("Бразилия", "Бразилиа");
        storage.put("Великобритания", "Лондон");
        storage.put("Венгрия", "Будапешт");
        storage.put("Вьетнам", "Ханой");
        storage.put("Германия", "Берлин");
        storage.put("Греция", "Афины");
        storage.put("Грузия", "Тбилиси");
        storage.put("Дания", "Копенгаген");
        storage.put("Египет", "Каир");
        storage.put("Израиль", "Иерусалим");
        storage.put("Индия", "Нью-Дели");
        storage.put("Индонезия", "Джакарта");
        storage.put("Ирландия", "Дублин");
        storage.put("Исландия", "Рейкьявик");
        storage.put("Испания", "Мадрид");
        storage.put("Италия", "Рим");
        storage.put("Казахстан", "Астана");
        storage.put("Канада", "Оттава");
        storage.put("Кения", "Найроби");
        storage.put("Китай", "Пекин");
        storage.put("Колумбия", "Богота");
        storage.put("Куба", "Гавана");
        storage.put("Латвия", "Рига");
        storage.put("Литва", "Вильнюс");
        storage.put("Малайзия", "Куала-Лумпур");
        storage.put("Мексика", "Мехико");
        storage.put("Нидерланды", "Амстердам");
        storage.put("Новая Зеландия", "Веллингтон");
        storage.put("Норвегия", "Осло");
        storage.put("Перу", "Лима");
        storage.put("Польша", "Варшава");
        storage.put("Португалия", "Лиссабон");
        storage.put("Саудовская Аравия", "Эр-Рияд");
        storage.put("США", "Вашингтон");
        storage.put("Таиланд", "Бангкок");
        storage.put("Турция", "Анкара");
        storage.put("Филиппины", "Манила");
        storage.put("Финляндия", "Хельсинки");
        storage.put("Франция", "Париж");
        storage.put("Чехия", "Прага");
        storage.put("Чили", "Сантьяго");
        storage.put("Швейцария", "Берн");
        storage.put("Швеция", "Стокгольм");
        storage.put("Южная Корея", "Сеул");
        storage.put("Япония", "Токио");
    }
}
