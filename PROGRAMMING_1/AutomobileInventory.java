import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }
    
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return make + " " + model + " (" + year + ") - Color: " + color + ", Mileage: " + mileage;
    }
}

class CarDealership {
    private ArrayList<Automobile> vehicles;

    public CarDealership() {
        vehicles = new ArrayList<>();
    }

    public void addVehicle(Automobile vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(int index) {
        if (index >= 0 && index < vehicles.size()) {
            vehicles.remove(index);
        }
    }

    public void updateVehicle(int index, String make, String model, String color, int year, int mileage) {
        if (index >= 0 && index < vehicles.size()) {
            vehicles.set(index, new Automobile(make, model, color, year, mileage));
        }
    }

    public List<Automobile> listVehicles() {
        return vehicles;
    }

    public void exportToFile(String filename) {
        try {
            PrintWriter writer = new PrintWriter(new File(filename));
            for (Automobile vehicle : vehicles) {
                writer.println(vehicle.getMake() + "," + vehicle.getModel() + "," + vehicle.getColor() + "," + vehicle.getYear() + "," + vehicle.getMileage());
            }
            writer.close();
            System.out.println("Vehicle information exported to " + filename);
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class AutomobileInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarDealership dealership = new CarDealership();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Add vehicle");
            System.out.println("2 - Update vehicle");
            System.out.println("3 - Delete vehicle");
            System.out.println("4 - List vehicles");
            System.out.println("5 - Export to file");
            System.out.println("6 - End program");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.println("Enter vehicle details:");
                System.out.print("Make: ");
                String make = scanner.nextLine();
                System.out.print("Model: ");
                String model = scanner.nextLine();
                System.out.print("Color: ");
                String color = scanner.nextLine();
                System.out.print("Year: ");
                int year = Integer.parseInt(scanner.nextLine());
                System.out.print("Mileage: ");
                int mileage = Integer.parseInt(scanner.nextLine());

                dealership.addVehicle(new Automobile(make, model, color, year, mileage));
            } else if (choice.equals("2")) {
                List<Automobile> vehiclesList = dealership.listVehicles();
                if (vehiclesList.isEmpty()) {
                    System.out.println("No cars in inventory.");
                } else {
                    System.out.println("Vehicle Inventory:");
                    for (int i = 0; i < vehiclesList.size(); i++) {
                        System.out.println("\t" + i + " - " + vehiclesList.get(i));
                    }
                }
                System.out.print("Enter the index of the vehicle to update: ");
                int index = Integer.parseInt(scanner.nextLine());
                if (index >= 0 && index < vehiclesList.size()) {
                    System.out.println("Enter updated vehicle details:");
                    System.out.print("Make: ");
                    String make = scanner.nextLine();
                    System.out.print("Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Mileage: ");
                    int mileage = Integer.parseInt(scanner.nextLine());

                    dealership.updateVehicle(index, make, model, color, year, mileage);
                } else {
                    System.out.println("Invalid index.");
                }
            } else if (choice.equals("3")) {
                List<Automobile> vehiclesList = dealership.listVehicles();
                if (vehiclesList.isEmpty()) {
                    System.out.println("No cars in inventory.");
                } else {
                    System.out.println("Vehicle Inventory:");
                    for (int i = 0; i < vehiclesList.size(); i++) {
                        System.out.println("\t" + i + " - " + vehiclesList.get(i));
                    }
                }
                System.out.print("Enter the index of the vehicle to delete: ");
                int index = Integer.parseInt(scanner.nextLine());
                dealership.removeVehicle(index);
            } else if (choice.equals("4")) {
                List<Automobile> vehiclesList = dealership.listVehicles();
                if (vehiclesList.isEmpty()) {
                    System.out.println("No cars in inventory.");
                } else {
                    System.out.println("Vehicle Inventory:");
                    for (int i = 0; i < vehiclesList.size(); i++) {
                        System.out.println("\t" + i + " - " + vehiclesList.get(i));
                    }
                }
            } else if (choice.equals("5")) {
                System.out.print("Enter the filename to export: ");
                String filename = scanner.nextLine();
                dealership.exportToFile(filename);
            } else if (choice.equals("6")) {
                break;
            } else {
                System.out.println("Invalid choice. Please select a number 1 through 6.");
            }
        }

        scanner.close();
    }
}
