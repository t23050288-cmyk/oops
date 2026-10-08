public class JumpDemo {
    static int square(int n) { return n * n; }          // return with value
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) { if (i == 4) break; System.out.print(i + " "); }
        System.out.println("<- break");
        for (int i = 1; i <= 5; i++) { if (i == 3) continue; System.out.print(i + " "); }
        System.out.println("<- continue");
        outer:
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++) {
                if (j == 2) continue outer;              // labeled continue
                if (i == 3) break outer;                 // labeled break
                System.out.print("(" + i + "," + j + ") ");
            }
        System.out.println("<- labeled");
        System.out.println(square(6) + " <- return");
    }
}
