class A {
    public int a = 1;
    protected int b = 2;
    int c = 3;                  // default
    private int d = 4;
    int getD() { return d; }    // private accessed through a method
}
public class Q7_Access {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.a + " " + obj.b + " " + obj.c);
        // System.out.println(obj.d);   // error: d has private access
        System.out.println(obj.getD());
    }
}
