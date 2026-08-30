# BCS306A — Dec 2023/Jan 2024 Exam
## Module 1: Overview of Java, Data Types, Operators, Control Statements

---

## Q.1 a) Discuss the different data types supported by Java along with the default values and literals. [8]

### Definition
A data type defines the kind of value a variable can hold, the operations allowed on it, and how much memory it needs. Java is **statically & strongly typed** — every variable's type is fixed at declaration and checked at compile time.

### Points
1. Two categories: **Primitive** (8 built-in types) and **Non-Primitive/Reference** (`String`, Array, Class, Interface).
2. Primitive types store the **actual value** directly in stack memory.
3. Non-primitive types store a **reference/address** to an object in heap memory.
4. Primitive type names start lowercase (`int`); reference types usually start uppercase (`String`).
5. Every primitive type has a **default value** (used for instance fields, not local variables).
6. Non-primitive types can be `null`; primitives cannot.
7. Integer literals default to `int`; must add `L` for `long` values exceeding `int` range.
8. Decimal literals default to `double`; must add `f`/`F` to make them `float`.

### Primitive Data Types Table

| Type | Size | Default | Example Literal |
|---|---|---|---|
| `byte` | 1 byte | `0` | `byte b = 100;` |
| `short` | 2 bytes | `0` | `short s = 20000;` |
| `int` | 4 bytes | `0` | `int i = 50000;` |
| `long` | 8 bytes | `0L` | `long l = 15000000000L;` — needs `L` |
| `float` | 4 bytes | `0.0f` | `float f = 10.5f;` — needs `f` |
| `double` | 8 bytes | `0.0` | `double d = 3.14;` — default decimal |
| `char` | 2 bytes (Unicode) | `'\u0000'` | `char c = 'A';` |
| `boolean` | 1 bit | `false` | `boolean flag = true;` |

### Non-Primitive Types
- **String** — sequence of characters; `String name = "John";`
- **Array** — collection of same-type elements; `int[] arr = {1,2,3};`
- **Class** — user-defined blueprint; `class Student { ... }`

### Program (`programs/DataTypesDemo.java`)
```java
public class DataTypesDemo {
    static int instanceInt;          // default 0 (fields get defaults, locals don't)
    static boolean instanceBool;    // default false
    public static void main(String[] args) {
        byte b = 100;
        short s = 20000;
        int i = 50000;
        long l = 15000000000L;       // L required
        float f = 10.5f;            // f required
        double d = 3.14159;
        char c = 'A';
        boolean flag = true;
        System.out.println("byte=" + b + " short=" + s + " int=" + i);
        System.out.println("long=" + l + " float=" + f + " double=" + d);
        System.out.println("char=" + c + " boolean=" + flag);
        System.out.println("default int=" + instanceInt + " default boolean=" + instanceBool);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ System.out.println((byte)1+" "+(short)2+" "+3+" "+4L+" "+5.5f+" "+6.6+" "+'C'+" "+true); } }
```

---

## Q.1 b) Develop a Java program to convert Celsius temperature to Fahrenheit. [6]

### Formula
`F = (C × 9/5) + 32`

### Program (`programs/CelsiusToFahrenheit.java`)
```java
import java.util.Scanner;
public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();
        double fahrenheit = (celsius * 9 / 5) + 32;
        System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
        sc.close();
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ double c=25; System.out.println((c*9/5)+32); } }
```

---

## Q.1 c) Justify the statement "Compile once and run anywhere" in Java. [6]

### Definition
"Compile once, run anywhere" (platform independence) means Java source code compiles to an intermediate form (**bytecode**) that runs unmodified on any device with a **JVM (Java Virtual Machine)**, regardless of the underlying OS/hardware.

### Points
1. **Simple** — syntax based on C/C++ but removes pointers and multiple inheritance.
2. **Object-Oriented** — everything is built around objects/classes.
3. **Platform Independent** — `.java` → compiled by `javac` into `.class` **bytecode**, not native machine code.
4. **Bytecode + JVM** — every platform (Windows/Linux/Mac) has its own JVM that interprets the *same* bytecode.
5. You compile **once** on any machine, and that single `.class` file **runs anywhere** a JVM exists — you never recompile for each OS.
6. **Robust** — strong type checking, automatic garbage collection, exception handling.
7. **Secure** — bytecode is verified before execution; no direct pointer access.
8. **Architecture-neutral** — `int` is always 4 bytes on every platform (unlike C where it varies).

