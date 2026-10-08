public class ForVariations {
    public static void main(String[] args) {
        // 1. Standard
        for (int i = 1; i <= 3; i++) System.out.print(i + " ");
        System.out.println("<- standard");
        // 2. Multiple variables / comma operator
        for (int i = 0, j = 5; i < j; i++, j--) System.out.print("(" + i + "," + j + ") ");
        System.out.println("<- two variables");
        // 3. Missing init (declared outside)
        int k = 1;
        for (; k <= 3; k++) System.out.print(k + " ");
        System.out.println("<- no init");
        // 4. Missing update (updated inside body)
        for (int m = 1; m <= 3; ) { System.out.print(m + " "); m++; }
        System.out.println("<- no update");
        // 5. Infinite loop with break
        int n = 0;
        for (;;) { if (++n > 3) break; System.out.print(n + " "); }
        System.out.println("<- infinite with break");
        // 6. Empty body
        int sum = 0;
        for (int i = 1; i <= 5; sum += i++) ;
        System.out.println("sum=" + sum + " <- empty body");
        // 7. Nested
        for (int i = 1; i <= 3; i++) { for (int j = 1; j <= i; j++) System.out.print("* "); System.out.println(); }
        // 8. For-each
        for (String s : new String[]{"a", "b", "c"}) System.out.print(s + " ");
        System.out.println("<- for-each");
    }
}
