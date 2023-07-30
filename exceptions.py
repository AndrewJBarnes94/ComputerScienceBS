def divide_numbers(a, b):
    try:
        result = a / b
    except ZeroDivisionError:
        print("Error: Cannot divide by zero.")
        return None
    except TypeError:
        print("Error: Both operands should be numbers.")
        return None
    else:
        print(f"The result of {a} divided by {b} is {result}.")
        return result
    finally:
        print("Division operation completed.")

print(divide_numbers(10, 2))
print(divide_numbers(8, 0))
print(divide_numbers(20, "5"))