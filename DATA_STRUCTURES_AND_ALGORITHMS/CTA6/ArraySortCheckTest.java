package DATA_STRUCTURES_AND_ALGORITHMS.CTA6;

public class ArraySortCheckTest {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] unsortedArray = {6, 3, 5, 8, 3, 78, 3, 2, 1};

        String arrayIsSorted = "Array is sorted = ";

        System.out.println(arrayIsSorted + ArraySortCheck.isArraySortedAscending(sortedArray));
        System.out.println(arrayIsSorted + ArraySortCheck.isArraySortedAscending(unsortedArray));
    }
}
