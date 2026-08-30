// Q2c, Undated Paper — Explain jump statements: break and continue.
public class BreakContinueDemo {
    public static void main(String[] args) {
        System.out.println("break demo (stop loop when i == 5):");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                break;              // exits the loop completely
            }
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("continue demo (skip even numbers):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;           // skips rest of this iteration, goes to next i
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
