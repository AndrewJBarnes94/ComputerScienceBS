package DATA_STRUCTURES_AND_ALGORITHMS.Discussion6;

class InsertionSort { 
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

    public static void main(String args[]) { 
        int array[] = { 4, 11, 6, 15, 7 }; 
  
        InsertionSort sortedArray = new InsertionSort();
        sortedArray.insertionSort(array); 
    }
}