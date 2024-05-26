#include <iostream>
#include <fstream>
#include <algorithm>

using namespace std;

void appendTo(const string &filename, const string &userInput) {
    ofstream outputFile;
    outputFile.open(filename, ios::app);

    if (outputFile.is_open()) {
        outputFile << userInput << endl;
    } else {
        cerr << "Could not append because file could not be opened." << endl;
    }
}

void file1ReversedToFile2(const string &filename, string &outputFilename) {
    ifstream inputFile(filename);

    if (inputFile.is_open()) {
        string content((istreambuf_iterator<char>(inputFile)), istreambuf_iterator<char>());

        inputFile.close();
        reverse(content.begin(), content.end());
        ofstream outputFile(outputFilename);
        
        if (outputFile.is_open()) {
            outputFile << content;
            outputFile.close();
        } else {
            cerr << "Could not open file for reversing contents." << endl;
        }
    } else {
        cerr << "Could not open the file to be read" << endl;
    }
}

int main() {
    string file1 = "CSC450_CT5_mod5.txt";
    string file2 = "CSC450-mod5-reverse.txt";
    string userInput;

    cout << "Please enter some text to append to the file: ";
    getline(cin, userInput);
    appendTo(file1, userInput);
    file1ReversedToFile2(file1, file2);

    cout << "Appended user input to a file and created a reversed file" << endl;
    
    return 0;
}