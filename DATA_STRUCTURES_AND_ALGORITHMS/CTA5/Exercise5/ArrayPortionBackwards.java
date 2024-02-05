package DATA_STRUCTURES_AND_ALGORITHMS.CTA5.Exercise5;

public class ArrayPortionBackwards {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        printReverseArray(array, 5, 9);

    }

     public static void printReverseArray(int[] array, int startIndex, int endIndex) {
        if (endIndex < startIndex) {
            return;
        } else {
            System.out.print(array[endIndex] + " "); // Prints current end index of the array
            printReverseArray(array, startIndex, endIndex - 1);
        }
     } 
}
