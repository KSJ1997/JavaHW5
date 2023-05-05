// Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, 
// Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, 
// Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. 
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. 
// Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.

import java.util.*;

public class HW2 {
    public static void main(String[] args) {
        List<String> employees = Arrays.asList(
                "Иван Иванов", "Светлана Петрова", "Кристина Белова",
                "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                "Мария Федорова", "Марина Светлова", "Мария Савина",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова",
                "Иван Мечников", "Петр Петин", "Иван Ежов"
        );

        Map<String, Integer> nameCounts = new HashMap<>();

        for (String employee : employees) {
            String name = employee.split(" ")[0];
            nameCounts.put(name, nameCounts.getOrDefault(name, 0) + 1);
        }

        Map<String, Integer> sortedNameCounts = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return Integer.compare(nameCounts.get(s2), nameCounts.get(s1));
            }
        });
        sortedNameCounts.putAll(nameCounts);

        for (String name : sortedNameCounts.keySet()) {
            int count = sortedNameCounts.get(name);
            if (count > 1) {
                System.out.println(name + " - " + count);
            }
        }
    }
}
