package stream.models;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foods {
    private final List<FoodCategory> products;
    
    public Foods(List<FoodCategory> products) {
        this.products = products;
    }

    private void print(String header, Stream<FoodCategory> items) {
        System.out.println(header);
        
        List<FoodCategory> itemsList = items.collect(Collectors.toList());
        if (itemsList.isEmpty()) {
            System.out.println("Нет данных для отображения.");
            return;
        }
        
        int titleWidth = Math.max(8, itemsList.stream()
                .mapToInt(item -> item.getTitle().length())
                .max()
                .orElse(8));
        
        int categoryWidth = Math.max(10, itemsList.stream()
                .mapToInt(item -> item.getCategory().length())
                .max()
                .orElse(10));
        
        String format = "| %-" + titleWidth + "s | %-" + categoryWidth + "s |%n";
        String separator = "+" + "-".repeat(titleWidth + 2) + "+" + "-".repeat(categoryWidth + 2) + "+";
        
        System.out.println(separator);
        System.out.printf(format, "Продукт", "Категория");
        System.out.println(separator);
        
        for (FoodCategory item : itemsList) {
            System.out.printf(format, item.getTitle(), item.getCategory());
        }
        
        System.out.println(separator);
    }

    private void print(String message) {
        System.out.println(message);
    }

    public void showAll() {        // Показать все продукты
        print("Все продукты:", products.stream());
    }

    public void showAll(String inputProduct) {        // Посчитать сколько раз встречается продукт
        long count = products.stream()
                .filter(product -> product.getTitle().equalsIgnoreCase(inputProduct))
                .count();
        print("\n\nПродукт \"" + inputProduct + "\" встречается " + count + " раз.");
    }

    public void showAllLessThan(int n) {        // Показать все продукты с названием меньше пяти символов
        print("\n\nПродукты с названием меньше " + n + " символов:",
                products.stream()
                        .filter(product -> product.getTitle().length() < n));
    }

    public void showAllStaredOn(char initial) {        // Показать все продукты, которые начинаются на заданную букву
        print("\n\nПродукты, начинающиеся на букву \"" + initial + "\":",
                products.stream()
                        .filter(product -> product.getTitle().charAt(0) == initial));
    }

    public <string> void showAllfromCategory(string category){

        print("\nПродукты из категории " + category + " : ",
                products.stream()
                        .filter(product -> product.getCategory().equalsIgnoreCase("category")));
    }
}
