
import stream.models.Food;
import stream.models.RandomNumbers;
import utils.DeviceFactory;
import utils.FoodFactory;
import utils.ProjectorFactory;

public class Main {
    public static void main(String[] args) {

        RandomNumbers randomNumbers = new RandomNumbers(100);
        randomNumbers.print();

        Food food = new Food();
        food.showAll();
        food.showAllLessFive();
        food.showAllStaredOn();
        food.showAllRepeating();
        food.showAllMilk();

        System.out.println("\n=== FoodFactory ===");
        System.out.println("Случайные продукты:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Продукт " + (i + 1) + ": " + FoodFactory.getRandomProduct());
        }

        DeviceFactory devices = new DeviceFactory();
        devices.showAll();
        devices.showAllByYear(2020);
        devices.showAllByColor("Red");
        devices.showAllByExpensiveThan(200);
        devices.showAllByType("Phone");
        devices.showAllByYears(2019,2020);
        
        System.out.println("\n=== DeviceFactory - Случайные устройства ===");
        System.out.println("Случайные устройства:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Устройство " + (i + 1) + ": " + devices.createRandomDevice());
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

    }
}
