/*  
    REGION OF INTEREST (ROI) ALGORITHM FOR GRAPHICS
    Author: Andrew Barnes
    Date: 10/8/2023

    Purpose
        Compute the total number of rectangles formed inside
        of a user selected parent rectangle, the ROI, specified
        by the width and height. This algorithm can be useful
        where breaking down sub-regoins of a ROI is crucial.

    Input
        1. Rectangle
            a. width
            b. height
        2. Multiple ROIs
            a. top-left coordinate (x, y) of ROI
            b. width of ROI
            c. height of ROI
    Output
        A count for total number of possible sub-rectangles
        within input rectangle including the input rectangle
        for each ROI during program execution.

    Pseudocode
        1. Declare width and height as integers
        2. Prompt user for width and height of a rectangle
           that acts as a simulation for the size of an
           image. 
        3. Assign width and height according to user input
        4. Create a vector name "rois" that will store all 
           ROIs holding their width, height, x starting point,
           and y starting point as integers, along with the
           total number of rectangles as a long long inside
           of a tuple.
        5. Begin a loop:
            a. Prompt user for top-left x and y point for
               an ROI.
            b. Declare x and y variables.
            c. Initialize x value from user input.
            d. If user inputs -1 as x value:.
                - Break out of the loop.
            e. Initialize y value from user input.
            f. Declare rec_width and rec_height variables
               as integers.
            g. Prompt user to enter the width and height of
               the rectangle used as the ROI.
            h. Initialize rec_width and rec_height according
               to user specifications.
            i. Name a function named count_rectangles made
               to accept arguments width and height as
               integers that will:

-->         // PORTFOLIO PROJECT START
            
                    - Check if width or height is less than or equal
                      to 0, returning 0 if true.
                    - Initialize a count variable as long long = 0
                    - Start from top-left corner of the current rectangle
                      and iterate through the width:
                        i. For each horizontal position, w_pos, from 1 to width:
                            1. Iterate through height of current rectangle:
                                a. For each vertical position, h_pos, from 1 to height:
                                    - Calculate number of rectangles formed with the
                                      top-left corner at the current (w_pos, h_pos).
                                      This is calculated as (width - w_pos + 1) * (height - h_pos + 1).
                                    - Add this number to the count variable. 
                    - Upon completion of both loops, return the end value
                      of count variable to represent the total number of rectangles

-->         // PORTFOLIO PROJECT END

            j. Calculate the total number of rectangles for 
               the current ROI using the count_rectangles function
            k. Add rec_width, rec_height, x, y, and total as a tuple to roi vector
            l. Print "Total number of rectangles in this ROI is " + total
        6. After loop exit, display totals for all ROIs using data in rois vector.
*/

#include <iostream>
#include <vector>
#include <tuple>

long long count_rectangles(int width, int height) {
    if (width <= 0 || height <= 0) {
        return 0;
    }

    long long count = 0;
    
    for (int w_pos = 1; w_pos <= width; w_pos++) {
        for (int h_pos = 1; h_pos <= height; h_pos++) {
            count += (width - w_pos + 1) * (height - h_pos + 1);
        }
    }

    return count;
}

int main() {
    int width, height;
    std::cout << "Enter width of rectangular region: ";
    std::cin >> width;
    std::cout << "Enter the height of the rectangular region: ";
    std::cin >> height;

    std::vector<std::tuple<int, int, int, int, long long>> rois;

    // Specify rectangles by providing top-left coordinates & dimensions
    while (true) {
        std::cout << "Enter top-left coordinates (x y) of a rectangle or -1 to finish: ";
        int x, y;
        std::cin >> x;
        if (x == -1) {
            break;
        }
        std::cin >> y;
        int rec_width, rec_height;
        std::cout << "Enter width and height of the rectangle: ";
        std::cin >> rec_width >> rec_height;
        
        // Count rectangles in ROI & display count
        long long total = count_rectangles(rec_width, rec_height);
        
        rois.emplace_back(rec_width, rec_height, x, y, total);

        std::cout << "Total number of rectangles in this ROI is " << total << std::endl;
    }

    // Display the counts for all specified ROIs
    for (size_t i = 0; i < rois.size(); i++) {
    std::cout
        << "ROI " << i + 1 
        << ": Total number of rectangles in " << std::get<0>(rois[i]) << "x" << std::get<1>(rois[i]) 
        << " ROI starting at top-left point (" << std::get<2>(rois[i]) << ", " << std::get<3>(rois[i]) 
        << ") " << "= " << std::get<4>(rois[i]) 
        << std::endl;
    }

    return 0;
}
