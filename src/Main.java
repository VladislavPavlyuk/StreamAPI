
import stream.models.Food;
import stream.models.RandomNumbers;
import utils.DeviceFactory;
import utils.FoodFactory;
import utils.ProjectorFactory;
import utils.RandomNumbersFactory;

public class Main {
    public static void main(String[] args) {

        RandomNumbers randomNumbers = new RandomNumbers(100);
        randomNumbers.print();
        
        System.out.println("\n=== RandomNumbersFactory ===");
        System.out.println("Случайные числа для тестирования:");
        for (int i = 0; i < 10; i++) {
            System.out.print(RandomNumbersFactory.generateRandomNumber() + " ");
        }
        System.out.println("\n\nСоздание RandomNumbers через фабрику:");
        RandomNumbers testNumbers = RandomNumbersFactory.createRandomNumbers(50);
        testNumbers.print();

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
        
        System.out.println("\n=== ProjectorFactory - Случайные проекторы ===");
        System.out.println("Случайные проекторы:");
        for (int i = 0; i < 3; i++) {
            System.out.println("Проектор " + (i + 1) + ": " + projects.createRandomProjector());
        }

    }
}
