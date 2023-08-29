###################################################################################
# Module 2 Critical Thinking Assignment 
# Course: CSC200-1 (Computer Science Fundamentals)
# Author: Andrew Barnes
###################################################################################
# Pseudocode for the Python program to perform basic mathematical operations
#
# 1. Prompt the user to input two numbers
#               input num1
#               input num2
# 2. Perform the mathematical operations
#               sum_result = num1 + num2
#               multiply_result = num1 * num2
#               subtract_result = num1 - num2
#               division_result = num1 / num2

# 3. Display the results of the mathematical operations
#               output "Sum:", num1, "+", num2, "=", sum_result
#               output "Multiplication:", num1, "*", num2, "=", multiply_result
#               output "Subtraction:", num1, "-", num2, "=", subtract_result
#               output "Division:", num1, "/", num2, "=", division_result           
###################################################################################

# User input for two numbers
num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))

# Mathematical operations
sum_result = num1 + num2
multiply_result = num1 * num2
subtract_result = num1 - num2
division_result = num1 / num2

# Printing results
print(f"{num1} + {num2} = {sum_result}")
print(f"{num1} * {num2} = {multiply_result}")
print(f"{num1} - {num2} = {subtract_result}")
print(f"{num1} / {num2} = {division_result}")
