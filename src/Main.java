
import stream.models.Devices;
import stream.models.Foods;
import stream.models.RandomNumbers;
import utils.DeviceFactory;
import utils.FoodFactory;
import utils.ProjectorFactory;
import utils.RandomNumbersFactory;

import java.util.Scanner;

public class Main {
    
    private static void waitForEnter() {
        System.out.println("\nPress Enter to continue...");
        try (Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
        } catch (Exception e) {
            // If input is unavailable, just continue
        }
    }
    
    public static void main(String[] args) {
/*
        System.out.println("\n\nCreating Random Numbers via factory:");
        RandomNumbers testNumbers = RandomNumbersFactory.createRandomNumbers(50);
        testNumbers.print();
        waitForEnter();

        System.out.println("\n\nCreating Foods via factory:");
        Foods foods = FoodFactory.createFood(50);
        foods.showAll();
        foods.showAllLessThan(5);
        foods.showAll("Колбаса");
        foods.showAllStaredOn('Б');
        foods.showAllfromCategory("Молочные");
        waitForEnter();
*/

        System.out.println("\n\nCreating Devices via factory:");
        Devices devices = DeviceFactory.createDevices(50);
        devices.showAll();
        devices.showAllByColor("Red");
        devices.showAllByYear(2020);
        devices.showAllByExpensiveThan(200);
        devices.showAllByType("Phone");
        devices.showAllByYears(2019,2020);
        waitForEnter();
/*
        System.out.println("\n=== DeviceFactory - Random Devices ===");
        System.out.println("Random devices:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Device " + (i + 1) + ": " + DeviceFactory.createRandomDevice());
        }
        waitForEnter();

        ProjectorFactory projects = new ProjectorFactory();
        projects.showAll();
        projects.showAllByYear(2022);
        projects.showAllByManufacturer("Manufacturer X");
        projects.showAllExpensiveThan(600);
        projects.showAllSortedByYearDescent();
        projects.showAllSortedByYearAccent();
        projects.showAllSortedByPriceAccent();
        projects.showAllSortedByPriceDeccent();
        
        System.out.println("\n=== ProjectorFactory - Random Projectors ===");
        System.out.println("Random projectors:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Projector " + (i + 1) + ": " + projects.createRandomProjector());
        }
        waitForEnter();
*/
    }
}
