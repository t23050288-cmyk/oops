public class Q3_Conversion {
    public static void main(String[] args) {
        int i = 10;
        double d = i;              // type conversion (automatic)
        System.out.println(d);     // 10.0
        double x = 9.7;
        int y = (int) x;           // type casting (manual)
        System.out.println(y);     // 9
    }
}
