#--------------------------------------------------------------------------------
# Program Name: Final Portfolio Project - Automobile Inventory Program
# Program Author: Andrew Barnes
# Program Objective: Create an automobile class to be used as a vehicle inventory 
#                    program for a dealership. The program should allow the 
#                    addition, removal, and updating of vehicles in the inventory, 
#                    and output the final inventory to a text file.
#--------------------------------------------------------------------------------
# Pseudocode: 1. Define the Automobile class with private attributes: make, model,
#                color, year, and mileage.
#             2. Define the CarDealership class to manage the vehicle inventory with 
#                methods for adding, removing, updating vehicles, and exporting 
#                the inventory to a text file.
#             3. Implement user interface for interacting with the inventory: adding, 
#                removing, updating vehicles, and exporting the inventory.
#             4. Allow the user to export the inventory to a text file at the end of 
#                their session.
#--------------------------------------------------------------------------------

class Automobile:
    def __init__(self, make, model, color, year, mileage):
        self.make = make
        self.model = model
        self.color = color
        self.year = year
        self.mileage = mileage

class CarDealership:
    def __init__(self):
        self.vehicles = []

    def add_vehicle(self, vehicle):
        self.vehicles.append(vehicle)

    def remove_vehicle(self, index):
        if 0 <= index < len(self.vehicles):
            del self.vehicles[index]

    def update_vehicle(self, index, make, model, color, year, mileage):
        if 0 <= index < len(self.vehicles):
            self.vehicles[index] = Automobile(make, model, color, year, mileage)

    def list_vehicles(self):
        if not self.vehicles:
            print("No cars in inventory.")
        else:
            print("Vehicle Inventory:")
            for i, vehicle in enumerate(self.vehicles):
                print(f"\t{i} - {vehicle.make} {vehicle.model} ({vehicle.year}) - Color: {vehicle.color}, Mileage: {vehicle.mileage}")

    def export_to_file(self, filename):
        with open(filename, 'w') as file:
            for vehicle in self.vehicles:
                file.write(f"{vehicle.make},{vehicle.model},{vehicle.color},{vehicle.year},{vehicle.mileage}\n")

def get_integer_input(prompt):
    while True:
        try:
            value = int(input(prompt))
            return value
        except ValueError:
            print("Invalid input. Please enter an integer.")

def get_vehicle_input():
    make = input("Enter the make: ")
    model = input("Enter the model: ")
    color = input("Enter the color: ")
    year = get_integer_input("Enter the year: ")
    mileage = get_integer_input("Enter the mileage: ")
    return make, model, color, year, mileage

def main():
    car_dealership = CarDealership()

    while True:
        print("\nMenu:")
        print("1 - Add vehicle")
        print("2 - Update vehicle")
        print("3 - Delete vehicle")
        print("4 - List vehicles")
        print("5 - Export to file")
        print("6 - End program")

        choice = input("\nEnter your choice: ")

        if choice == "1":
            make, model, color, year, mileage = get_vehicle_input()
            car_dealership.add_vehicle(Automobile(make, model, color, year, mileage))
        
        elif choice == "2":
            car_dealership.list_vehicles()
            while True:
                index = get_integer_input("Enter the index of the vehicle to update: ")
                if 0 <= index < len(car_dealership.vehicles):
                    make, model, color, year, mileage = get_vehicle_input()
                    car_dealership.update_vehicle(index, make, model, color, year, mileage)
                    break
                else:
                    print(f"\nInvalid index. Must be between 0 and {len(car_dealership.vehicles) - 1}")
        
        elif choice == "3":
            car_dealership.list_vehicles()
            while True:
                index = get_integer_input("Enter the index of the vehicle to delete: ")
                if 0 <= index < len(car_dealership.vehicles):
                    car_dealership.remove_vehicle(index)
                    break
                else:
                    print(f"\nInvalid index. Must be between 0 and {len(car_dealership.vehicles) - 1}")

        elif choice == "4":
            car_dealership.list_vehicles()
        
        elif choice == "5":
            filename = input("Enter the filename to export: ")
            car_dealership.export_to_file(filename)

        elif choice == "6":
            break

        else:
            print("Invalid choice. Please select a number 1 through 6.")

if __name__ == "__main__":
    main()
