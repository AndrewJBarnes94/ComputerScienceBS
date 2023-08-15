#------------------------------------------------------------------
# Program Name: Module 3 CT Assignment - Option 1
# Program Author: Andrew Barnes
# Program Objective: Approximate the value of a Ferrari 250 GTO
#------------------------------------------------------------------
# Pseudocode: 1. Request year of Ferrari 250 GTO
#             2. Validate year
#               a. Must be supplied
#               b. Must be a number
#               c. Cannot be less than 1962 or more than 2014
#             3. Assign value based on year
#               a. 1962-1964	$18,500
#                  1965-1968	$6,000
#                  1969-1971	$12,000
#                  1972-1975	$48,000
#                  1976-1980	$200,000
#                  1981-1985	$650,000
#                  1986-2012	$35,000,000
#                  2013-2014	$52,000,000
#             4. Display the year and the value
#------------------------------------------------------------------
# Program Inputs:
# Program Outputs:
#------------------------------------------------------------------
print("Ferrari 250 GTO year based value")

value = 0

input_value = input("Year of Ferrari 250 GTO: ")

if input_value == "":
    print("ERROR: A year must be supplied")
else:
    if not (input_value.isdigit()):
        print("ERROR: year must be a number")
    else:
        year = int(input_value)
        if (year < 1962) or (year > 2014):
            print("ERROR: year must be between 1962 and 2014")
    
if 1962 <= year <= 1964:
    value = 18_500
if 1965 <= year <= 1968:
    value = 6_000
if 1969 <= year <= 1971:
    value = 12_000
if 1972 <= year <= 1975:
    value = 48_000
if 1976 <= year <= 1980:
    value = 200_000
if 1981 <= year <= 1985:
    value = 650_000
if 1986 <= year <= 2012:
    value = 35_000_000
if 2013 <= year <= 2014:
    value = 52_000_000

print("${:,.2f}".format(value))

print("End of program")