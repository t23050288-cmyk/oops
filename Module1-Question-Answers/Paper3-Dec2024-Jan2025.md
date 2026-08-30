# BCS306A — Dec 2024/Jan 2025 Exam
## Module 1: Overview of Java, Data Types, Operators, Control Statements

---

## Q.1 a) List and explain any three features of object oriented programming. [6]

### Definition
Object-Oriented Programming (OOP) is a paradigm built around three core principles: Encapsulation, Inheritance, and Polymorphism.

### Feature 1: Encapsulation
Binding data and the methods that operate on it into a single unit (a `class`), and protecting that data from outside/unauthorized access.

**Points:**
1. Combines data (fields) + behavior (methods) into one unit.
2. Data is usually kept `private`, accessed only via `public` getter/setter methods.
3. Also called **data hiding**.
4. Makes the class easy to modify internally without breaking external code.

### Feature 2: Inheritance
The mechanism by which one class (subclass) acquires the properties and behavior of another class (superclass). Uses the `extends` keyword.

**Points:**
1. Promotes **code reusability** — common code written once in superclass.
2. Establishes an **IS-A relationship** (Dog IS-A Animal).
3. Supports hierarchical classification.
4. Enables method overriding → runtime polymorphism.

### Feature 3: Polymorphism
The ability of the same operation to exhibit different behaviors depending on the object ("many forms").

**Points:**
1. Two types: **compile-time (overloading)** and **runtime (overriding)**.
2. One interface, multiple implementations.
3. Increases flexibility and extensibility.

### Programs

**Encapsulation:**
```java
class Student {
    private String name;
    private int marks;
    public void setDetails(String n, int m) { name = n; marks = m; }
    public void display() { System.out.println(name + " scored " + marks); }
}
public class EncapsulationDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.setDetails("Prahlad", 90);
        s.display();
    }
}
```

**Inheritance:**
```java
class Animal { void eat() { System.out.println("This animal eats food"); } }
class Dog extends Animal { void bark() { System.out.println("Dog barks"); } }
public class InheritanceDemo {
    public static void main(String[] args) { Dog d = new Dog(); d.eat(); d.bark(); }
}
```

**Polymorphism:**
```java
class Shape { double area() { return 0; } }
class Circle extends Shape { double r; Circle(double r){this.r=r;} double area(){ return 3.14*r*r; } }
class Square extends Shape { double s; Square(double s){this.s=s;} double area(){ return s*s; } }
public class PolymorphismDemo {
    public static void main(String[] args) {
        Shape sh1 = new Circle(3); Shape sh2 = new Square(4);
        System.out.println("Circle: " + sh1.area() + ", Square: " + sh2.area());
    }
}
```

---

## Q.1 b) What do you mean by type conversion and type casting? Give examples. [8]

### Type Conversion (Implicit/Widening)
**Definition:** Automatic conversion of a *smaller* type to a *larger, compatible* type. No data loss, done by the compiler.

**Points:**
1. Widening order: `byte → short → int → long → float → double`, and `char → int`.
2. No syntax needed — happens automatically.
3. Safe — no data loss.

### Type Casting (Explicit/Narrowing)
**Definition:** Manual conversion of a *larger* type to a *smaller* one using the **cast operator** `(targetType)`. May lose data/precision.

**Points:**
1. Cast syntax: `(targetType) value`
2. `double → int` **truncates** (chops decimal), does **not** round. e.g. `(int) 199.99` → `199`.
3. Risky — possible data loss, so programmer must do it explicitly.

### Comparison Table

| Basis | Widening (Implicit) | Narrowing (Explicit/Casting) |
|---|---|---|
| Direction | Small → Large | Large → Small |
| Done by | Compiler | Programmer, with `(type)` |
| Data loss | None | Possible |
| Example | `int → double` | `double → int` |

### Program (`programs/TypeConversionCasting.java`)
```java
public class TypeConversionCasting {
    public static void main(String[] args) {
        // Implicit widening
        int num = 100;
        double d = num;             // int -> double, automatic
        char ch = 'A';
        int code = ch;              // char -> int, automatic

        // Explicit narrowing / casting
        double price = 199.99;
        int rounded = (int) price;  // must cast; truncates to 199

        System.out.println("Widened double: " + d + ", widened int: " + code);
        System.out.println("Narrowed (cast) int: " + rounded);
    }
}
```

