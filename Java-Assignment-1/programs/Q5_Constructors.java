class Student {
    int id;
    String name;
    Student() {                       // default constructor
        id = 0;
        name = "unknown";
    }
    Student(int i, String n) {        // parameterized constructor
        id = i;
        name = n;
    }
    Student(Student s) {              // copy constructor
        id = s.id;
        name = s.name;
    }
    void show() {
        System.out.println(id + " " + name);
    }
}
public class Q5_Constructors {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(101, "Ravi");
        Student s3 = new Student(s2);
        s1.show();
        s2.show();
        s3.show();
    }
}
