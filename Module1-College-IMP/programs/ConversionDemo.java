public class ConversionDemo {
    public static void main(String[] args) {
        // Widening (automatic)
        int i = 100; long l = i; float f = l; double d = f;
        System.out.println(i + " " + l + " " + f + " " + d);
        // Narrowing (explicit cast)
        double x = 9.99; int y = (int) x;                // fraction truncated
        System.out.println(x + " -> " + y);
        int big = 300; byte b = (byte) big;              // 300 % 256 = 44
        System.out.println(big + " -> " + b);
        // char <-> int
        char c = 'A'; int code = c; char next = (char)(c + 1);
        System.out.println(c + " " + code + " " + next);
        // Automatic promotion in expressions
        byte p = 50, q = 20; int r = p * q;               // promoted to int
        System.out.println(r);
        // int / int vs cast
        System.out.println(7 / 2 + " " + (double) 7 / 2);
    }
}
