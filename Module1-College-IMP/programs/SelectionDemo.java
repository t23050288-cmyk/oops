public class SelectionDemo {
    public static void main(String[] args) {
        int marks = 72;
        // simple if
        if (marks >= 35) System.out.println("Pass");
        // if-else
        if (marks % 2 == 0) System.out.println("Even"); else System.out.println("Odd");
        // if-else-if ladder
        if (marks >= 90) System.out.println("Grade S");
        else if (marks >= 70) System.out.println("Grade A");
        else if (marks >= 50) System.out.println("Grade B");
        else System.out.println("Grade C");
        // nested if
        int age = 20; boolean hasId = true;
        if (age >= 18) { if (hasId) System.out.println("Can vote"); }
        // switch (with fall-through shown)
        int day = 3;
        switch (day) {
            case 1: System.out.println("Mon"); break;
            case 2: System.out.println("Tue"); break;
            case 3: System.out.println("Wed"); break;
            default: System.out.println("Other");
        }
        switch (2) { case 1: System.out.print("one "); case 2: System.out.print("two "); case 3: System.out.println("three"); }
    }
}
