// Q1c, Jun/Jul 2025 Makeup — Develop Java code to transpose a matrix.
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int rows = m.length, cols = m[0].length;
        int[][] transposed = new int[cols][rows]; // dimensions swap

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transposed[j][i] = m[i][j];

        System.out.println("Original matrix:");
        for (int[] row : m) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }

        System.out.println("Transposed matrix:");
        for (int[] row : transposed) {
            for (int v : row) System.out.print(v + " ");
            System.out.println();
        }
    }
}
