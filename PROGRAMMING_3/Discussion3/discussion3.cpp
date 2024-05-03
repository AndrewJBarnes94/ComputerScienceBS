#include <iostream>

using namespace std;

int main() {
    string food[] = {"pizza", "cheeseburger", "burrito", "lasagna", "waffles"};

    string *pointer = food;

    int size = sizeof(food) / sizeof(food[0]);

    for (int i = 0; i < size; i++) {
        cout << pointer << ": " << *pointer << endl; // Printing the memory address and its value
        pointer++;
    }

    return 0;
}
