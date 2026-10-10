public class MatrixAdd {
    public static void main(String[] args) {
        int[] a = new int[5];                 // creation: default values 0
        a[0] = 10;                            // initialization using index
        int[] b = {10, 20, 30};               // initialization at declaration
        int[] c = new int[3];
        for (int i = 0; i < 3; i++) c[i] = i * 10;   // initialization using loop
        System.out.println(a[0] + " " + a[1] + " | " + b[2] + " | " + c[2] + " | length = " + b.length);

        int[][] m1 = {{1, 2}, {3, 4}};
        int[][] m2 = {{5, 6}, {7, 8}};
        int[][] sum = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                sum[i][j] = m1[i][j] + m2[i][j];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) System.out.print(sum[i][j] + " ");
            System.out.println();
        }
    }
}
