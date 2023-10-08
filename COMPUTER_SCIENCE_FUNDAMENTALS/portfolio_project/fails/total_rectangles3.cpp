#include <iostream>
#include <vector>

long countRectangles(int width, int height) {
    std::vector<std::vector<long>> rectanglesCountMatrix(width + 1, std::vector<long>(height + 1, 0));

    for (int width_point = 1; width_point <= width; ++width_point) {
        for (int height_point = 1; height_point <= height; ++height_point) {
            rectanglesCountMatrix[width_point][height_point] = (width_point * height_point) + rectanglesCountMatrix[width_point - 1][height_point]
            + rectanglesCountMatrix[width_point][height_point - 1] - rectanglesCountMatrix[width_point - 1][height_point - 1];
            
            std::cout << rectanglesCountMatrix[width_point][height_point] << " " << std::endl;
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
