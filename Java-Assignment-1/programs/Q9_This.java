class Student {
    int id;
    String name;
    Student(int id, String name) {
        this.id = id;                // this.id = instance variable, id = parameter
        this.name = name;
    }
    Student() {
        this(0, "unknown");          // calls the other constructor
    }
    Student getObject() {
        return this;                 // returns current object
    }
    void show() {
        System.out.println(this.id + " " + this.name);
    }
}
public class Q9_This {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Ravi");
        Student s2 = new Student();
        s1.getObject().show();
        s2.show();
    }
}
