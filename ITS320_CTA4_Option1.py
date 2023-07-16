#--------------------------------------------------------------------------------
# Program Name: Week 4 Critical Thinking Assignment
# Program Author: Andrew Barnes
# Program Objective: Give a set of 5 integer values and 
#                    compute the total, average, maximum, minimum,
#                    interest at 20% for each original value entered
#                    by the user.
#--------------------------------------------------------------------------------
# Pseudocode: 1. Loop through 5 inputs expecting an integer value > 0
#             2. Add each integer iteration to a list
#             3. Compute total, average, maximum, minimum, and 20% interest
#             4. Print out the results
#--------------------------------------------------------------------------------
print("Display Total, Average, Maximum, Minimum, and Interest at 20% for each original value entered by the user.")

integer_list = []

for i in range(5):
    input_value = input("Please enter an integer greater than 0: ")
    if input_value == "":
        print("ERROR: Integer must be supplied")
    else:
        if not input_value.isdigit():
            # Since isdigit detects digits, we can infer that if all characters are digits it must be a positive integer.
            print("ERROR: Input must be a positive integer.")
        else:
            integer = int(input_value)
            integer_list.append(integer)

total = sum(integer_list)
average = total / len(integer_list)
maximum = max(integer_list)
minimum = min(integer_list)

print("\n")
print("Total:", total)
print("Average:", average)
print("Maximum:", maximum)
print("Minimum:", minimum)
print("20% interest of each integer:")

for i in integer_list:
    # Calculate the 20% interest rate with the formula: i + (i * 0.2)
    print(f"\t{i}: {i + (i * 0.2)}")

print("End of Program")
print("\n")