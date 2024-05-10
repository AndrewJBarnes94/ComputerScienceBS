#include <iostream>
#include <limits>
#include <string>

using namespace std;

int main() {
    string name;
    int age = 0;

    cout << "Enter name (MAX = 20 character): " << endl;
    cin >> name;

    if (name.length() > 20) {
        cout << "Name too long. Trimming to size." << endl;
        name = name.substr(0, 20);
    }
    cout << "Enter age: ";
    if (!(cin >> age)) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Ignore wrong input
        cout << "Invalid input for 'age'. Age = 0." << endl;
        age = 0;
    } else if (cin.fail()) {
        cout << "Input error found, correctly enter a valid integer" << endl;
        age = 0;
    }

    if (age < 0 || age > 150) {
        cout << "Invalid age. Must be between 0 - 150" << endl;
        age = 0;
    }

    cout << "Hi, " << name << "! Your age is " << age << endl;

    return 0;
}