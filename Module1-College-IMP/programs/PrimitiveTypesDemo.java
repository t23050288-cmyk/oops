public class PrimitiveTypesDemo {
    static byte db; static short ds; static int di; static long dl;
    static float df; static double dd; static char dc; static boolean dbo;
    public static void main(String[] args) {
        byte b = 100; short s = 20000; int i = 50000; long l = 15000000000L;
        float f = 10.5f; double d = 3.14159; char c = 'A'; boolean flag = true;
        System.out.println("byte=" + b + " short=" + s + " int=" + i + " long=" + l);
        System.out.println("float=" + f + " double=" + d + " char=" + c + " boolean=" + flag);
        System.out.println("Ranges: byte " + Byte.MIN_VALUE + ".." + Byte.MAX_VALUE
            + ", short " + Short.MIN_VALUE + ".." + Short.MAX_VALUE);
        System.out.println("int " + Integer.MIN_VALUE + ".." + Integer.MAX_VALUE);
        System.out.println("long " + Long.MIN_VALUE + ".." + Long.MAX_VALUE);
        System.out.println("Defaults: " + db + " " + ds + " " + di + " " + dl + " " + df + " " + dd + " [" + (int) dc + "] " + dbo);
    }
}
