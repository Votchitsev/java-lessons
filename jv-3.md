# Коллекции в Java: List и Map

## Общее понимание коллекций

Коллекции в Java — это классы, которые хранят и обрабатывают группы объектов. Самые популярные из них: `List`, `Set`, `Map`, `Queue`. В данной лекции рассмотрим `List` и `Map`.

---

## List

`List` — упорядоченная коллекция, где каждый элемент имеет свой индекс.

### Популярные имплементации:
- `ArrayList` — быстрый доступ по индексу
- `LinkedList` — быстрое добавление/удаление в середине

### Пример:
```java
import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

---

## Map

`Map` хранит пары "ключ-значение". Ключи должны быть уникальными.

### Популярные имплементации:
- `HashMap` — быстрое хранение и поиск
- `TreeMap` — хранит ключи в отсортированном порядке
- `LinkedHashMap` — сохраняет порядок добавления

### Пример:
```java
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);

        for (String name : ages.keySet()) {
            System.out.println(name + " is " + ages.get(name) + " years old.");
        }
    }
}
```

---

## Практические задания

### Задание 1:
Создайте список `ArrayList<String>` и добавьте туда 5 любимых фильмов. Выведите их в консоль, пронумеровав каждый.

### Задание 2:
Создайте `HashMap<String, String>`, где ключ — имя друга, а значение — его любимое блюдо. Выведите пары в формате: "Имя любит блюдо".

### Задание 3:
Напишите программу, которая на вход принимает список оценок студентов (`List<Integer>`), и выводит среднее значение, максимальную и минимальную оценку.

---

## Заключение

`List` и `Map` — основа для работы с коллекциями в Java. Умение их использовать критично в мобильной разработке, особенно при работе с списками, конфигурациями, JSON или базами данных.

