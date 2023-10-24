#include <iostream>
#include <vector>

long countRectangles(int width, int height) {
    std::vector<std::vector<long>> rectanglesCountMatrix(width + 1, std::vector<long>(height + 1, 0));

    for (int width_position = 1; width_position <= width; ++width_position) {
        for (int height_position = 1; height_position <= height; ++height_position) {
            rectanglesCountMatrix[width_position][height_position] = (width_position * height_position) + rectanglesCountMatrix[width_position - 1][height_position]
            + rectanglesCountMatrix[width_position][height_position - 1] - rectanglesCountMatrix[width_position - 1][height_position - 1];
            
            std::cout << rectanglesCountMatrix[width_position][height_position] << " " << std::endl;
        }
    }

    return rectanglesCountMatrix[width][height];
}

int main() {
    int m, n;
    std::cout << "Enter the height of the rectangle: ";
    std::cin >> m;
    std::cout << "Enter the width of the rectangle: ";
    std::cin >> n;

    long long total = countRectangles(m, n);
    //std::cout << "Total number of rectangles in a " << m << "x" << n << " rectangle is " << total << std::endl;

    return 0;
}
