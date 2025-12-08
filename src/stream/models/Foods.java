package stream.models;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foods {
    private final List<Food> products;
    
    public Foods(List<Food> products) {
        this.products = products;
    }

    private void print(String header, Stream<Food> items) {
        System.out.println(header);
        
        List<Food> itemsList = items.collect(Collectors.toList());
        if (itemsList.isEmpty()) {
            System.out.println("No data to display.");
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
        System.out.printf(format, "Product", "Category");
        System.out.println(separator);
        
        for (Food item : itemsList) {
            System.out.printf(format, item.getTitle(), item.getCategory());
        }
        
        System.out.println(separator);
    }

    private void print(String message) {
        System.out.println(message);
    }

    public void showAll() {        // Show all products
        print("All products:", products.stream());
    }

    public void showAll(String inputProduct) {        // Count how many times a product appears
        long count = products.stream()
                .filter(product -> product.getTitle().equalsIgnoreCase(inputProduct))
                .count();
        print("\n\nProduct \"" + inputProduct + "\" appears " + count + " times.");
    }

    public void showAllLessThan(int n) {        // Show all products with name shorter than specified number of characters
        print("\n\nProducts with name shorter than " + n + " characters:",
                products.stream()
                        .filter(product -> product.getTitle().length() < n));
    }

    public void showAllStaredOn(char initial) {        // Show all products that start with the specified letter
        print("\n\nProducts starting with letter \"" + initial + "\":",
                products.stream()
                        .filter(product -> product.getTitle().charAt(0) == initial));
    }

    public void showAllfromCategory(String category){        // Show all products from the specified category
        print("\nProducts from category " + category + ":",
                products.stream()
                        .filter(product -> product.getCategory().equalsIgnoreCase(category)));
    }
}