---

## Q.1 c) How to declare and initialize 1-D and 2-D arrays in Java. Give examples. [6]

### 1-D Array
**Definition:** A 1D array is a collection of same-type elements stored in contiguous memory, accessed via a zero-based index.

**Syntax:**
```java
dataType[] arrayName = new dataType[size];          // declare + allocate
int[] numbers = {10, 20, 30, 40};                    // declare + initialize
```

**Program:**
```java
public class Array1D {
    public static void main(String[] args) {
        int[] marks = {90, 85, 76, 60};
        for (int i = 0; i < marks.length; i++)
            System.out.println("Index " + i + ": " + marks[i]);
    }
}
```

### 2-D Array
**Definition:** A 2D array is an array of arrays — represents data as a table/matrix with rows and columns.

**Syntax:**
```java
dataType[][] arrayName = new dataType[rows][cols];
int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };
```

**Program:**
```java
public class Array2D {
    public static void main(String[] args) {
        int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++)
                System.out.print(arr[i][j] + "\t");
            System.out.println();
        }
    }
}
```

---

## Q.2 a) List the short circuit operators and show the concept using few examples. [4]

### Definition
`&&` (AND) and `||` (OR) are short-circuit logical operators that skip evaluating the second operand when the first already determines the result.

### Points
1. In `A && B`, if `A` is `false`, `B` is **never evaluated**.
2. In `A || B`, if `A` is `true`, `B` is **never evaluated**.
3. `&` and `|` are non-short-circuit versions — always evaluate both sides.
4. Safer for null checks: `if (obj != null && obj.value > 0)`.

### Examples
```java
public class ShortCircuitDemo {
    public static void main(String[] args) {
        int x = 10;
        // Short-circuit && : second condition not checked if first is false
        if (x > 100 && x++ > 0) { }   // x++ never runs because x>100 is false
        System.out.println("x = " + x);  // x still 10

        // Non-short-circuit & : both sides always evaluated
        if (x > 100 & x++ > 0) { }    // x++ DOES run even though x>100 is false
        System.out.println("x = " + x);  // x is now 11

        // Safe null check with short-circuit
        String s = null;
        if (s != null && s.length() > 0) System.out.println("has text");
        else System.out.println("safe — no NullPointerException");
    }
}
```

---

## Q.2 b) With a Java program, illustrate the use of ternary operator to find the greatest of three numbers. [6]

### Definition
The ternary operator is Java's only 3-operand operator; a shorthand for simple `if-else`.

### Syntax
```java
variable = (condition) ? valueIfTrue : valueIfFalse;
```

### Points
1. Evaluates `condition`; if `true` returns first value, else second.
2. Can be chained for multiple conditions.
3. Common use: finding min/max without writing full `if-else`.

### Program (`programs/TernaryGreatest.java`)
```java
public class TernaryGreatest {
    public static void main(String[] args) {
        int a = 15, b = 42, c = 27;
        int greatest = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);
        System.out.println("Greatest of " + a + ", " + b + ", " + c + " is: " + greatest);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=10,y=20,z=15; System.out.println(x>y?(x>z?x:z):(y>z?y:z)); } }
```

---

## Q.2 c) Develop a Java program to demonstrate the working of for-each version of for loop. Initialize the 2D array with values and print them using for-each. [10]

### Definition
The for-each loop (enhanced for) cycles through arrays/collections sequentially without using an index.

### Syntax
```java
for (dataType[] row : array2D) {
    for (dataType value : row) { ... }
}
```

### Points
1. Outer for-each gives each **row** (a 1D array); inner for-each gives each **element**.
2. No manual index/counter — avoids boundary errors.
3. **Read-only** — changing the loop variable does not change the original array.

### Program (`programs/ForEach2DArray.java`)
```java
public class ForEach2DArray {
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int[] row : arr) {
            for (int value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }
}
```
