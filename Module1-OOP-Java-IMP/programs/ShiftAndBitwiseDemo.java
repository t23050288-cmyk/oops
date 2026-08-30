// Q2a Dec 2023/Jan 2024, Q01c Model Paper — Illustrate >>, >>> and other bitwise operators.
public class ShiftAndBitwiseDemo {
    public static void main(String[] args) {
        int a = 5, b = 3;
        System.out.println("a & b = " + (a & b));    // 1
        System.out.println("a | b = " + (a | b));    // 7
        System.out.println("a ^ b = " + (a ^ b));    // 6
        System.out.println("~a    = " + (~a));       // -6
        System.out.println("a << 1 = " + (a << 1));  // 10

        int neg = -8;
        System.out.println("-8 >> 1  = " + (neg >> 1));   // -4  (sign preserved)
        System.out.println("-8 >>> 1 = " + (neg >>> 1));  // 2147483644 (sign bit zeroed)
    }
}
