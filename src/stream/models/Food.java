package stream.models;

import java.util.*;

public class Food {
    private final List<String> products;
    
    public Food(List<String> products) {
        this.products = products;
    }

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
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nВведите название продукта для подсчета, например Молоко: ");
            String inputProduct = scanner.nextLine();
            if (inputProduct.isEmpty()) {
                System.out.println("Empty input provided, using default: Молоко");
                showAllRepeating("Молоко");
                return;
            }
            showAllRepeating(inputProduct);
        } catch (NoSuchElementException e) {
            System.out.println("\nInput unavailable, using default: Молоко");
            showAllRepeating("Молоко");
        }
    }
    
    public void showAllRepeating(String inputProduct) {        // Посчитать сколько раз встречается продукт
        long count = products.stream()
                .filter(product -> product.equalsIgnoreCase(inputProduct))
                .count();
        System.out.println("Продукт \"" + inputProduct + "\" встречается " + count + " раз.");
    }
    public void showAllStaredOn() {        // Показать все продукты, которые начинаются на заданную букву
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("\nВведите начальную букву: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Empty input provided, using default: М");
                showAllStaredOn('М');
                return;
            }
            showAllStaredOn(input.charAt(0));
        } catch (NoSuchElementException e) {
            System.out.println("\nInput unavailable, using default: М");
            showAllStaredOn('М');
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("\nEmpty input provided, using default: М");
            showAllStaredOn('М');
        }
    }
    
    public void showAllStaredOn(char initial) {        // Показать все продукты, которые начинаются на заданную букву
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
