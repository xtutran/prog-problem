package exam;

public class Fib {

    // simple recursion
    static private int fibRecursive(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a positive integer");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            return fibRecursive(n - 1) + fibRecursive(n - 2);
        }
    }

    // iterative way
    static private int fibIterative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be a positive integer");
        } else if (n == 0 || n == 1) {
            return 1;
        } else {
            int fib = 0;
            int curr = 1;
            int prev = 0;
            for (int i = 0; i < n; i++) {
                fib = curr + prev;
                prev = curr;
                curr = fib;
            }
            return fib;
        }
    }

    public static void main(String[] args) {
        //0 1 2 3 4
        //1 1 2 3 5
        System.out.println("Iterative way");
        System.out.println(fibIterative(0));
        System.out.println(fibIterative(3));
        System.out.println(fibIterative(4));

        System.out.println("Recursion way");
        System.out.println(fibRecursive(0));
        System.out.println(fibRecursive(3));
        System.out.println(fibRecursive(4));
    }
}
