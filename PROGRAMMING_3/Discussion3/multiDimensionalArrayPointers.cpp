#include <iostream>

using namespace std;

int main() {

    int Array[3][2][1] = {
        {{1}, {2}},
        {{3}, {4}},
        {{5}, {6}}
    };

    int (*p)[2][1] = Array;

    cout << "Array Base Address: " << p << endl;

    for (int )

    return 0;
}