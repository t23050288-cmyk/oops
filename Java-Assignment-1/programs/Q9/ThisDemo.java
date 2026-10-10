class Box {
    double width, height, depth;
    Box(double width, double height, double depth) {   // parameter names hide instance variables
        this.width = width;                            // this.width = instance variable
        this.height = height;
        this.depth = depth;
    }
    Box() { this(1, 1, 1); }                           // this() calls another constructor
    Box getBox() { return this; }                      // returns current object
    double volume() { return this.width * this.height * this.depth; }
}
public class ThisDemo {
    public static void main(String[] args) {
        Box b1 = new Box(10, 20, 15);
        Box b2 = new Box();
        System.out.println(b1.volume());
        System.out.println(b2.volume());
        System.out.println(b1.getBox() == b1);
    }
}
