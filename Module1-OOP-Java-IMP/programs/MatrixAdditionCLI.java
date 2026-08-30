// Q2b, Dec 2023/Jan 2024 — Add two matrices using command line arguments.
// Run as: java MatrixAdditionCLI 1 2 3 4 5 6 7 8   (first 4 = matrix A, next 4 = matrix B, for a 2x2)
public class MatrixAdditionCLI {
    public static void main(String[] args) {
        int size = 2; // 2x2 matrices, expects 8 command-line arguments total
        if (args.length < size * size * 2) {
            System.out.println("Please pass 8 integers as command line arguments (4 for A, 4 for B).");
            return;
        }

        int[][] a = new int[size][size];
        int[][] b = new int[size][size];
        int[][] result = new int[size][size];

        int idx = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                a[i][j] = Integer.parseInt(args[idx++]);

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                b[i][j] = Integer.parseInt(args[idx++]);

        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                result[i][j] = a[i][j] + b[i][j];

        System.out.println("Sum of matrices:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
