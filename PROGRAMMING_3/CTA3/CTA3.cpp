#include <iostream>

using namespace std;

int main() {
    int var1, var2, var3;

    int* pointer1 = nullptr;
    int* pointer2 = nullptr;
    int* pointer3 = nullptr;

    int count = 0;

    while (count < 3) {
        count += 1;
        cout << count << ". Enter an integer: ";
        
        switch (count) {
            case 1:
                cin >> var1;
                pointer1 = new int(var1);
                break;
            case 2:
                cin >> var2;
                pointer2 = new int(var2);
                break;
            case 3:
                cin >> var3;
                pointer3 = new int(var3);
                break;
            default:
                cout << "Invalid integer entry" << endl;
                break;
        }
    }
    
    cout << "Values Stored in Variables:" << endl;
    cout << "\tvar1: " << var1 << endl;
    cout << "\tvar2: " << var2 << endl;
    cout << "\tvar3: " << var3 << endl;

    cout << "Values Pointed to by Pointers:" << endl;
    cout << "\tpointer1 ("  << pointer1 << "): "<< *pointer1 << endl;
    cout << "\tpointer2 ("  << pointer2 << "): "<< *pointer2 << endl;
    cout << "\tpointer3 ("  << pointer3 << "): "<< *pointer3 << endl;

    delete pointer1;
    delete pointer2;
    delete pointer3;

    pointer1 = nullptr;
    pointer2 = nullptr;
    pointer3 = nullptr;

    return 0;
}