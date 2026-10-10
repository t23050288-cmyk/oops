public class Q2_ForLoop {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                System.out.println("ended");
                break;
            }
            System.out.println(i);
        }
        int[] a = {10, 20, 30};
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
}
