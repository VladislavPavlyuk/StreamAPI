
import stream.models.Food;
import stream.models.RandomNumbers;
import utils.DeviceFactory;
import utils.FoodFactory;
import utils.ProjectorFactory;
import utils.RandomNumbersFactory;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n\nCreating RandomNumbers via factory:");
        RandomNumbers testNumbers = RandomNumbersFactory.createRandomNumbers(50);
        testNumbers.print();

        Food food = new Food();
        food.showAll();
        food.showAllLessFive();
        food.showAllStaredOn();
        food.showAllRepeating();
        food.showAllMilk();

        System.out.println("\n\n");

        System.out.println("\n\n\n=== FoodFactory ===");
        System.out.println("Random products:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Product " + (i + 1) + ": " + FoodFactory.getRandomProduct());
        }

        DeviceFactory devices = new DeviceFactory();
        devices.showAll();
        devices.showAllByYear(2020);
        devices.showAllByColor("Red");
        devices.showAllByExpensiveThan(200);
        devices.showAllByType("Phone");
        devices.showAllByYears(2019,2020);
        
        System.out.println("\n=== DeviceFactory - Random Devices ===");
        System.out.println("Random devices:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Device " + (i + 1) + ": " + devices.createRandomDevice());
        }

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

    }
}
