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
print("Reverse & Concatonate Three Strings")

def concatonate_and_reverse_strings(string_1, string_2, string_3):
    concatonate_strings = string_1 + string_2 + string_3
    reversed_string = concatonate_strings[::-1]
    return reversed_string

strings = []

for i in range(3):
    string = input("Enter a string of text: ")
    if string == "":
        print("ERROR: A string must be supplied")
    else:
        strings.append(string)

result = concatonate_and_reverse_strings(strings[0], strings[1], strings[2])
print(f"Result: {result}")

print("End Program")