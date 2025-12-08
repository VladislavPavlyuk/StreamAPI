package stream.models;

import java.util.List;
import java.util.stream.Collectors;

public class Devices {
    private final List<Device> devices;
    
    public Devices(List<Device> devices) {
        this.devices = devices;
    }

    private void print(List<Device> deviceList) {
        if (deviceList.isEmpty()) {
            System.out.println("No devices found.");
            return;
        }
        for (int i = 0; i < 70; i++){
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%-30s %-6s %-12s %-10s %-10s%n", "Name", "Year", "Price", "Color", "Type");
        for (int i = 0; i < 70; i++){
            System.out.print("-");
        }
        System.out.println();

        int columns = 1;
        for (int i = 0; i < deviceList.size(); i++) {
            Device d = deviceList.get(i);
            System.out.printf("%-30s %-6d %-12.2f %-10s %-10s  ", 
                    d.getName(), d.getYear(), d.getPrice(), d.getColor(), d.getType());
            if ((i + 1) % columns == 0 || i == deviceList.size() - 1) {
                System.out.println();
            }
        }
    }
    
    public void showAll() {    // Show all devices
        System.out.println("All devices:");
        print(devices);
    }

    public void showAllByColor(String color) {    // Show all devices of specified color
        System.out.println("\nDevices with color " + color + ":");
        List<Device> filtered = devices.stream()
                .filter(device -> device.getColor().equalsIgnoreCase(color))
                .collect(Collectors.toList());
        print(filtered);
    }

    public void showAllByYear(int year) {    // Show all devices of specified release year
        System.out.println("\nDevices from year " + year + ":");
        List<Device> filtered = devices.stream()
                .filter(device -> device.getYear() == year)
                .collect(Collectors.toList());
        print(filtered);
    }

    public void showAllByExpensiveThan(double price) {     // Show all devices more expensive than specified price
        System.out.println("\nDevices more expensive than " + price + ":");
        List<Device> filtered = devices.stream()
                .filter(device -> device.getPrice() > price)
                .collect(Collectors.toList());
        print(filtered);
    }

    public void showAllByType(String type) {     // Show all devices of specified type
        System.out.println("\nDevices of type " + type + ":");
        List<Device> filtered = devices.stream()
                .filter(device -> device.getType().equalsIgnoreCase(type))
                .collect(Collectors.toList());
        print(filtered);
    }

    public void showAllByYears(int startYear, int endYear) {       // Show all devices whose release year is in the specified range
        System.out.println("\nDevices from year range " + startYear + " to " + endYear + ":");
        List<Device> filtered = devices.stream()
                .filter(device -> device.getYear() >= startYear && device.getYear() <= endYear)
                .collect(Collectors.toList());
        print(filtered);
    }
    
    public Device getRandomDevice() {
        if (devices.isEmpty()) {
            return null;
        }
        java.util.Random random = new java.util.Random();
        return devices.get(random.nextInt(devices.size()));
    }
}

