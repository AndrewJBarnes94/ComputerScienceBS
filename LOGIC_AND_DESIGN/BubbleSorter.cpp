#include <iostream>

void bubbleSort(int arr[], int arrLength) {
    bool swapped;
    do {
        swapped = false;
        for (int i=1; i<arrLength; i++) {
            if (arr[i-1] > arr[i]) {
                int temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
                swapped = true;
            }
        }
    } while (swapped);
}

int main() {
    int arr[] = {64, 34, 25, 12, 22, 11, 90};
    int arrLength = sizeof(arr) / sizeof(arr[0]);

    std::cout << "Original array: ";
    for (int i = 0; i < arrLength; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;

    bubbleSort(arr, arrLength);

    std::cout << "Sorted array: ";
    for (int i = 0; i < arrLength; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;

    return 0;
}