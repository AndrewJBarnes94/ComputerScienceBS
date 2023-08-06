#--------------------------------------------------------
# Program Name: Module 2 CT Assignment - Option 2
# Program Author: Andrew Barnes
# Program Objective: Create a Dictionary
#--------------------------------------------------------
# Pseudocode: 1. Request data
#             2. Create the dictionary "car"
#             3. Display the dictionary
#--------------------------------------------------------
# Program Inputs: Car data
# Program Outputs: Display of the dictionary
#-------------------------------------------------------- 
print("Car data")

brand = input("Brand: ")
model = input("Model: ")
year = int(input("Year: ")) # transform to integer
start_odo = int(input("Start Odometer Reading: ")) # transform to integer
end_odo = int(input("End Odometer Reading: ")) # transform to integer
estimate_mpg = float(input("Estimate the Miles per Gallon: ")) # transform to float

car = {"brand":brand, "model":model, "year":year, "start_odo":start_odo, "end_odo":end_odo, "estimate_mpg":estimate_mpg}

print(car)

print("End of program")














