def ReplaceAll(original_array, item_to_replace, replacement_item):
    if not original_array:
        return original_array
    
    for i in range(len(original_array)):
        if original_array[i] == item_to_replace:
            original_array[i] = replacement_item
    
    return original_array

original_array = ['Paul', 'Ben', 'Tim', 'Brenda', 'Brenda', 'Patty']
item_to_replace = 'Brenda'
replacement_item = 'Deena'

result_array = ReplaceAll(original_array, item_to_replace, replacement_item)
print(result_array) 
