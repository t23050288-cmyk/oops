public class ForLoopDemo {
    public static void main(String[] args) {
        // standard
        for (int i = 1; i <= 10; i++) {
            if (i == 5) { System.out.println("ended"); break; }
            System.out.println(i);
        }
        // multiple variables
        for (int i = 0, j = 5; i < j; i++, j--) System.out.print("(" + i + "," + j + ") ");
        System.out.println();
        // missing initialization
        int k = 1;
        for (; k <= 3; k++) System.out.print(k + " ");
        System.out.println();
        // missing update
        for (int m = 1; m <= 3; ) { System.out.print(m + " "); m++; }
        System.out.println();
        // infinite loop with break
        int n = 0;
        for (;;) { if (++n > 3) break; System.out.print(n + " "); }
        System.out.println();
        // empty body
        int sum = 0;
        for (int i = 1; i <= 5; sum += i++) ;
        System.out.println("sum = " + sum);
        // nested
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
        // for-each
        int[] a = {10, 20, 30};
        for (int x : a) System.out.print(x + " ");
        System.out.println();
    }
}
