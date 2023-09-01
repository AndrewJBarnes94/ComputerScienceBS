public class BinarySearchExample {
  
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // target not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid; // target found
        } else if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right); // search in the right half
        } else {
            return binarySearch(arr, target, left, mid - 1); // search in the left half
        }
    }
  
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;
        int result = binarySearch(arr, target, 0, arr.length - 1);
        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
