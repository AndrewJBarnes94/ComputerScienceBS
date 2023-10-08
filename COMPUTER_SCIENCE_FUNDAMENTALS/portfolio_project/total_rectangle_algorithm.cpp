/*

TOTAL RECTANGLES ALGORITHM

    1. Make sure input is valid:
        a. If rectangle_width or rectangle height are <= 0
            i. Return 0
    2. Initialize count variable set to 0
    3. Begin loop with width_position iterating from 1 to rectangle_width:
        a. For each width_position, begin nested loop with height_position iterating from 1 to rectangle_height:
            i. For each iteration of width_position and height_position:
                1. Add the product of (rectangle_width - width_position + 1) * (rectangle_height - height_position + 1)
                   to the count variable
    4. Return the count variable value as the total number of rectangles
    
*/

#include <iostream>
long count_rectangles(int rectangle_width, int rectangle_height) {
    if (rectangle_width <= 0 || rectangle_height <= 0) {
        return 0;
    }

    long count = 0;
    
    for (int width_position = 1; width_position <= rectangle_width; width_position++) {
        for (int height_position = 1; height_position <= rectangle_height; height_position++) {
            count += (rectangle_width - width_position + 1) * (rectangle_height - height_position + 1);
        }
    }

    return count;
}

int main() {
    int rectangle_width, rectangle_height;

    std::cout << "Enter rectangle width: ";
    std::cin >> rectangle_width;

    std::cout << "Enter rectangle height: ";
    std::cin >> rectangle_height;

    long total_rectangles = count_rectangles(rectangle_width, rectangle_height);

    std::cout << "Total rectangles: " << total_rectangles << std::endl;

    return 0;
}