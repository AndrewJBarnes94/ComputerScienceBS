package PROGRAMMING_2.Discussion5;

public class RecursiveCount2 {
    static void printNumbers(int n)
    {
        if (n > 0) {
            printNumbers(n - 1);
            System.out.print(n + " ");
        }
        return;
    }

    public static void main(String[] args)
    {
        int n = 10;
        printNumbers(n);
    }
}
