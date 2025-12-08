package utils;

import stream.models.Device;
import stream.models.Devices;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DeviceFactory {

    private static final Random random = new Random();

    private static final List<Device> deviceTemplates = Arrays.asList(
            new Device("iPhone 13", 2021, 799.99, "Blue", "Phone"),
            new Device("Samsung Galaxy S21", 2021, 699.99, "Black", "Phone"),
            new Device("MacBook Pro 16", 2021, 2499.99, "Silver", "Laptop"),
            new Device("iPad Air", 2022, 599.99, "White", "Tablet"),
            new Device("Xiaomi Mi 11", 2021, 499.99, "Blue", "Phone"),
            new Device("Dell XPS 13", 2022, 1299.99, "Silver", "Laptop"),
            new Device("Samsung Galaxy Tab S8", 2022, 699.99, "Black", "Tablet"),
            new Device("Huawei P50 Pro", 2021, 899.99, "White", "Phone"),
            new Device("HP Spectre x360", 2023, 1399.99, "Silver", "Laptop"),
            new Device("iPad Pro 12.9", 2022, 1099.99, "White", "Tablet"),
            new Device("OnePlus 9 Pro", 2021, 729.99, "Black", "Phone"),
            new Device("Lenovo ThinkPad X1", 2022, 1599.99, "Black", "Laptop"),
            new Device("Microsoft Surface Pro 8", 2021, 999.99, "Silver", "Tablet"),
            new Device("Google Pixel 6", 2021, 599.99, "White", "Phone"),
            new Device("Asus ZenBook 14", 2022, 999.99, "Silver", "Laptop"),
            new Device("Sony Xperia 1 III", 2021, 1199.99, "Black", "Phone"),
            new Device("Samsung Galaxy Book Pro", 2021, 999.99, "Silver", "Laptop"),
            new Device("iPad Mini", 2021, 499.99, "White", "Tablet"),
            new Device("Xiaomi Redmi Note 11", 2022, 299.99, "Blue", "Phone"),
            new Device("Acer Swift 5", 2022, 899.99, "Silver", "Laptop"),
            new Device("Huawei MatePad Pro", 2021, 549.99, "Black", "Tablet"),
            new Device("iPhone 12", 2020, 699.99, "Red", "Phone"),
            new Device("MacBook Air M2", 2022, 1199.99, "Silver", "Laptop"),
            new Device("Samsung Galaxy Tab A8", 2022, 229.99, "White", "Tablet"),
            new Device("Oppo Find X5", 2022, 899.99, "Black", "Phone"),
            new Device("HP Pavilion 15", 2021, 699.99, "Silver", "Laptop"),
            new Device("Microsoft Surface Go 3", 2021, 399.99, "White", "Tablet"),
            new Device("Realme GT 2 Pro", 2022, 599.99, "Blue", "Phone"),
            new Device("Lenovo Yoga 9i", 2022, 1299.99, "Silver", "Laptop"),
            new Device("Samsung Galaxy S20", 2020, 599.99, "Black", "Phone"),
            new Device("iPad 10.2", 2021, 329.99, "White", "Tablet"),
            new Device("Dell Inspiron 15", 2021, 599.99, "Silver", "Laptop"),
            new Device("Xiaomi Mi Pad 5", 2021, 349.99, "Black", "Tablet"),
            new Device("OnePlus 10 Pro", 2022, 899.99, "Green", "Phone"),
            new Device("Asus ROG Zephyrus", 2022, 1999.99, "Black", "Laptop"),
            new Device("Huawei Mate 50", 2022, 1099.99, "Silver", "Phone"),
            new Device("MacBook Pro 14", 2021, 1999.99, "Silver", "Laptop"),
            new Device("Samsung Galaxy Tab S7", 2020, 649.99, "White", "Tablet"),
            new Device("Google Pixel 7", 2022, 599.99, "Black", "Phone"),
            new Device("HP EliteBook 840", 2022, 1199.99, "Silver", "Laptop"),
            new Device("Microsoft Surface Laptop 4", 2021, 999.99, "Blue", "Laptop"),
            new Device("iPhone SE", 2022, 429.99, "Red", "Phone"),
            new Device("Acer Predator Helios", 2022, 1499.99, "Black", "Laptop"),
            new Device("Sony Xperia 5 III", 2021, 949.99, "White", "Phone"),
            new Device("Lenovo IdeaPad 5", 2021, 699.99, "Silver", "Laptop"),
            new Device("iPad Air 5", 2022, 599.99, "Blue", "Tablet"),
            new Device("Xiaomi Mi 12", 2022, 749.99, "Black", "Phone"),
            new Device("Dell Latitude 7420", 2021, 1299.99, "Silver", "Laptop"),
            new Device("Samsung Galaxy Tab S6", 2019, 649.99, "White", "Tablet"),
            new Device("OnePlus Nord 2", 2021, 399.99, "Blue", "Phone"),
            new Device("Asus VivoBook 15", 2021, 599.99, "Silver", "Laptop")
    );

    public static List<Device> generateDevices(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> deviceTemplates.get(random.nextInt(deviceTemplates.size())))
                .collect(Collectors.toList());
    }

    public static Devices createDevices(int size) {
        return new Devices(generateDevices(size));
    }

    public static Devices createDevices() {
        return createDevices(50);
    }

    public static Device createRandomDevice() {
        return deviceTemplates.get(random.nextInt(deviceTemplates.size()));
    }
}
