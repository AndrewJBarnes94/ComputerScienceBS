package PROGRAMMING_2.Discussion6;

class SortAndSearch { 
    void insertionSort(int array[]) { 
        int arrayLength = array.length; 
        for (int i = 1; i < arrayLength; ++i) { 
            int key = array[i]; 
            int j = i - 1; 

            while (j >= 0 && array[j] > key) { 
                array[j + 1] = array[j]; 
                j = j - 1; 
            } 
            array[j + 1] = key; 
        }
        for (int i = 0; i < arrayLength; ++i) 
            System.out.print(array[i] + " ");
        System.out.println();
    }
  
    int binarySearch(int array[], int l, int r, int x)
    {
        while (l <= r) {
            int mid = (l + r) / 2;
 
            if (array[mid] == x) {
                return mid;
            } else if (array[mid] > x) {
                r = mid - 1;
            } else {
              l = mid + 1;
            }  
        }
        return -1;
    }

    public static void main(String args[]) { 
        int array[] = { 4, 11, 6, 15, 7 }; 
  
        SortAndSearch sas = new SortAndSearch();
        sas.insertionSort(array); 

        int arrayLength = array.length;
        int x = 11;
        int result = sas.binarySearch(array, 0, arrayLength - 1, x);
 
        if (result == -1)
            System.out.println(x + ": not present");
        else
            System.out.println(x + ": found at index " + result);
    } 
}