package stream.models;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Projectors {
    private final List<Projector> projectors;
    
    public Projectors(List<Projector> projectors) {
        this.projectors = projectors;
    }

    private void printLine(int length){
        for (int i = 0; i < length; i++){
            System.out.print("-");
        }
        System.out.println();
    }
    private void print(List<Projector> projectorList) {
        if (projectorList.isEmpty()) {
            System.out.println("No projectors found.");
            return;
        }

        System.out.printf("%-18s %-6s %-10s %-20s%n", "Name", "Year", "Price", "Manufacturer");
        printLine(70);
        for (Projector p : projectorList) {
            System.out.printf("%-18s %-6d %-10.2f %-20s%n", 
                    p.getName(), p.getYear(), p.getPrice(), p.getManufacturer());
        }

        printLine(70);
    }
    
    public void showAll() {  // Show all projectors
        System.out.println("All projectors:");
        print(projectors);
    }
    
    public void showAllByManufacturer(String manufacturer) {  // Show all projectors of one manufacturer
        System.out.println("\nProjectors from manufacturer " + manufacturer + ":");
        List<Projector> filtered = projectors.stream()
                .filter(p -> p.getManufacturer().equals(manufacturer))
                .collect(Collectors.toList());
        print(filtered);
    }

    public void showAllByYear(int currentYear) {         // Show all projectors of current year
        System.out.println("\nProjectors from year " + currentYear + ":");
        List<Projector> filtered = projectors.stream()
                .filter(p -> p.getYear() == currentYear)
                .collect(Collectors.toList());
        print(filtered);
    }

    public void showAllExpensiveThan(double priceThreshold) {  // Show all projectors more expensive than specified price
        System.out.println("\nProjectors more expensive than " + priceThreshold + ":");
        List<Projector> filtered = projectors.stream()
                .filter(p -> p.getPrice() > priceThreshold)
                .collect(Collectors.toList());
        print(filtered);
    }

    public void showAllSortedByPriceAccent() {  // Show all projectors sorted by price ascending
        System.out.println("\nProjectors sorted by price ascending:");
        List<Projector> sorted = projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice))
                .collect(Collectors.toList());
        print(sorted);
    }
    
    public void showAllSortedByPriceDeccent() {                 // Show all projectors sorted by price descending
        System.out.println("\nProjectors sorted by price descending:");
        List<Projector> sorted = projectors.stream()
                .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                .collect(Collectors.toList());
        print(sorted);
    }

    public void showAllSortedByYearAccent() {  // Show all projectors sorted by release year ascending
        System.out.println("\nProjectors sorted by release year ascending:");
        List<Projector> sorted = projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYear))
                .collect(Collectors.toList());
        print(sorted);
    }

    public void showAllSortedByYearDescent() {         // Show all projectors sorted by release year descending
        System.out.println("\nProjectors sorted by release year descending:");
        List<Projector> sorted = projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getYear).reversed())
                .collect(Collectors.toList());
        print(sorted);
    }
    
    public Projector getRandomProjector() {
        if (projectors.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return projectors.get(random.nextInt(projectors.size()));
    }
}
