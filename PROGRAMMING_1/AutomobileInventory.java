import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

class Automobile {
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    public Automobile() {
        this.make = "";
        this.model = "";
        this.color = "";
        this.year = 0;
        this.mileage = 0;
    }

    public Automobile(String make, String model, String color, int year, int mileage) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }
    

    public String addVehicle(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle added.";
        } catch (Exception e) {
            return "Failed to add vehicle. Error: " + e.getMessage();
        }
    }

    public String[] listVehicle() {
        try {
            return new String[]{make, model, color, Integer.toString(year), Integer.toString(mileage)};
        } catch (Exception e) {
            return new String[]{"Error: " + e.getMessage()};
        }
    }

    public String removeVehicle() {
        try {
            this.make = "";
            this.model = "";
            this.color = "";
            this.year = 0;
            this.mileage = 0;
            return "Vehicle removed.";
        } catch (Exception e) {
            return "Failed to remove vehicle. Error: " + e.getMessage();
        }
    }

    public String updateVehicleAttributes(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle attributes updated.";
        } catch (Exception e) {
            return "Failed to update vehicle attributes. Error: " + e.getMessage();
        }
    }
}

public class AutomobileInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Automobile car = new Automobile("Toyota", "Camry", "Red", 2022, 0);

        System.out.println("Initial vehicle added:");
        printVehicleInfo(car.listVehicle());

        System.out.println(car.removeVehicle());
        System.out.println(car.addVehicle("Honda", "Civic", "Blue", 2021, 10000));

        System.out.println("\nNew vehicle added:");
        printVehicleInfo(car.listVehicle());

        System.out.println(car.updateVehicleAttributes("Honda", "Civic", "Silver", 2021, 12000));

        System.out.println("\nUpdated vehicle info:");
        printVehicleInfo(car.listVehicle());

        System.out.print("\nDo you want to print the information to a file (Y or N)? ");
        String response = scanner.nextLine();

        if ("Y".equalsIgnoreCase(response)) {
            printToFile(car.listVehicle());
            System.out.println("Vehicle information printed to C:\\Temp\\Autos.txt");
        } else {
            System.out.println("File will not be printed.");
        }
        scanner.close();
    }

    static void printVehicleInfo(String[] vehicleInfo) {
        for (String info : vehicleInfo) {
            System.out.println(info);
        }
    }

    static void printToFile(String[] vehicleInfo) {
        try {
            File file = new File("C:\\Temp\\Autos.txt");
            PrintWriter writer = new PrintWriter(file);
            for (String info : vehicleInfo) {
                writer.println(info);
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
