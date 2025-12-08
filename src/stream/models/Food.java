package stream.models;

import java.util.*;

public class Food {
    private final List<FoodCategory> products;
    
    public Food(List<FoodCategory> products) {
        this.products = products;
    }

    public void showAll() {        // Показать все продукты
        System.out.println("Все продукты:");
        products.forEach(System.out::println);
    }

    public void showAll(String inputProduct) {        // Посчитать сколько раз встречается продукт
        long count = products.stream()
                .filter(product -> product.getTitle().equalsIgnoreCase(inputProduct))
                .count();
        System.out.println("\n\nПродукт \"" + inputProduct + "\" встречается " + count + " раз.");
    }

    public void showAllLessThan(int n) {        // Показать все продукты с названием меньше пяти символов
        System.out.println("\n\nПродукты с названием меньше " + n + " символов:");
        products.stream()
                .filter(product -> product.getTitle().length() < n)
                .forEach(System.out::println);
    }

    public void showAllStaredOn() {        // Показать все продукты, которые начинаются на заданную букву
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\n\nВведите начальную букву: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("\n\nEmpty input provided, using default: М");
                showAllStaredOn('М');
                return;
            }
            showAllStaredOn(input.charAt(0));
        } catch (NoSuchElementException e) {
            System.out.println("\n\nInput unavailable, using default: М");
            showAllStaredOn('М');
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\n\nEmpty input provided, using default: М");
            showAllStaredOn('М');
        }
    }
    
    public void showAllStaredOn(char initial) {        // Показать все продукты, которые начинаются на заданную букву
        System.out.println("\n\nПродукты, начинающиеся на букву \"" + initial + "\":");
        products.stream()
                .filter(product -> product.getTitle().charAt(0) == initial)
                .forEach(System.out::println);
    }

    public void showAllMilk(){
        // Показать все продукты из категории «Молочные»
        System.out.println("\nПродукты из категории «Молочные»:");
        products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Молочные"))
                .forEach(System.out::println);
    }
}
