// Q2b, Jun/Jul 2025 — Add two matrices of suitable order N (generic size, not hardcoded).
import java.util.Scanner;

public class MatrixAdditionN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order N: ");
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] result = new int[n][n];

        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                b[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = a[i][j] + b[i][j];

        System.out.println("Sum of matrices:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
        sc.close();
    }
}
