#--------------------------------------------------------------------------------
# Program Name: Week 5 Critical Thinking Assignment
# Program Author: Andrew Barnes
# Program Objective: In a function, return to the user a concatenation of three 
#                    string values in reverse order.
#--------------------------------------------------------------------------------
# Pseudocode: 1. Create a function that concatonates and reverses three
#                string parameters then returns the result.
#             2. Create an empty list for the three strings to reside.
#             3. Allow the user to input the three strings in a for loop
#                that appends the string to the list.
#             4. Populate the parameters of the function with the strings from
#                the list.
#             5. Print the reversed and concatonated result.
#--------------------------------------------------------------------------------
# Program Inputs: Three Strings
# Program Outputs: A concatonations of the three strings in reverse
#--------------------------------------------------------------------------------
print("Reverse & Concatonate Three Strings")

def concatonate_and_reverse_strings(strings):
    string = ""

    for txt in strings:
        string += txt

    reversed_string = string[::-1]
    return reversed_string

strings = []
amount_of_strings = 3   # Change this number if you want to reverse more/less than 3 strings.

for i in range(amount_of_strings):
    string = input("Enter a string of text: ")

    if string == "":
        print("ERROR: A string must be supplied")
    else:
        strings.append(string)

result = concatonate_and_reverse_strings(strings)

print(f"Result: {result}")

print("End Program")