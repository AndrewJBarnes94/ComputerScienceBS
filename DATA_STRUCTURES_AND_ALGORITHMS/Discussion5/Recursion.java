package DATA_STRUCTURES_AND_ALGORITHMS.Discussion5;

class Recursion {
    
  public static void main(String[] args) {
    System.out.println(fibonacci(6));
  }
    
  static int fibonacci(int n) {
    if (n <= 1)
      return n;

    return fibonacci(n - 1) + fibonacci(n - 2);
  }
}

/*
  
6
5 4
4 3 3 2
3 2 2 1 2 1 1 0
2 1 0 1 0 1 0 1
0 1

*/



