
import stream.models.Devices;
import stream.models.Foods;
import stream.models.Projectors;
import stream.models.RandomNumbers;
import utils.DeviceFactory;
import utils.FoodFactory;
import utils.ProjectorFactory;
import utils.RandomNumbersFactory;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\nCreating Random Numbers via factory:");
        RandomNumbers testNumbers = RandomNumbersFactory.createRandomNumbers(50);
        testNumbers.print();

        System.out.println("\n\nCreating Random Foods via factory:");
        Foods foods = FoodFactory.createFood(50);
        foods.showAll();
        foods.showAllLessThan(5);
        foods.showAll("Sausage");
        foods.showAllStaredOn('B');
        foods.showAllfromCategory("Dairy");

        System.out.println("\n\nCreating Random Devices via factory:");
        Devices devices = DeviceFactory.createDevices(50);
        devices.showAll();
        devices.showAllByColor("Red");
        devices.showAllByYear(2020);
        devices.showAllByExpensiveThan(200);
        devices.showAllByType("Phone");
        devices.showAllByYears(2019,2020);

        System.out.println("\n\nCreating Random Projectors via Factory :");
        Projectors projectors = ProjectorFactory.createProjectors();
        projectors.showAll();
        projectors.showAllByManufacturer("Sony");
        projectors.showAllByYear(2022);
        projectors.showAllExpensiveThan(600);
        projectors.showAllSortedByPriceAccent();
        projectors.showAllSortedByPriceDeccent();
        projectors.showAllSortedByYearAccent();
        projectors.showAllSortedByYearDescent();
        
    }
}
