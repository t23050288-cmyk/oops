// Q1a Jun/Jul 2025, Q2b Jun/Jul 2024 & Jun/Jul 2025 Makeup — Control statements with a programming example.
public class ControlStatementsDemo {
    public static void main(String[] args) {
        // Selection: if
        int num = 7;
        if (num % 2 == 0) System.out.println("Even");
        else System.out.println("Odd");

        // Selection: switch
        switch (num % 3) {
            case 0: System.out.println("Divisible by 3"); break;
            default: System.out.println("Not divisible by 3");
        }

        // Iteration: while
        int i = 1;
        while (i <= 3) { System.out.print("while:" + i + " "); i++; }
        System.out.println();

        // Iteration: do-while
        int j = 1;
        do { System.out.print("do-while:" + j + " "); j++; } while (j <= 3);
        System.out.println();

        // Iteration: for
        for (int k = 1; k <= 3; k++) System.out.print("for:" + k + " ");
        System.out.println();

        // Iteration: for-each
        int[] arr = {10, 20, 30};
        for (int v : arr) System.out.print("for-each:" + v + " ");
        System.out.println();

        // Jump: break/continue
        for (int k = 1; k <= 5; k++) {
            if (k == 4) break;
            if (k == 2) continue;
            System.out.print("jump:" + k + " ");
        }
    }
}
