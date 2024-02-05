package DATA_STRUCTURES_AND_ALGORITHMS.Discussion7;

public class DarinMergeSort {
    void merge(int array[], int beg, int mid, int end) {
        int size = end - beg + 1;
        int[] arrayTemp = new int[size]; // Optimal size for the temporary array
        int leftIndex = beg;
        int rightIndex = mid + 1;
        int k = 0;
    
        while (leftIndex <= mid && rightIndex <= end) {
            if (array[leftIndex] <= array[rightIndex]) {
                arrayTemp[k++] = array[leftIndex++];
            } else {
                arrayTemp[k++] = array[rightIndex++];
            }
        }
    
        while (leftIndex <= mid) {
            arrayTemp[k++] = array[leftIndex++];
        }
        while (rightIndex <= end) {
            arrayTemp[k++] = array[rightIndex++];
        }
    
        // Copy the elements back to the original array, only the elements used
        System.arraycopy(arrayTemp, 0, array, beg, size);
    }
    
}
