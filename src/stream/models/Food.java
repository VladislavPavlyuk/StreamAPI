package stream.models;

import java.util.*;

public class Food {
    public  Food() {}
        List<String> products = Arrays.asList(
                "Молоко", "Хлеб", "Сыр", "Яблоко", "Молоко", "Кефир", "Масло",
                "Творог", "Йогурт", "Сметана", "Колбаса", "Мясо", "Рыба", "Курица",
                "Картофель", "Морковь", "Лук", "Помидор", "Огурец", "Капуста",
                "Бананы", "Апельсины", "Груши", "Виноград", "Клубника", "Малина",
                "Рис", "Гречка", "Макароны", "Овсянка", "Манка", "Перловка",
                "Сахар", "Соль", "Перец", "Мука", "Дрожжи", "Яйца",
                "Мед", "Орехи", "Изюм", "Чернослив", "Финики", "Инжир",
                "Чай", "Кофе", "Сок", "Вода", "Лимонад", "Компот", "Квас"
        );

    public void showAll() {        // Show all products
        System.out.println("All products:");
        int columns = 5;
        for (int i = 0; i < products.size(); i++) {
            System.out.printf("%-15s", products.get(i));
            if ((i + 1) % columns == 0 || i == products.size() - 1) {
                System.out.println();
            }
        }
    }

    public void showAllLessFive() {        // Show all products with name less than five characters
        System.out.println("\nProducts with name less than five characters:");
        products.stream()
                .filter(product -> product.length() < 5)
                .forEach(System.out::println);
    }

    public void showAllRepeating() {        // Count how many times a product appears, whose name was entered by user
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nEnter product name to count, for example Молоко: ");
            String inputProduct = scanner.nextLine();
            showAllRepeating(inputProduct);
        } catch (NoSuchElementException e) {
            // If input is unavailable, use default value
            System.out.println("\nInput unavailable, using default value: Молоко");
            showAllRepeating("Молоко");
        }
    }
    
    public void showAllRepeating(String inputProduct) {        // Count how many times a product appears
        long count = products.stream()
                .filter(product -> product.equalsIgnoreCase(inputProduct))
                .count();
        System.out.println("Product \"" + inputProduct + "\" appears " + count + " times.");
    }
    public void showAllStaredOn() {        // Show all products that start with a given letter
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nEnter initial letter: ");
            char initial = scanner.nextLine().charAt(0);
            showAllStaredOn(initial);
        } catch (NoSuchElementException e) {
            // If input is unavailable, use default value
            System.out.println("\nInput unavailable, using default value: М");
            showAllStaredOn('М');
        }
    }
    
    public void showAllStaredOn(char initial) {        // Show all products that start with a given letter
        System.out.println("Products starting with letter \"" + initial + "\":");
        products.stream()
                .filter(product -> product.charAt(0) == initial)
                .forEach(System.out::println);
    }

    public void showAllMilk(){
        // Show all products from "Молоко" category
        System.out.println("\nProducts from \"Молоко\" category:");
        products.stream()
                .filter(product -> product.equalsIgnoreCase("Молоко"))
                .forEach(System.out::println);
    }
}

