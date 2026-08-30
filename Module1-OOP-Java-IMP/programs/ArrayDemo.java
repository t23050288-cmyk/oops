// Undated Paper Q2a — How arrays are defined and used in Java; examples.
public class ArrayDemo {
    public static void main(String[] args) {
        // 1D array — declaration + initialization
        int[] marks = {90, 85, 76, 60};

        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Index " + i + ": " + marks[i]);
            sum += marks[i];
        }
        System.out.println("Total: " + sum + ", Average: " + (sum / (double) marks.length));

        // 2D array — declaration + initialization
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("2D array element at [1][2]: " + matrix[1][2]);
    }
}
