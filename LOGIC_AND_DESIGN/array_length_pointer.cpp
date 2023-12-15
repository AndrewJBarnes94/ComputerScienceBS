#include <iostream>
#include <array>

using namespace std;

int main() {
    int arr[3] = {1, 2, 3};

    int len = *(&arr + 1) - arr;

    cout << "Length of array: " << len << endl;

    return 0;
}