#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    vector<string> lines;
    string line;
    size_t max_lines = 5;

    while (lines.size() < max_lines && getline(cin, line)) {
        lines.push_back(line);
    }

    if (lines.size() >= max_lines) {
        cerr << "Too many lines. Input limit reached." << endl;
    }

    return 0;
}