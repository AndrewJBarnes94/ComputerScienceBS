package DATA_STRUCTURES_AND_ALGORITHMS.CTA3;

/*
 * Consider an array of length n containing unique integers in random order and in the range 1 to n + 1.
 * For example, an array of length 5 would contain 5 unique integers selected randomly from the integers 1 through 6.
 * Thus, the array might contain  6 5 1 4. Of the integers 1 through 6, notice that the 2 was not chosen and is not in the array.
 * Write Java code that finds the integer that does not appear in such an array. Your solution should use O(n^2) operations.
*/

public class BigOh {

    public static int findMissingNumber(int[] array) {
        int n = array.length;
        boolean isFound;

        for (int i = 1; i <= n + 1; i++) {
            isFound = false;
            for (int num : array) {
                if (num == i) {
                    isFound = true;
                    break;
                }
            }
            if (!isFound) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] exampleArray = {6, 5, 1, 4, 3};
        System.out.println("Missing number is: " + findMissingNumber(exampleArray));
    }
}
