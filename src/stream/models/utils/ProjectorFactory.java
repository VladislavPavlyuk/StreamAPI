package stream.models.utils;
import java.util.*;
import java.util.stream.Collectors;

import stream.models.Projector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public  class ProjectorFactory {

        List<Projector> projectors = Arrays.asList(
                new Projector("Projector A", 2023, 500.0, "Manufacturer X"),
                new Projector("Projector B", 2024, 700.0, "Manufacturer Y"),
                new Projector("Projector C", 2023, 600.0, "Manufacturer X"),
                new Projector("Projector D", 2022, 800.0, "Manufacturer Z")
        );

        public void showAll() {  // Показать все проекторы
                System.out.println("Все проекторы:");
                projectors.forEach(System.out::println);
        }
        public void showAllByManufacturer(String manufacturer) {  // Показать все проекторы одного производителя
               // String manufacturer = "Manufacturer X";
                System.out.println("\nПроекторы производителя " + manufacturer + ":");
                projectors.stream()
                        .filter(p -> p.getManufacturer().equals(manufacturer))
                        .forEach(System.out::println);
        }

        public void showAllByYear(int currentYear) {         // Показать все проекторы текущего года
                //int currentYear = 2024;
                System.out.println("\nПроекторы текущего года:");
                projectors.stream()
                        .filter(p -> p.getYear() == currentYear)
                        .forEach(System.out::println);
        }

        public void showAllExpensiveThan(double priceThreshold) {  // Показать все проекторы дороже заданной цены
                //double priceThreshold = 600.0;
                System.out.println("\nПроекторы дороже " + priceThreshold + ":");
                projectors.stream()
                        .filter(p -> p.getPrice() > priceThreshold)
                        .forEach(System.out::println);
        }

        public void showAllSortedByPriceAccent() {  // Показать все проекторы, отсортированные по цене по возрастанию
                System.out.println("\nПроекторы, отсортированные по цене по возрастанию:");
                projectors.stream()
                        .sorted(Comparator.comparingDouble(Projector::getPrice))
                        .forEach(System.out::println);
        }
        public void showAllSortedByPriceDeccent() {                 // Показать все проекторы, отсортированные по цене по убыванию
                System.out.println("\nПроекторы, отсортированные по цене по убыванию:");
                projectors.stream()
                        .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                        .forEach(System.out::println);
        }

        public void showAllSortedByYearAccent() {  // Показать все проекторы, отсортированные по году выпуска по возрастанию
                System.out.println("\nПроекторы, отсортированные по году выпуска по возрастанию:");
                projectors.stream()
                        .sorted(Comparator.comparingInt(Projector::getYear))
                        .forEach(System.out::println);
        }

        public void showAllSortedByYearDescent() {         // Показать все проекторы, отсортированные по году выпуска по убыванию
                System.out.println("\nПроекторы, отсортированные по году выпуска по убыванию:");
                projectors.stream()
                        .sorted(Comparator.comparingInt(Projector::getYear).reversed())
                        .forEach(System.out::println);
        }
}
