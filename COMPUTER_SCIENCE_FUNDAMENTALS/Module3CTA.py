def bubble_sort(arr):
    n = len(arr)
    for i in range(n-1):
        for j in range(0, n - i -1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
    return arr

employee_salaries = [500, 300, 700, 400, 600, 550]

ascending_order = bubble_sort(employee_salaries.copy())
descending_order = ascending_order[::-1]

print(f"Employee Salaries: {employee_salaries}\n")
print(f"Salaries in ascending Order: {ascending_order}\n")
print(f"Salaries in descending Order: {descending_order}\n")