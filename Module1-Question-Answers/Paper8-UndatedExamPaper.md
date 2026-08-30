# BCS306A — Undated Exam Paper
## Module 1: Overview of Java, Data Types, Operators, Control Statements

---

## Q.1 a) List and explain OOP's principles in Java. [8]

### Definition
Object-Oriented Programming (OOP) is built on three core principles: Encapsulation, Inheritance, and Polymorphism. (Abstraction is often included as a fourth.)

### 1. Abstraction
Hiding unnecessary implementation details and exposing only essential features.

**Points:**
1. Focus on **what** an object does, not **how** it does it.
2. Achieved using **abstract classes** and **interfaces** in Java.
3. Allows internal implementation to change without breaking external code.
4. Manages complexity in large systems by hiding internal detail.

**Syntax (interface = pure abstraction):**
```java
interface Shape { double area(); }   // only WHAT, not HOW
```

### 2. Encapsulation
Binding data and methods into a single unit (class) and protecting data from unauthorized access.

**Points:**
1. Combines data (fields) + behavior (methods) into one unit.
2. Data kept `private`, accessed via `public` getter/setter methods.
3. Also called **data hiding**.
4. Makes class easy to modify internally without breaking external code.
5. The `class` is Java's basic mechanism for encapsulation.

**Syntax:**
```java
class ClassName {
    private dataType field;
    public returnType getField() { ... }
    public void setField(dataType v) { ... }
}
```

### 3. Inheritance
One class (subclass) acquires properties and behavior of another (superclass) using `extends`.

**Points:**
1. Promotes **code reusability** — common code written once in superclass.
2. Establishes **IS-A relationship** (Dog IS-A Animal).
3. Supports hierarchical classification.
4. Enables method overriding → runtime polymorphism.
5. Java supports single, multilevel, and hierarchical inheritance (not multiple inheritance of classes).

**Syntax:**
```java
class Superclass { ... }
class Subclass extends Superclass { ... }
```

### 4. Polymorphism
Same operation exhibits different behaviors depending on the object ("many forms").

**Points:**
1. Compile-time: **method overloading** (same name, different params, same class).
2. Runtime: **method overriding** (subclass redefines superclass method, same signature).
3. One interface, multiple implementations.
4. Increases flexibility and extensibility.

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

## Q.1 b) Given class HelloWorld with for loop (int b = -1, b = 50, System.out.println), what is the output? [6]

### Note
The original question in the scanned source PDF was partially garbled (OCR artifact). The standard version of this question type asks you to trace the output of a `for` loop. Here is the template method to trace *any* similar `for` loop:

### Tracing Method
1. Write out the variable value at the start of each iteration.
2. Check the condition — if false, loop stops.
3. Execute the body (print/act).
4. Apply the update step.
5. Repeat until the condition fails.

### Example (standard version)
```java
class HelloWorld {
    public static void main(String[] args) {
        for (int b = 1; b <= 5; b++) {
            System.out.println(b);
        }
    }
}
```

### Trace

| Iteration | b (before) | Condition (b<=5) | Print | b (after update) |
|---|---|---|---|---|
| 1 | 1 | true | 1 | 2 |
| 2 | 2 | true | 2 | 3 |
| 3 | 3 | true | 3 | 4 |
| 4 | 4 | true | 4 | 5 |
| 5 | 5 | true | 5 | 6 |
| 6 | 6 | false | — | loop ends |

### Output
```
1
2
3
4
5
```

### Program (`programs/ForLoopTrace.java`)
```java
public class ForLoopTrace {
    public static void main(String[] args) {
        for (int b = 1; b <= 5; b++) {
            System.out.println(b);
        }
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ for(int b=1;b<=5;b++) System.out.println(b); } }
```

---

## Q.1 c) Develop a program to find average among elements {1, 2, 3, 4, 5} using for-each loop. [6]

### Definition
The for-each loop (enhanced for) cycles through arrays sequentially without using an index.

### Syntax
```java
for (dataType variable : array) { ... }
```

### Points
1. No manual index/counter — avoids boundary errors.
2. Sum all elements, divide by `array.length`.
3. Cast to `double` before dividing to avoid integer division truncation.

### Program (`programs/AverageForEach.java`)
```java
public class AverageForEach {
    public static void main(String[] args) {
        int[] elements = {1, 2, 3, 4, 5};
        int sum = 0;

        for (int value : elements) {   // for-each loop
            sum += value;
        }

        double average = sum / (double) elements.length;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int[] n={1,2,3,4,5}; int s=0; for(int v:n) s+=v; System.out.println(s/(double)n.length); } }
```

---

## Q.2 a) How arrays are defined and used in Java? Give examples. [6]

### Definition
An array is a collection of elements of the **same data type**, stored in contiguous memory, referred to by a single variable name, and accessed via a zero-based index.

### Points
1. Arrays in Java are **objects**, created dynamically with `new`; size is fixed once created.
2. `arrayName.length` gives the size — it's a **field**, not a method.
3. Elements are indexed from `0` to `length-1`.
4. The reference variable lives in the stack; actual elements live in the heap.
5. Can be **1D** (list) or **2D** (table/matrix).

