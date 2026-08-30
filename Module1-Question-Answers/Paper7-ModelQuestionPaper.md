# BCS306A — Model Question Paper (2023-24 CBCS Scheme)
## Module 1: Overview of Java, Data Types, Operators, Control Statements

---

## Q.01 a) Explain different lexical issues in Java. [7]

### Definition
Lexical issues (lexical structure/elements) are the basic rules that govern how Java source code is written using its character set, before the compiler can understand its meaning — i.e. how the smallest meaningful units (**tokens**) are formed.

### The 6 Lexical Issues

#### 1. Whitespace
1. Whitespace = space, tab, or newline.
2. Used to separate tokens and improve readability.
3. Extra whitespace between tokens is ignored by the compiler.
4. At least one whitespace is required between two tokens that would otherwise merge (e.g. `int` and `x` need a space, else `intx`).

#### 2. Identifiers
Names given by the programmer to variables, methods, classes, etc.
1. May contain letters (A-Z, a-z), digits (0-9), `_`, `$`.
2. Must **not** begin with a digit.
3. Case-sensitive — `Total` and `total` are different.
4. Cannot be a reserved keyword.
5. Valid: `AvgTemp`, `count`, `a_1`, `$salary`. Invalid: `2count`, `avg-temp`, `class`.

#### 3. Literals
A constant value written directly in code.
1. **Integer**: `10`, `0x1A` (hex), `0b1010` (binary).
2. **Floating-point**: `3.14`, `2.0f`.
3. **Character**: `'A'`, `'\n'`.
4. **String**: `"Hello World"`.
5. **Boolean**: `true` or `false`.
6. **Null**: `null` — absence of a reference.

#### 4. Comments
1. **Single-line**: `// comment`
2. **Multi-line**: `/* comment */` — cannot be nested.
3. **Documentation**: `/** ... */` — processed by `javadoc` tool.
4. All comments are ignored by the compiler.

#### 5. Separators

| Symbol | Name | Use |
|---|---|---|
| `()` | Parentheses | Method calls, parameter lists, grouping |
| `{}` | Braces | Defines a block (class/method/loop body) |
| `[]` | Brackets | Array declaration/indexing |
| `;` | Semicolon | Terminates a statement |
| `,` | Comma | Separates identifiers/parameters |
| `.` | Period | Package names, accessing members |

#### 6. Keywords
1. Reserved words with predefined meaning — cannot be used as identifiers.
2. Java has 50+ keywords: `abstract, boolean, break, byte, case, catch, char, class, continue, default, do, double, else, extends, final, finally, float, for, if, implements, import, instanceof, int, interface, long, new, package, private, protected, public, return, short, static, super, switch, this, throw, throws, try, void, while`, etc.
3. `const` and `goto` are reserved but not used.
4. `true`, `false`, `null` are reserved literals, not keywords.
5. Keywords are always lowercase.

---

## Q.01 b) Define Array. Write a Java program to implement the addition of two matrices. [7]

### Definition
An array is a collection of elements of the **same data type**, stored in contiguous memory, referred to by a single variable name, and accessed via a zero-based index.

### Points
1. Arrays in Java are objects, created with `new`; size is fixed once created.
2. `arrayName.length` gives the size.
3. A 2D array (matrix) is an array of arrays, with rows and columns.

### Program (`programs/MatrixAddition.java`)
```java
public class MatrixAddition {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] result = new int[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        System.out.println("Sum of matrices:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
```

---

## Q.01 c) Explain the following operations with examples: (i) << (ii) >> (iii) >>>. [6]

### Definition
These are **shift operators** — they shift the bits of an integer left or right.

### (i) `<<` (Left Shift)
1. Shifts bits to the **left**, fills right with 0.
2. `a << n = a × 2ⁿ`.
3. Example: `5 << 1` → `0000 0101` becomes `0000 1010` = `10`.

### (ii) `>>` (Signed Right Shift)
1. Shifts bits to the **right**, fills left with the **sign bit** (preserves sign).
2. `a >> n ≈ a / 2ⁿ` (integer division).
3. For negative numbers, the sign bit (1) is filled, keeping it negative.
4. Example: `-8 >> 1` → `-4` (sign preserved).

### (iii) `>>>` (Unsigned Right Shift)
1. Shifts bits to the **right**, **always** fills left with **0**, even for negatives.
2. A negative number becomes a large positive number.
3. Example: `-8 >>> 1` → `2147483644` (sign bit becomes 0).

### Key Difference: `>>` vs `>>>`
- `>>` = arithmetic shift (preserves sign).
- `>>>` = logical shift (always fills with 0).
- They give the **same result for positive numbers**, but **differ for negative numbers**.

### Program (`programs/ShiftAndBitwiseDemo.java`)
```java
public class ShiftAndBitwiseDemo {
    public static void main(String[] args) {
        int a = 5;
        System.out.println("5 << 1 = " + (a << 1));   // 10
        System.out.println("5 >> 1 = " + (a >> 1));    // 2
        System.out.println("5 >>> 1 = " + (a >>> 1));  // 2 (same as >> for positive)

        int neg = -8;
        System.out.println("-8 >> 1 = " + (neg >> 1));   // -4 (sign preserved)
        System.out.println("-8 >>> 1 = " + (neg >>> 1)); // 2147483644 (sign zeroed)
    }
}
```

---

## Q.02 a) Explain object-oriented principles. [7]

### Definition
Object-Oriented Programming is built on three core principles: Encapsulation, Inheritance, and Polymorphism. (Abstraction is often included as a fourth principle.)

### 1. Abstraction
Hiding unnecessary implementation details and exposing only essential features.

**Points:**
1. Focus on **what** an object does, not **how** it does it.
2. Achieved using **abstract classes** and **interfaces** in Java.
3. Allows internal implementation to change without breaking external code.

### 2. Encapsulation
Binding data and methods into a single unit (class) and protecting data from unauthorized access.

**Points:**
1. Data kept `private`, accessed via `public` methods.
2. Also called **data hiding**.
3. Makes class easy to modify internally without breaking external code.

### 3. Inheritance
One class (subclass) acquires properties and behavior of another (superclass) using `extends`.

**Points:**
1. Promotes **code reusability** — common code written once in superclass.
2. Establishes **IS-A relationship** (Dog IS-A Animal).
3. Enables method overriding → runtime polymorphism.

### 4. Polymorphism
Same operation exhibits different behaviors depending on the object.

**Points:**
1. Compile-time: **method overloading** (same name, different params).
2. Runtime: **method overriding** (subclass redefines superclass method).
3. One interface, multiple implementations.

### Programs

**Encapsulation:**
```java
class Student {
    private String name; private int marks;
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

## Q.02 b) Write a Java program to sort the elements using a for loop. [7]

### Definition
Sorting arranges elements in ascending order using comparisons and swaps — **Bubble Sort** is the simplest for-loop-based approach.

### Points
1. Repeatedly compare adjacent elements, swap if out of order.
2. Nested for loop — outer for passes, inner for comparisons.
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

---

## Q.02 c) Explain different types of if statements in Java. [6]

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

        if (age >= 18) System.out.println("Simple if: Eligible");
        if (age % 2 == 0) System.out.println("if-else: Even");
        else System.out.println("if-else: Odd");

        if (marks >= 90) System.out.println("A");
        else if (marks >= 75) System.out.println("B");
        else if (marks >= 60) System.out.println("C");
        else System.out.println("D");

        if (age >= 18) {
            if (hasID) System.out.println("Nested: Entry allowed");
            else System.out.println("Nested: ID required");
        }
    }
}
```
