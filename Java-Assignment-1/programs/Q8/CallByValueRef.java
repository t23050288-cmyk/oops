class Value {
    void meth(int i, int j) { i *= 2; j /= 2; }          // primitives: copy of value
}
class Ref {
    int a, b;
    Ref(int i, int j) { a = i; b = j; }
    void meth(Ref o) { o.a *= 2; o.b /= 2; }              // object: copy of reference
}
public class CallByValueRef {
    public static void main(String[] args) {
        Value v = new Value();
        int a = 15, b = 20;
        System.out.println("a and b before call: " + a + " " + b);
        v.meth(a, b);
        System.out.println("a and b after call: " + a + " " + b);

        Ref ob = new Ref(15, 20);
        System.out.println("ob.a and ob.b before call: " + ob.a + " " + ob.b);
        ob.meth(ob);
        System.out.println("ob.a and ob.b after call: " + ob.a + " " + ob.b);
    }
}
