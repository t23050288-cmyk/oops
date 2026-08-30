# BCS306A — Dec 2025/Jan 2026 Exam
## Module 1: Overview of Java, Data Types, Operators, Control Statements

---

## Q.1 a) Explain features of Java. [7]

### Definition
Java is a high-level, object-oriented, platform-independent programming language. Its key features make it robust, secure, and portable.

### Points
1. **Simple** — syntax based on C/C++ but removes pointers and multiple inheritance of classes.
2. **Object-Oriented** — everything is built around objects and classes.
3. **Platform Independent** — compiles to bytecode, not native code. The same `.class` file runs on any OS with a JVM ("compile once, run anywhere").
4. **Robust** — strong type checking at compile time, automatic garbage collection, exception handling.
5. **Secure** — bytecode is verified before execution; no direct pointer/memory access.
6. **Multithreaded** — built-in support for concurrent execution.
7. **Architecture-neutral & portable** — `int` is always 4 bytes on every platform.
8. **High Performance** — Just-In-Time (JIT) compilation of bytecode.

### Flow
```
MyProg.java --(javac)--> MyProg.class (bytecode) --(JVM on any OS)--> Output
```

### Program
```java
class Hi { public static void main(String[] a){ System.out.println("Runs anywhere"); } }
```

---

## Q.1 b) Define array, write a Java program to calculate the average among the elements [8, 6, 2, 7]. [7]

### Definition
An array is a collection of elements of the **same data type**, stored in contiguous memory, referred to by a single variable name, and accessed via a zero-based index.

### Points
1. Arrays in Java are objects, created dynamically with `new`.
2. Size is fixed once created; `arrayName.length` gives the size.
3. Elements indexed from `0` to `length-1`.

### Program (`programs/AverageArray.java`)
```java
public class AverageArray {
    public static void main(String[] args) {
        int[] elements = {8, 6, 2, 7};
        int sum = 0;
        for (int i = 0; i < elements.length; i++) {
            sum += elements[i];
        }
        double average = sum / (double) elements.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int[] n={8,6,2,7}; int s=0; for(int v:n) s+=v; System.out.println(s/(double)n.length); } }
```

---

## Q.1 c) List and explain operators in Java with examples. [6]

### Definition
An operator is a special symbol that performs an operation on operands and produces a result.

### List with Examples

| Category | Operators | Example | Result |
|---|---|---|---|
| Arithmetic | `+ - * / %` | `10 + 3` | `13` |
| Unary | `++ -- !` | `int x=5; x++` | `5` (post) |
| Relational | `== != > < >= <=` | `10 > 3` | `true` |
| Logical | `&& \|\| !` | `true && false` | `false` |
| Assignment | `= += -= *= /= %=` | `a += 5` | `a = a+5` |
| Bitwise | `& \| ^ ~` | `5 & 3` | `1` |
| Shift | `<< >> >>>` | `5 << 1` | `10` |
| Ternary | `?:` | `10 > 3 ? 10 : 3` | `10` |
| instanceof | `instanceof` | `"hi" instanceof String` | `true` |

### Points
1. `&&` and `||` are short-circuit — skip second operand if first decides result.
2. `>>` preserves sign bit; `>>>` always fills with 0.
3. `~n = -(n+1)`.
4. Precedence (high→low): Postfix → Unary → `*/%` → `+-` → Shift → Relational → `==!=` → `&^|` → `&&||` → Ternary → Assignment.

### Program
```java
public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 10, b = 3;
        System.out.println(a + b);           // 13
        System.out.println(a / b);           // 3
        System.out.println(a % b);           // 1
        System.out.println(a > b);          // true
        System.out.println(a > 5 && b < 5); // true
        int x = 5;
        System.out.println(x++ + " " + ++x);// 5 7
        System.out.println(a > b ? a : b);  // 10
        System.out.println(a & b);          // 2
        System.out.println(a << 1);         // 20
    }
}
```

---

## Q.2 a) Explain OOP's features in Java. [7]

### Definition
Object-Oriented Programming (OOP) is a paradigm built around three core principles: Encapsulation, Inheritance, and Polymorphism. (Abstraction is sometimes included as a fourth.)

### 1. Encapsulation
Binding data and methods into a single unit (class) and protecting data from unauthorized access.

**Points:**
1. Data kept `private`, accessed via `public` getter/setter methods.
2. Also called **data hiding**.
3. Makes class easy to modify internally without breaking external code.

### 2. Inheritance
One class (subclass) acquires properties and behavior of another (superclass) using `extends`.

