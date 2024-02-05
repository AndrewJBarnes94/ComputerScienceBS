package DATA_STRUCTURES_AND_ALGORITHMS.CTA6;

public class ArraySortCheck {
    /**
     * Checks if the given array is sorted in ascending order.
     * 
     * @param array the array to check
     * @return true if the array is sorted in ascending order, otherwise return false
     */
    public static boolean isArraySortedAscending(int[] array) {
        // If an array has < 2 elements it's considered sorted
        if (array.length < 2) {
            return true;
        }
        
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                // If the current element is greater than the next, the array is not sorted
                return false;
            }
        }
        // If no elements of the array triggered a false return, it returns true and is in ascending order
        return true;
    }
}
