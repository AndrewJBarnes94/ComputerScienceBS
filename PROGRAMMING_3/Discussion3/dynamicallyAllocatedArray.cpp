#include <iostream>

using namespace std;

int main() {
    cout << "Enter quantity of elements within your array:\t";
    int sizeOfArray;
    cin >> sizeOfArray;

    int* newArray = new int[sizeOfArray];

    for (int i=0; i<sizeOfArray; ++i) {
        newArray[i] = i + i; // Random operation for element placeholder within the array
    }

    for (int i=0; i<sizeOfArray; ++i) {
        cout << "Index " << i << " = " << newArray[i] << endl;
    }

    delete[] newArray;

    return 0;
}