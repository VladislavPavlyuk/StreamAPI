package stream.models.utils;

import stream.models.Device;

import java.util.Arrays;
import java.util.List;

public class DeviceFactory {


    protected List<Device> devices = Arrays.asList(
            new Device("Device1", 2020, 299.99, "Red", "Phone"),
            new Device("Device2", 2019, 399.99, "Blue", "Tablet"),
            new Device("Device3", 2021, 499.99, "Red", "Laptop"),
            new Device("Device4", 2018, 199.99, "Green", "Phone"),
            new Device("Device5", 2020, 299.99, "Blue", "Laptop")
    );

    public void showAll() {    // Показать все устройства
        System.out.println("All devices:");
        devices.forEach(System.out::println);
    }

    public void showAllByColor(String color) {    // Показать все устройства заданного цвета
        //String color = "Red";
        System.out.println("\nDevices with color " + color + ":");
        devices.stream()
                .filter(device -> device.getColor().equalsIgnoreCase(color))
                .forEach(System.out::println);
    }

    public void showAllByYear(int year) {    // Показать все устройства заданного года выпуска
        //int year = 2020;
        System.out.println("\nDevices from year " + year + ":");
        devices.stream()
                .filter(device -> device.getYear() == year)
                .forEach(System.out::println);
    }

    public void showAllByExpensiveThan(double price) {     // Показать все устройства дороже заданной цены
        //double price = 300.00;
        System.out.println("\nDevices more expensive than " + price + ":");
        devices.stream()
                .filter(device -> device.getPrice() > price)
                .forEach(System.out::println);
    }

    public void showAllByType(String type) {     // Показать все устройства заданного типа
        //String type = "Laptop";
        System.out.println("\nDevices of type " + type + ":");
        devices.stream()
                .filter(device -> device.getType().equalsIgnoreCase(type))
                .forEach(System.out::println);
    }

    public void showAllByYears(int startYear, int endYear) {       // Показать все устройства, чей год выпуска находится в указанном диапазоне
        //int startYear = 2019;
        //int endYear = 2021;
        System.out.println("\nDevices from year range " + startYear + " to " + endYear + ":");
        devices.stream()
                .filter(device -> device.getYear() >= startYear && device.getYear() <= endYear)
                .forEach(System.out::println);
    }
}
