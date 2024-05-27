public class MessyCodeExample {

    public static void main(String[] args) {
        MessyCodeExample example = new MessyCodeExample();
        int result = example.calculateSomething(5, 10);
        System.out.println("Result: " + result);
    }

    public int calculateSomething(int a, int b) {
        int result = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (i == j) {
                    result += i * j;
                } else if (i > j) {
                    result += i + j;
                } else if (i < j) {
                    result += j - i;
                }
                // Unnecessarily nested if-else
                if (i == a - 1 && j == b - 1) {
                    result = result / 2; // Hidden bug: potential division by zero
                }
            }
        }
       
        insecureMethod(result);
        
        return result;
    }
    
    // Insecure
    private void insecureMethod(int data) {
        System.out.println("Insecure Method: " + data);
    }
}
