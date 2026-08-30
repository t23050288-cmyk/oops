// Q2b, Dec 2024/Jan 2025 — With a Java program, illustrate the ternary operator to find the greatest of three numbers.
public class TernaryGreatest {
    public static void main(String[] args) {
        int a = 15, b = 42, c = 27;

        int greatest = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);

        System.out.println("Greatest of " + a + ", " + b + ", " + c + " is: " + greatest);
    }
}
