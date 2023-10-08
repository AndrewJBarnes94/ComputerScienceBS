#include <iostream>

long total_rectangles(int length, int width) {
    if (length == 0 || width == 0) {
        return 0;
    }
    return length * width + total_rectangles(length-1, width) + total_rectangles(length, width-1) - total_rectangles(length-1, width-1);
}

int main() {
    int length, width;

    std::cout << "Enter the length of the rectangle: ";
    std::cin >> length;

    std::cout << "Enter the width of the rectangle: ";
    std::cin >> width;

    int total = total_rectangles(length, width);
    
    std::cout << "Total number of rectangles in a  " << length << "x" << width << " rectangle is " << total << std::endl;
}