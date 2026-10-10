public class Q8_CallByValue {
    static void change(int x) {          // primitive: copy of value
        x = 100;
    }
    static void change(int[] arr) {      // reference: copy of address
        arr[0] = 100;
    }
    public static void main(String[] args) {
        int n = 10;
        change(n);
        System.out.println(n);           // 10 (not changed)
        int[] a = {10, 20};
        change(a);
        System.out.println(a[0]);        // 100 (changed)
    }
}
