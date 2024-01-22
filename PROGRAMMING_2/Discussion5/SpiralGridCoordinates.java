package PROGRAMMING_2.Discussion5;

public class SpiralGridCoordinates {

    public static void traverseSpiral(int rows, int cols, int top, int bottom, int left, int right) {
        if (left > right || top > bottom) {
            return;
        }

        for (int col = left; col <= right; col++) {
            System.out.print("(" + top + ", " + col + ")");
        }
        top++;

        for (int row = top; row <= bottom; row++) {
            System.out.print("(" + row + ", " + right + ")");
        }
        right--;

        if (top <= bottom) {
            for (int col = right; col >= left; col--) {
                System.out.print("(" + bottom + ", " + col + ")");
            }
            bottom--;
        }

        if (left <= right) {
            for (int row = bottom; row >= top; row--) {
                System.out.print("(" + row + ", " + left + ")");
            }
            left++;
        }

        traverseSpiral(rows, cols, top, bottom, left, right);
    }

    public static void main(String[] args) {
        int rows = 4;
        int cols = 4;
        traverseSpiral(rows, cols, 0, rows - 1, 0, cols - 1);
    }
}
