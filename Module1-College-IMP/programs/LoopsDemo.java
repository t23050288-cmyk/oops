public class LoopsDemo {
    public static void main(String[] args) {
        int i = 1;
        System.out.print("while: ");
        while (i <= 5) { System.out.print(i + " "); i++; }
        System.out.print("\ndo-while (runs once even if false): ");
        int j = 10;
        do { System.out.print(j + " "); j++; } while (j < 5);
        System.out.print("\nfor: ");
        for (int k = 1; k <= 5; k++) System.out.print(k + " ");
        System.out.print("\nfor-each: ");
        int[] arr = {10, 20, 30};
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
    }
}
