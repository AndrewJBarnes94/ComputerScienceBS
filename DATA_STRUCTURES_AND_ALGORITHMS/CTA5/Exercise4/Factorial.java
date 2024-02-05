package DATA_STRUCTURES_AND_ALGORITHMS.CTA5.Exercise4;

public class Factorial {

    // Recursively multiply starting with "n" using tail recursion
    public static int factorialTailRecursion(int n, int result) {
        if (n == 0) {
            return result;
        } else {
            System.out.println("\t\t" + n + " * " + result + " = " + n * result);
            return factorialTailRecursion(n - 1, n * result);
        }
    }

    // Recursively multiply starting with 1 using head recursion
    public static int factorialHeadRecursion(int n) {
        if (n == 0) {
            return 1;
        } else {
            int recursiveResult = factorialHeadRecursion(n - 1);
            int result = n * recursiveResult;

            System.out.println("\t\t" + n + " * " + recursiveResult + " = " + result);
            
            return result;
        }
    }
}
