package utils;

import stream.models.Projector;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public  class ProjectorFactory {

        private static final Random random = new Random();

        List<Projector> projectors = Arrays.asList(
                new Projector("Projector A", 2023, 500.0, "Manufacturer X"),
                new Projector("Projector B", 2024, 700.0, "Manufacturer Y"),
                new Projector("Projector C", 2023, 600.0, "Manufacturer X"),
                new Projector("Projector D", 2022, 800.0, "Manufacturer Z"),
                new Projector("Projector E", 2024, 550.0, "Manufacturer Y"),
                new Projector("Projector F", 2023, 650.0, "Manufacturer X"),
                new Projector("Projector G", 2022, 750.0, "Manufacturer Z"),
                new Projector("Projector H", 2024, 520.0, "Manufacturer Y"),
                new Projector("Projector I", 2023, 580.0, "Manufacturer X"),
                new Projector("Projector J", 2022, 720.0, "Manufacturer Z"),
                new Projector("Projector K", 2024, 630.0, "Manufacturer Y"),
                new Projector("Projector L", 2023, 670.0, "Manufacturer X"),
                new Projector("Projector M", 2022, 680.0, "Manufacturer Z"),
                new Projector("Projector N", 2024, 540.0, "Manufacturer Y"),
                new Projector("Projector O", 2023, 590.0, "Manufacturer X"),
                new Projector("Projector P", 2022, 730.0, "Manufacturer Z"),
                new Projector("Projector Q", 2024, 560.0, "Manufacturer Y"),
                new Projector("Projector R", 2023, 640.0, "Manufacturer X"),
                new Projector("Projector S", 2022, 710.0, "Manufacturer Z"),
                new Projector("Projector T", 2024, 510.0, "Manufacturer Y"),
                new Projector("Projector U", 2023, 620.0, "Manufacturer X"),
                new Projector("Projector V", 2022, 740.0, "Manufacturer Z"),
                new Projector("Projector W", 2024, 530.0, "Manufacturer Y"),
                new Projector("Projector X", 2023, 660.0, "Manufacturer X"),
                new Projector("Projector Y", 2022, 690.0, "Manufacturer Z"),
                new Projector("Projector Z", 2024, 570.0, "Manufacturer Y"),
                new Projector("Projector AA", 2023, 610.0, "Manufacturer X"),
                new Projector("Projector BB", 2022, 760.0, "Manufacturer Z"),
                new Projector("Projector CC", 2024, 515.0, "Manufacturer Y"),
                new Projector("Projector DD", 2023, 635.0, "Manufacturer X"),
                new Projector("Projector EE", 2022, 725.0, "Manufacturer Z"),
                new Projector("Projector FF", 2024, 545.0, "Manufacturer Y"),
                new Projector("Projector GG", 2023, 585.0, "Manufacturer X"),
                new Projector("Projector HH", 2022, 715.0, "Manufacturer Z"),
                new Projector("Projector II", 2024, 555.0, "Manufacturer Y"),
                new Projector("Projector JJ", 2023, 625.0, "Manufacturer X"),
                new Projector("Projector KK", 2022, 735.0, "Manufacturer Z"),
                new Projector("Projector LL", 2024, 525.0, "Manufacturer Y"),
                new Projector("Projector MM", 2023, 645.0, "Manufacturer X"),
                new Projector("Projector NN", 2022, 745.0, "Manufacturer Z"),
                new Projector("Projector OO", 2024, 535.0, "Manufacturer Y"),
                new Projector("Projector PP", 2023, 655.0, "Manufacturer X"),
                new Projector("Projector QQ", 2022, 755.0, "Manufacturer Z"),
                new Projector("Projector RR", 2024, 575.0, "Manufacturer Y"),
                new Projector("Projector SS", 2023, 615.0, "Manufacturer X"),
                new Projector("Projector TT", 2022, 765.0, "Manufacturer Z"),
                new Projector("Projector UU", 2024, 505.0, "Manufacturer Y"),
                new Projector("Projector VV", 2023, 665.0, "Manufacturer X"),
                new Projector("Projector WW", 2022, 775.0, "Manufacturer Z"),
                new Projector("Projector XX", 2024, 495.0, "Manufacturer Y")
        );

        public void showAll() {  // Show all projectors
                System.out.println("All projectors:");
                System.out.printf("%-18s %-6s %-10s %-20s%n", "Name", "Year", "Price", "Manufacturer");
                System.out.println("----------------------------------------------------------------");
                int columns = 3;
                for (int i = 0; i < projectors.size(); i++) {
                        Projector p = projectors.get(i);
                        System.out.printf("%-18s %-6d %-10.2f %-20s  ", 
                                p.getName(), p.getYear(), p.getPrice(), p.getManufacturer());
                        if ((i + 1) % columns == 0 || i == projectors.size() - 1) {
                                System.out.println();
                        }
                }
        }
        public void showAllByManufacturer(String manufacturer) {  // Show all projectors of one manufacturer
               // String manufacturer = "Manufacturer X";
                System.out.println("\nProjectors from manufacturer " + manufacturer + ":");
                projectors.stream()
                        .filter(p -> p.getManufacturer().equals(manufacturer))
                        .forEach(System.out::println);
        }

        public void showAllByYear(int currentYear) {         // Show all projectors of current year
                //int currentYear = 2024;
                System.out.println("\nProjectors from year " + currentYear + ":");
                projectors.stream()
                        .filter(p -> p.getYear() == currentYear)
                        .forEach(System.out::println);
        }

        public void showAllExpensiveThan(double priceThreshold) {  // Show all projectors more expensive than specified price
                //double priceThreshold = 600.0;
                System.out.println("\nProjectors more expensive than " + priceThreshold + ":");
                projectors.stream()
                        .filter(p -> p.getPrice() > priceThreshold)
                        .forEach(System.out::println);
        }

        public void showAllSortedByPriceAccent() {  // Show all projectors sorted by price ascending
                System.out.println("\nProjectors sorted by price ascending:");
                projectors.stream()
                        .sorted(Comparator.comparingDouble(Projector::getPrice))
                        .forEach(System.out::println);
        }
        public void showAllSortedByPriceDeccent() {                 // Show all projectors sorted by price descending
                System.out.println("\nProjectors sorted by price descending:");
                projectors.stream()
                        .sorted(Comparator.comparingDouble(Projector::getPrice).reversed())
                        .forEach(System.out::println);
        }

        public void showAllSortedByYearAccent() {  // Show all projectors sorted by release year ascending
                System.out.println("\nProjectors sorted by release year ascending:");
                projectors.stream()
                        .sorted(Comparator.comparingInt(Projector::getYear))
                        .forEach(System.out::println);
        }

        public void showAllSortedByYearDescent() {         // Show all projectors sorted by release year descending
                System.out.println("\nProjectors sorted by release year descending:");
                projectors.stream()
                        .sorted(Comparator.comparingInt(Projector::getYear).reversed())
                        .forEach(System.out::println);
        }

        /**
         * Creates a random projector from the set
         * @return random projector
         */
        public Projector createRandomProjector() {
                return projectors.get(random.nextInt(projectors.size()));
        }

        /**
         * Static method for creating a random projector
         * @return random projector
         */
        public static Projector getRandomProjector() {
                ProjectorFactory factory = new ProjectorFactory();
                return factory.createRandomProjector();
        }
}
