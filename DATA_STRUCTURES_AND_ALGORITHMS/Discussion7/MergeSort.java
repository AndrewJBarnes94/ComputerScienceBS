package DATA_STRUCTURES_AND_ALGORITHMS.Discussion7;

public class MergeSort {
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        
        int middle = array.length / 2;
        int[] half1 = new int[middle];
        int[] half2 = new int[array.length - middle];

        System.arraycopy(array, 0, half1, 0, middle);
        System.arraycopy(array, middle, half2, 0, array.length - middle);

        mergeSort(half1);
        mergeSort(half2);

        merge(array, half1, half2);
    }

    private static void merge(int[] array, int[] half1, int[] half2) {
        int i = 0, j = 0, k = 0;

        while (i < half1.length && j < half2.length) {
            if (half1[i] <= half2[j]) {
                array[k++] = half1[i++];
            } else {
                array[k++] = half2[j++];
            }
        }

        while (i < half1.length) {
            array[k++] = half1[i++];
        }

        while (j < half2.length) {
            array[k++] = half2[j++];
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 3, 12, 14, 6};
        System.out.println("Original array:");
        for (int value : array) System.out.print(value + " ");
        System.out.println();

        mergeSort(array);

        System.out.println("Merge Sorted array:");
        for (int value : array) System.out.print(value + " ");
    }
}