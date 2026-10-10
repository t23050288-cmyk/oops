public class ConversionDemo {
    public static void main(String[] args) {
        // type conversion (automatic / widening)
        int i = 100;
        long l = i;
        float f = l;
        double d = f;
        System.out.println(i + " " + l + " " + f + " " + d);
        // type casting (manual / narrowing)
        double x = 9.99;
        int y = (int) x;
        System.out.println(x + " -> " + y);
        int big = 300;
        byte b = (byte) big;
        System.out.println(big + " -> " + b);
        // char and int
        char c = 'A';
        int code = c;
        char next = (char) (c + 1);
        System.out.println(c + " " + code + " " + next);
        // automatic type promotion
        byte p = 50, q = 20;
        int r = p * q;
        System.out.println(r);
        // int division vs cast
        System.out.println(7 / 2);
        System.out.println((double) 7 / 2);
    }
}
