// Q1b, Dec 2025/Jan 2026 — Define array; calculate average among elements {8, 6, 2, 7}.
public class AverageArray {
    public static void main(String[] args) {
        // an array is a collection of same-type elements stored under one variable name
        int[] elements = {8, 6, 2, 7};
        int sum = 0;

        for (int i = 0; i < elements.length; i++) {
            sum += elements[i];
        }

        double average = sum / (double) elements.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
