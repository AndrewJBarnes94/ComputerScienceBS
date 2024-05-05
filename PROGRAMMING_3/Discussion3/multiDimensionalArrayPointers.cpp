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

    for (int i=0; i<3; i++) {
        for (int j=0; j<2; j++) {
            for (int k=0; k<1; k++) {
                cout << "Array[" << i << "][" << j << "][" << k << "]: "
                << &((*p)[j][k]) << " ---> " << (*p)[j][k] << endl;
            }
        }
        p++;
    }

    return 0;
}