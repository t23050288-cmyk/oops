// Q1a, Dec 2023/Jan 2024 — Data types, default values, and literals.
public class DataTypesDemo {
    static int instanceInt;          // instance fields get default values automatically
    static boolean instanceBool;

    public static void main(String[] args) {
        byte b = 100;
        short s = 20000;
        int i = 50000;
        long l = 15000000000L;       // 'L' required — exceeds int's range
        float f = 10.5f;             // 'f' required — else treated as double
        double d = 3.14159;
        char c = 'A';
        boolean flag = true;

        System.out.println("byte=" + b + " short=" + s + " int=" + i);
        System.out.println("long=" + l + " float=" + f + " double=" + d);
        System.out.println("char=" + c + " boolean=" + flag);
        System.out.println("default int field=" + instanceInt + ", default boolean field=" + instanceBool);
    }
}
