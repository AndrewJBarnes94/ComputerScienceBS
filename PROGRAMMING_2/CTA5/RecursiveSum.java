package PROGRAMMING_2.CTA5;

public class RecursiveSum {
    public static void main(String[] args) {
        int number = recursiveSum(5, 0);
        System.out.println(number);
    }

    public static int recursiveSum(int number, int sum) {
        if (number == 0) {
            return sum;
        } else {
            return recursiveSum(number - 1, sum + number);
        }
    }
}
