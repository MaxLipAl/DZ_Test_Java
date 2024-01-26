import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    // Метод, который добавляет номера в книгу
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }

    // Метод, который печатает список контактов
    public static void printBook(Map<String, ArrayList<Integer>> map) {
        // Создаем список записей, чтобы отсортировать их
        List<Map.Entry<String, ArrayList<Integer>>> sortedEntries = new ArrayList<>(map.entrySet());

        // Сортируем записи по убыванию количества телефонов
        sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));

        // Печатаем отсортированный список
        for (var entry : sortedEntries) {
            StringBuilder phones = new StringBuilder();

            // Печать телефонов с запятыми между ними
            for (int el : entry.getValue()) {
                phones.append(el).append(", ");
            }

            // Убираем последнюю запятую и выводим запись
            String result = phones.length() > 2 ? phones.substring(0, phones.length() - 2) : phones.toString();
            System.out.printf("%s: %s \n", entry.getKey(), result);
        }
    }

    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
        addNumber("Ivanov", 56854, bookPhone);
        addNumber("Ivanov", 1957611, bookPhone);
        addNumber("Petrov", 3322556, bookPhone);
        addNumber("Sidorov", 85963, bookPhone);
        addNumber("Ivanov", 987456, bookPhone);
        addNumber("Petrov", 85214, bookPhone);
        printBook(bookPhone);
    }
}