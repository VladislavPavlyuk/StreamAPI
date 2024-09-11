package stream.models;

import java.util.*;
import java.util.stream.Collectors;

public class Food {
    public  Food() {}
        List<String> products = Arrays.asList("Молоко", "Хлеб", "Сыр", "Яблоко", "Молоко", "Кефир", "Масло");

    public void showAll() {        // Показать все продукты
        System.out.println("Все продукты:");
        products.forEach(System.out::println);
    }

    public void showAllLessFive() {        // Показать все продукты с названием меньше пяти символов
        System.out.println("\nПродукты с названием меньше пяти символов:");
        products.stream()
                .filter(product -> product.length() < 5)
                .forEach(System.out::println);
    }

    public void showAllRepeating() {        // Посчитать сколько раз встречается продукт, чье название ввёл пользователь
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nВведите название продукта для подсчета, например Молоко: ");
        String inputProduct = scanner.nextLine();
        long count = products.stream()
                .filter(product -> product.equalsIgnoreCase(inputProduct))
                .count();
        System.out.println("Продукт \"" + inputProduct + "\" встречается " + count + " раз.");
    }
    public void showAllStaredOn() {        // Показать все продукты, которые начинаются на заданную букву
        System.out.print("\nВведите начальную букву: ");
        Scanner scanner = new Scanner(System.in);
        char initial = scanner.nextLine().charAt(0);
        System.out.println("Продукты, начинающиеся на букву \"" + initial + "\":");
        products.stream()
                .filter(product -> product.charAt(0) == initial)
                .forEach(System.out::println);
    }

    public void showAllMilk(){
        // Показать все продукты из категории «Молоко»
        System.out.println("\nПродукты из категории «Молоко»:");
        products.stream()
                .filter(product -> product.equalsIgnoreCase("Молоко"))
                .forEach(System.out::println);
    }
}