**Points:**
1. Promotes **code reusability** — common code written once in superclass.
2. Establishes **IS-A relationship** (Dog IS-A Animal).
3. Enables method overriding → runtime polymorphism.

### 3. Polymorphism
Same operation exhibits different behaviors depending on the object ("many forms").

**Points:**
1. Compile-time: **method overloading** (same name, different params).
2. Runtime: **method overriding** (subclass redefines superclass method).
3. One interface, multiple implementations.

### Programs

**Encapsulation:**
```java
class Student {
    private String name;
    private int marks;
    public void setDetails(String n, int m) { name = n; marks = m; }
    public void display() { System.out.println(name + " scored " + marks); }
}
public class EncapDemo {
    public static void main(String[] args) {
        Student s = new Student(); s.setDetails("Prahlad", 90); s.display();
    }
}
```

**Inheritance:**
```java
class Animal { void eat() { System.out.println("eats food"); } }
class Dog extends Animal { void bark() { System.out.println("barks"); } }
public class InhDemo {
    public static void main(String[] args) { Dog d = new Dog(); d.eat(); d.bark(); }
}
```

**Polymorphism:**
```java
class Shape { double area() { return 0; } }
class Circle extends Shape { double r; Circle(double r){this.r=r;} double area(){ return 3.14*r*r; } }
class Square extends Shape { double s; Square(double s){this.s=s;} double area(){ return s*s; } }
public class PolyDemo {
    public static void main(String[] args) {
        Shape s1 = new Circle(3), s2 = new Square(4);
        System.out.println("Circle: " + s1.area() + ", Square: " + s2.area());
    }
}
```

---

## Q.2 b) Write a Java program to sort the elements using a for loop. [7]

### Definition
Sorting arranges elements in a defined order (ascending here) using comparisons and swaps — **Bubble Sort** is the simplest for-loop-based approach.

### Points
1. Bubble sort: repeatedly compare adjacent elements, swap if out of order.
2. Needs a **nested for loop** — outer for passes, inner for comparisons.
3. After each pass, the largest remaining element "bubbles" to the end.

### Program (`programs/SortForLoop.java`)
```java
public class SortForLoop {
    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 14};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array:");
        for (int v : arr) System.out.print(v + " ");
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int[] n={5,2,4,1}; for(int i=0;i<n.length-1;i++)for(int j=0;j<n.length-1-i;j++)if(n[j]>n[j+1]){int t=n[j];n[j]=n[j+1];n[j+1]=t;} for(int v:n)System.out.print(v+" "); } }
```

---

## Q.2 c) With example, explain different types of if statement in Java. [6]

### Definition
The `if` statement is a selection statement that executes a block based on a boolean condition. There are 4 types.

### Types

1. **Simple if** — executes a block only if condition is true.
   ```java
   if (age >= 18) { System.out.println("Eligible"); }
   ```

2. **if-else** — runs one block if true, another if false.
   ```java
   if (age % 2 == 0) { System.out.println("Even"); }
   else { System.out.println("Odd"); }
   ```

3. **if-else-if ladder** — tests multiple conditions; first true wins.
   ```java
   if (marks >= 90) { System.out.println("A"); }
   else if (marks >= 75) { System.out.println("B"); }
   else if (marks >= 60) { System.out.println("C"); }
   else { System.out.println("D"); }
   ```

4. **Nested if** — an if inside another if; used when a decision depends on another.
   ```java
   if (age >= 18) {
       if (hasID) { System.out.println("Entry allowed"); }
       else { System.out.println("ID required"); }
   }
   ```

### Program (`programs/IfStatementTypes.java`)
```java
public class IfStatementTypes {
    public static void main(String[] args) {
        int age = 20;
        boolean hasID = true;
        int marks = 72;

        // 1. Simple if
        if (age >= 18) System.out.println("Simple if: Eligible to vote");

        // 2. if-else
        if (age % 2 == 0) System.out.println("if-else: age is even");
        else System.out.println("if-else: age is odd");

        // 3. if-else-if ladder
        if (marks >= 90) System.out.println("Ladder: Grade A");
        else if (marks >= 75) System.out.println("Ladder: Grade B");
        else if (marks >= 60) System.out.println("Ladder: Grade C");
        else System.out.println("Ladder: Grade D");

        // 4. Nested if
        if (age >= 18) {
            if (hasID) System.out.println("Nested if: Entry allowed");
            else System.out.println("Nested if: ID required");
        }
    }
}
```
