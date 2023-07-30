#--------------------------------------------------------------------------------
# Program Name: Week 6 Critical Thinking Assignment
# Program Author: Andrew Barnes
# Program Objective: Take two complex numbers as input and perform various
#                    operations on them (addition, subtraction, multiplication, 
#                    division, modulus) and print out the results with precision
#                    up to two decimal places.
#--------------------------------------------------------------------------------
# Pseudocode: 1. Get two sets of inputs from the user, each set representing a 
#                complex number (real and imaginary parts, A + Bi).
#             2. Initialize two instances of the Complex class with these inputs.
#             3. Use the overridden methods in the Complex class to perform
#                addition, subtraction, multiplication, and division of the 
#                complex numbers.
#             4. Compute the modulus of each complex number using the mod method 
#                in the Complex class.
#             5. Print out the results of these operations.
#--------------------------------------------------------------------------------
import math

class Complex(object):
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    def __add__(self, num):
        real = self.real + num.real
        imaginary = self.imaginary + num.imaginary
        return Complex(real, imaginary)

    def __sub__(self, num):
        real = self.real - num.real
        imaginary = self.imaginary - num.imaginary
        return Complex(real, imaginary)

    def __mul__(self, num):
        real = self.real * num.real - self.imaginary * num.imaginary
        imaginary = self.real * num.imaginary + self.imaginary * num.real
        return Complex(real, imaginary)

    def __truediv__(self, num):
        real = (self.real * num.real + self.imaginary * num.imaginary) / (num.real ** 2 + num.imaginary ** 2)
        imaginary = (self.imaginary * num.real - self.real * num.imaginary) / (num.real ** 2 + num.imaginary ** 2)
        return Complex(real, imaginary)

    def mod(self):
        real = math.sqrt(self.real ** 2 + self.imaginary ** 2)
        return Complex(real, 0)

    def __str__(self):
        return "{0:.2f}{1:+.2f}i".format(self.real, self.imaginary)

def main():
    try:
        C = map(float, input("Enter the real and imaginary parts of the first complex number, separated by space: ").split())
        D = map(float, input("Enter the real and imaginary parts of the second complex number, separated by space: ").split())    
        x = Complex(*C)
        y = Complex(*D)
        print ('\n'.join(map(str, [x+y, x-y, x*y, x/y, x.mod(), y.mod()])))
    
    except ValueError:
        print("Invalid input. Please enter two numbers (real and imaginary parts of the complex number), separated by a space.")
    except ZeroDivisionError:
        print("Error: Division by zero is not allowed.")
    except Exception as e:
        print(f"An unexpected error occurred: {str(e)}")

if __name__ == "__main__":
    main()

