// Q2c Dec 2025/Jan 2026, Q02c Model Paper — Different types of if statement in Java, with examples.
public class IfStatementTypes {
    public static void main(String[] args) {
        int age = 20;
        boolean hasID = true;
        int marks = 72;

        // 1. Simple if
        if (age >= 18) {
            System.out.println("Simple if: Eligible to vote");
        }

        // 2. if-else
        if (age % 2 == 0) {
            System.out.println("if-else: age is even");
        } else {
            System.out.println("if-else: age is odd");
        }

        // 3. if-else-if ladder
        if (marks >= 90) {
            System.out.println("Ladder: Grade A");
        } else if (marks >= 75) {
            System.out.println("Ladder: Grade B");
        } else if (marks >= 60) {
            System.out.println("Ladder: Grade C");
        } else {
            System.out.println("Ladder: Grade D");
        }

        // 4. Nested if
        if (age >= 18) {
            if (hasID) {
                System.out.println("Nested if: Entry allowed");
            } else {
                System.out.println("Nested if: ID required");
            }
        } else {
            System.out.println("Nested if: Underage, entry denied");
        }
    }
}
