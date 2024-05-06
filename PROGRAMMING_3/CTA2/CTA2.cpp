#include <iostream>
#include <string>

using namespace std;

string concatenate(string x, string y) {
    return x + y;
}

int main() {
    for (int i = 0; i < 3; ++i) {
        string input1;
        string input2;

        cout << "Enter text for input1: ";
        cin >> input1;

        cout << "Enter text for input2: ";
        cin >> input2;

        // Output concatenated input1 and input2 to the console
        cout << "Concatenated string: " << concatenate(input1, input2) << endl;
    }

    return 0;
}
