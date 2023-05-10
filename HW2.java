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

        Map<Integer, List<String>> countToNames = new TreeMap<>(Collections.reverseOrder());
        for (String name : nameCounts.keySet()) {
            int count = nameCounts.get(name);
            if (count > 1) {
                if (!countToNames.containsKey(count)) {
                    countToNames.put(count, new ArrayList<>());
                }
                countToNames.get(count).add(name);
            }
        }

        for (int count : countToNames.keySet()) {
            List<String> names = countToNames.get(count);
            for (String name : names) {
                System.out.println(name + " - " + count);
            }
        }
    }
}