### Flow
```
MyProg.java --(javac)--> MyProg.class (bytecode) --(JVM on any OS)--> Output
```

**Smallest Program (bytecode produced is identical regardless of OS):**
```java
class Hi { public static void main(String[] a){ System.out.println("Runs anywhere"); } }
```

---

## Q.2 a) List the various operators supported by Java. Illustrate the working of >> and >>> operators with an example. [8]

### Definition
An operator is a special symbol that performs an operation on one, two, or three operands and produces a result.

### List of Operators
1. **Arithmetic**: `+ - * / %`
2. **Unary**: `+ - ++ -- !`
3. **Relational**: `== != > < >= <=`
4. **Logical**: `&& || !`
5. **Assignment**: `= += -= *= /= %=`
6. **Bitwise**: `& | ^ ~`
7. **Shift**: `<< >> >>>`
8. **Ternary**: `?:`
9. **instanceof** — tests object type.

### >> (Signed Right Shift) vs >>> (Unsigned Right Shift)

**Points:**
1. `>>` (signed/arithmetic right shift) — shifts bits right, fills left with the **sign bit** (preserves sign for negative numbers). `a >> n` ≈ `a / 2ⁿ`.
2. `>>>` (unsigned/logical right shift) — shifts bits right, **always** fills left with `0`, even for negative numbers.
3. For positive numbers, both give the same result.
4. For negative numbers, `>>>` turns a negative into a large positive (sign bit becomes 0).

### Example
```java
int a = -8;
System.out.println(a >> 1);    // -4  (sign bit preserved)
System.out.println(a >>> 1);   // 2147483644 (sign bit replaced with 0)
```

### Program (`programs/ShiftAndBitwiseDemo.java`)
```java
public class ShiftAndBitwiseDemo {
    public static void main(String[] args) {
        int a = 5, b = 3;
        System.out.println("a & b = " + (a & b));    // 1
        System.out.println("a | b = " + (a | b));    // 7
        System.out.println("a ^ b = " + (a ^ b));    // 6
        System.out.println("~a    = " + (~a));       // -6
        System.out.println("a << 1 = " + (a << 1));  // 10
        int neg = -8;
        System.out.println("-8 >> 1  = " + (neg >> 1));   // -4
        System.out.println("-8 >>> 1 = " + (neg >>> 1));  // 2147483644
    }
}
```

---

## Q.2 b) Develop a Java program to add two matrices using command line argument. [10]

### Points
1. Command line arguments are passed to `main(String[] args)` as strings.
2. Use `Integer.parseInt()` to convert string arguments to integers.
3. First set of values = matrix A, second set = matrix B.
4. `result[i][j] = a[i][j] + b[i][j]` for every row and column.

### Syntax
```java
public static void main(String[] args) {
    int val = Integer.parseInt(args[0]);  // convert string to int
}
```

### Program (`programs/MatrixAdditionCLI.java`)
```java
// Run as: java MatrixAdditionCLI 1 2 3 4 5 6 7 8
public class MatrixAdditionCLI {
    public static void main(String[] args) {
        int size = 2;
        if (args.length < size * size * 2) {
            System.out.println("Please pass 8 integers (4 for A, 4 for B).");
            return;
        }
        int[][] a = new int[size][size];
        int[][] b = new int[size][size];
        int[][] result = new int[size][size];

        int idx = 0;
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                a[i][j] = Integer.parseInt(args[idx++]);
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                b[i][j] = Integer.parseInt(args[idx++]);
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                result[i][j] = a[i][j] + b[i][j];

        System.out.println("Sum of matrices:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
    }
}
```

---

## Q.2 c) Explain the syntax of declaration of 2D arrays in Java. [2]

### Definition
A 2D array is an array of arrays — represents data as a table/matrix with rows and columns.

### Syntax
```java
dataType[][] arrayName = new dataType[rows][columns];   // e.g. int[][] m = new int[3][3];
int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };             // with initialization
```

### Points
1. Declared using two sets of brackets `[][]`.
2. Each "row" is itself a separate 1D array object.
3. `arr[i][j]` → element at row `i`, column `j`.
4. `arr.length` = number of rows; `arr[i].length` = columns in row `i`.
5. Traversed using **nested loops** — outer for rows, inner for columns.

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int[][] m={{1,2},{3,4}}; System.out.println(m[1][1]); } }
```
