import java.util.*;

public class Main {

    public static void main(String[] args) {
        runApp();
    }

    static void runApp() {
        doTask1();
        doTask2();
    }

    static void doTask1() {

        int peachCount = 0;
        int appleCount = 0;
        int apricotCount = 0;
        int pearCount = 0;
        int mandarinCount = 0;
        int orangeCount = 0;

        List<String> simpleWords = Arrays.asList(
                "Яблоко", "Мандарин", "Апельсин", "Абрикос", "Апельсин", "Мандарин", "Груша", "Абрикос", "Груша", "Персик", "Груша", "Мандарин", "Персик", "Мандарин", "Мандарин", "Абрикос", "Яблоко", "Апельсин", "Яблоко", "Яблоко"
        );

        Set<String> uniqueWords = new HashSet<String>(simpleWords);

        System.out.println("Массив слов");
        System.out.println(simpleWords.toString());
        System.out.println("Уникальные слова");
        System.out.println(uniqueWords.toString());
        System.out.println("Количество каждого слова");

        Iterator<String> iter = simpleWords.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            if (str.equals("Яблоко")) {
                appleCount++;
            } else if (str.equals("Мандарин")) {
                mandarinCount++;
            } else if (str.equals("Апельсин")) {
                orangeCount++;
            } else if (str.equals("Абрикос")) {
                apricotCount++;
            } else if (str.equals("Груша")) {
                pearCount++;
            } else {
                peachCount++;
            }
        }
        System.out.println("Количество яблок: " + appleCount);
        System.out.println("Количество мандаринов: " + mandarinCount);
        System.out.println("Количество апельсинов: " + orangeCount);
        System.out.println("Количество абрикосов: " + apricotCount);
        System.out.println("Количество груш: " + pearCount);
        System.out.println("Количество персиков: " + peachCount);

        System.out.println();
        System.out.println();
    }

    static void doTask2() {
        System.out.println("Создание справочника");
        PhoneBook phonebook = new PhoneBook();
        System.out.println("-----------------");

        System.out.println("Добавление данных");
        phonebook.add("Терёхин", "12354");
        phonebook.add("Терёхин", "1231886");
        phonebook.add("Барсуков", "557769");
        phonebook.add("Пирожков", "457664");
        phonebook.add("Терёхин", "485345378");
        System.out.println("-----------------");

        System.out.println("Получение номеров:");
        System.out.println("Терёхин");
        System.out.println(phonebook.get("Терёхин"));
        System.out.println("Барсуков");
        System.out.println(phonebook.get("Барсуков"));
        System.out.println("Пирожков");
        System.out.println(phonebook.get("Пирожков"));
        System.out.println("-----------------");

        System.out.println("Проверка на отсутствие записи");
        System.out.println("Кузнецов");
        System.out.println(phonebook.get("Кузнецов"));
        System.out.println("-----------------");

        System.out.println("Запись нового номера");
        phonebook.add("Иванов", "5578963");
        System.out.println("Иванов");
        System.out.println(phonebook.get("Иванов"));
    }
}