package utils;

import stream.models.Device;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DeviceFactory {

    private static final Random random = new Random();

    protected List<Device> devices = Arrays.asList(
            new Device("Device1", 2020, 299.99, "Red", "Phone"),
            new Device("Device2", 2019, 399.99, "Blue", "Tablet"),
            new Device("Device3", 2021, 499.99, "Red", "Laptop"),
            new Device("Device4", 2018, 199.99, "Green", "Phone"),
            new Device("Device5", 2020, 299.99, "Blue", "Laptop"),
            new Device("Device6", 2022, 599.99, "Black", "Phone"),
            new Device("Device7", 2021, 349.99, "White", "Tablet"),
            new Device("Device8", 2020, 449.99, "Silver", "Laptop"),
            new Device("Device9", 2019, 249.99, "Red", "Phone"),
            new Device("Device10", 2023, 699.99, "Blue", "Tablet"),
            new Device("Device11", 2022, 549.99, "Green", "Laptop"),
            new Device("Device12", 2021, 379.99, "Black", "Phone"),
            new Device("Device13", 2020, 429.99, "White", "Tablet"),
            new Device("Device14", 2019, 319.99, "Silver", "Laptop"),
            new Device("Device15", 2023, 649.99, "Red", "Phone"),
            new Device("Device16", 2022, 479.99, "Blue", "Tablet"),
            new Device("Device17", 2021, 389.99, "Green", "Laptop"),
            new Device("Device18", 2020, 269.99, "Black", "Phone"),
            new Device("Device19", 2019, 359.99, "White", "Tablet"),
            new Device("Device20", 2023, 579.99, "Silver", "Laptop"),
            new Device("Device21", 2022, 419.99, "Red", "Phone"),
            new Device("Device22", 2021, 339.99, "Blue", "Tablet"),
            new Device("Device23", 2020, 459.99, "Green", "Laptop"),
            new Device("Device24", 2019, 289.99, "Black", "Phone"),
            new Device("Device25", 2023, 629.99, "White", "Tablet"),
            new Device("Device26", 2022, 369.99, "Silver", "Laptop"),
            new Device("Device27", 2021, 409.99, "Red", "Phone"),
            new Device("Device28", 2020, 319.99, "Blue", "Tablet"),
            new Device("Device29", 2019, 469.99, "Green", "Laptop"),
            new Device("Device30", 2023, 559.99, "Black", "Phone"),
            new Device("Device31", 2022, 349.99, "White", "Tablet"),
            new Device("Device32", 2021, 439.99, "Silver", "Laptop"),
            new Device("Device33", 2020, 279.99, "Red", "Phone"),
            new Device("Device34", 2019, 389.99, "Blue", "Tablet"),
            new Device("Device35", 2023, 609.99, "Green", "Laptop"),
            new Device("Device36", 2022, 329.99, "Black", "Phone"),
            new Device("Device37", 2021, 419.99, "White", "Tablet"),
            new Device("Device38", 2020, 359.99, "Silver", "Laptop"),
            new Device("Device39", 2019, 299.99, "Red", "Phone"),
            new Device("Device40", 2023, 539.99, "Blue", "Tablet"),
            new Device("Device41", 2022, 379.99, "Green", "Laptop"),
            new Device("Device42", 2021, 309.99, "Black", "Phone"),
            new Device("Device43", 2020, 449.99, "White", "Tablet"),
            new Device("Device44", 2019, 339.99, "Silver", "Laptop"),
            new Device("Device45", 2023, 589.99, "Red", "Phone"),
            new Device("Device46", 2022, 399.99, "Blue", "Tablet"),
            new Device("Device47", 2021, 429.99, "Green", "Laptop"),
            new Device("Device48", 2020, 289.99, "Black", "Phone"),
            new Device("Device49", 2019, 369.99, "White", "Tablet"),
            new Device("Device50", 2023, 619.99, "Silver", "Laptop")
    );

    /**
     * Создает случайное устройство из набора
     * @return случайное устройство
     */
    public Device createRandomDevice() {
        return devices.get(random.nextInt(devices.size()));
    }

    /**
     * Статический метод для создания случайного устройства
     * @return случайное устройство
     */
    public static Device getRandomDevice() {
        DeviceFactory factory = new DeviceFactory();
        return factory.createRandomDevice();
    }

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