### 1D Array Syntax
```java
int[] arr = new int[5];              // declare + allocate
int[] arr = {10, 20, 30};           // declare + initialize
```

### 2D Array Syntax
```java
int[][] matrix = new int[3][3];
int[][] matrix = { {1,2}, {3,4} };
```

### Program (`programs/ArrayDemo.java`)
```java
public class ArrayDemo {
    public static void main(String[] args) {
        // 1D array
        int[] marks = {90, 85, 76, 60};
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Index " + i + ": " + marks[i]);
            sum += marks[i];
        }
        System.out.println("Total: " + sum + ", Average: " + (sum / (double) marks.length));

        // 2D array
        int[][] matrix = { {1, 2, 3}, {4, 5, 6} };
        System.out.println("2D element [1][2]: " + matrix[1][2]);
    }
}
```

---

## Q.2 b) Briefly explain the various primitive data types used in Java. [6]

### Definition
Primitive data types are the 8 built-in types in Java that store the **actual value** directly in memory. They are not objects.

### The 8 Primitive Types

| Type | Size | Default | Use |
|---|---|---|---|
| `byte` | 1 byte | `0` | -128 to 127; saves memory in large arrays |
| `short` | 2 bytes | `0` | -32,768 to 32,767 |
| `int` | 4 bytes | `0` | most commonly used integer type |
| `long` | 8 bytes | `0L` | very large integers; needs `L` suffix |
| `float` | 4 bytes | `0.0f` | decimal; needs `f` suffix |
| `double` | 8 bytes | `0.0` | default decimal type |
| `char` | 2 bytes | `'\u0000'` | single 16-bit Unicode character |
| `boolean` | 1 bit | `false` | only `true` or `false` |

### Points
1. Four groups: Integer (`byte, short, int, long`), Floating-point (`float, double`), Character (`char`), Boolean (`boolean`).
2. `int` is the default type for integer literals.
3. `long` needs `L` suffix for values exceeding `int` range.
4. `double` is the default type for decimal literals; `float` needs `f`.
5. `char` stores Unicode (not just ASCII) — can also hold a numeric code.
6. Primitives cannot be `null`; non-primitive types can.
7. Primitives store actual value in stack; non-primitives store reference to heap.

### Program (`programs/DataTypesDemo.java`)
```java
public class DataTypesDemo {
    static int instanceInt;       // default 0
    static boolean instanceBool;  // default false
    public static void main(String[] args) {
        byte b = 100; short s = 20000; int i = 50000;
        long l = 15000000000L; float f = 10.5f; double d = 3.14159;
        char c = 'A'; boolean flag = true;
        System.out.println("byte="+b+" short="+s+" int="+i);
        System.out.println("long="+l+" float="+f+" double="+d);
        System.out.println("char="+c+" boolean="+flag);
        System.out.println("defaults: int="+instanceInt+" boolean="+instanceBool);
    }
}
```

---

## Q.2 c) Explain the following jump statements: (i) Break (ii) Continue. [8]

### Definition
Jump statements alter the normal flow of a loop by exiting or skipping iterations.

### (i) Break

**Definition:** `break` exits a loop or `switch` statement immediately, skipping any remaining iterations.

**Points:**
1. **Unlabeled `break`** exits only the **innermost** loop.
2. **Labeled `break`** (`break label;`) exits an **outer** loop directly from inside a nested loop.
3. Also used in `switch` to prevent fall-through.
4. After `break`, execution continues with the statement after the loop/switch.

**Syntax:**
```java
break;           // unlabeled
break label;     // labeled
```

**Program:**
```java
public class BreakDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i == 5) break;     // stops at 5
            System.out.print(i + " ");   // prints 1 2 3 4
        }
    }
}
```

**Labeled break:**
```java
outer:
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        if (i == 2 && j == 2) break outer;   // exits outer loop
        System.out.println("i=" + i + " j=" + j);
    }
}
```

### (ii) Continue

**Definition:** `continue` skips the **rest of the current iteration** and jumps to the loop's condition check (for `while`/`do-while`) or update step (for `for`).

**Points:**
1. Does **not** exit the loop — just skips to the next iteration.
2. **Labeled `continue`** skips to the next iteration of an **outer** loop.
3. Used to skip specific values/conditions without stopping the loop.

**Syntax:**
```java
continue;         // unlabeled
continue label;   // labeled
```

**Program:**
```java
public class ContinueDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;   // skip even numbers
            System.out.print(i + " ");   // prints 1 3 5 7 9
        }
    }
}
```

### Combined Program (`programs/BreakContinueDemo.java`)
```java
public class BreakContinueDemo {
    public static void main(String[] args) {
        System.out.println("break demo (stop at i==5):");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) break;
            System.out.print(i + " ");     // 1 2 3 4
        }
        System.out.println();

        System.out.println("continue demo (skip even):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;
            System.out.print(i + " ");     // 1 3 5 7 9
        }
        System.out.println();
    }
}
```

### Comparison

| Basis | break | continue |
|---|---|---|
| Effect | Exits loop entirely | Skips current iteration only |
| Loop continues? | No | Yes (next iteration) |
| Used in switch? | Yes | No |
