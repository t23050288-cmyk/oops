// Q2c, Dec 2024/Jan 2025 — for-each version of for loop: initialize 2D array, print using for-each.
public class ForEach2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // outer for-each gives each row (a 1D array); inner for-each gives each element
        for (int[] row : arr) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
