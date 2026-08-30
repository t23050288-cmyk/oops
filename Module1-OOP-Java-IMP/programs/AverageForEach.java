// Q1c, Undated Paper — Develop a program to find average among elements {1,2,3,4,5} using for-each loop.
public class AverageForEach {
    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int value : elements) {   // for-each loop, no index used
            sum += value;
        }

        double average = sum / (double) elements.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
