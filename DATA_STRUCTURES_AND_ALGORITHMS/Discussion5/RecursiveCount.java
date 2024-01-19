package DATA_STRUCTURES_AND_ALGORITHMS.Discussion5;

public class RecursiveCount {
    public static void main(String[] args) {
        int number = recursiveCount(0, 10);
        System.out.println(number);
    }

    public static int recursiveCount(int currentNum, int targetNum) {
        if ( currentNum == targetNum ) {
            return currentNum;
        } else {
            System.out.print(currentNum + " ");
            return recursiveCount(currentNum + 1, targetNum);
        }
    }
}

