public class Q6_Factorial {
    static int fact(int n) {
        if (n == 0 || n == 1)      // base case
            return 1;
        return n * fact(n - 1);    // recursive call
    }
    public static void main(String[] args) {
        System.out.println("Factorial of 5 = " + fact(5));
    }
}
