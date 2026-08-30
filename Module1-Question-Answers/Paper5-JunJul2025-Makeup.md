# BCS306A — June/July 2025 Makeup Exam
## Module 1: Overview of Java, Data Types, Operators, Control Statements

---

## Q.1 a) Outline primitive data types in Java. [5]

### Definition
Primitive data types are the 8 built-in types in Java that store the **actual value** directly in memory. They are not objects.

### The 8 Primitive Types (in 4 groups)

| Group | Types |
|---|---|
| Integer | `byte, short, int, long` |
| Floating-point | `float, double` |
| Character | `char` |
| Boolean | `boolean` |

### Details Table

| Type | Size | Default | Range/Use |
|---|---|---|---|
| `byte` | 1 byte | `0` | -128 to 127 |
| `short` | 2 bytes | `0` | -32,768 to 32,767 |
| `int` | 4 bytes | `0` | ~±2.1 billion (most common) |
| `long` | 8 bytes | `0L` | very large integers; needs `L` suffix |
| `float` | 4 bytes | `0.0f` | decimal; needs `f` suffix |
| `double` | 8 bytes | `0.0` | default decimal type |
| `char` | 2 bytes | `'\u0000'` | single Unicode character |
| `boolean` | 1 bit | `false` | only `true` or `false` |

### Points
1. `int` is the most commonly used integer type.
2. `long` needs `L` suffix for values exceeding `int` range.
3. `float` needs `f` suffix; otherwise Java treats the literal as `double`.
4. `char` stores 16-bit Unicode (not just ASCII).
5. `boolean` only has `true`/`false`.
6. Primitives cannot be `null`; non-primitive types can.

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

## Q.1 b) Explain Java type conversion and casting with a code snippet. [5]

### Type Conversion (Implicit/Widening)
**Definition:** Automatic conversion of a smaller type to a larger, compatible type. No data loss, done by the compiler.

**Order:** `byte → short → int → long → float → double`, and `char → int`.

### Type Casting (Explicit/Narrowing)
**Definition:** Manual conversion of a larger type to a smaller one using the cast operator `(targetType)`. May lose data.

**Syntax:** `(targetType) value`

### Comparison Table

| Basis | Widening (Implicit) | Narrowing (Casting) |
|---|---|---|
| Direction | Small → Large | Large → Small |
| Done by | Compiler | Programmer |
| Data loss | None | Possible |
| Example | `int → double` | `double → int` |

### Program (`programs/TypeConversionCasting.java`)
```java
public class TypeConversionCasting {
    public static void main(String[] args) {
        // Implicit widening
        int num = 100;
        double d = num;          // int -> double, automatic
        char ch = 'A';
        int code = ch;           // char -> int, automatic

        // Explicit narrowing / casting
        double price = 199.99;
        int narrowed = (int) price;  // must cast; truncates to 199

        System.out.println("Widened double: " + d + ", widened int: " + code);
        System.out.println("Narrowed (cast) int: " + narrowed);
    }
}
```

---

## Q.1 c) Develop Java code to transpose a matrix. [10]

### Definition
The transpose of a matrix swaps its rows and columns: `T[j][i] = M[i][j]`.

### Points
1. If original is M×N, transposed is N×M (dimensions swap).
2. Loop through all elements: `transposed[j][i] = original[i][j]`.
3. Used in linear algebra, image processing, etc.

### Program (`programs/TransposeMatrix.java`)
```java
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] m = {
            {1, 2, 3},
            {4, 5, 6}
        };
        int rows = m.length, cols = m[0].length;
        int[][] transposed = new int[cols][rows];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                transposed[j][i] = m[i][j];

        System.out.println("Original:");
        for (int[] row : m) { for (int v : row) System.out.print(v + " "); System.out.println(); }

        System.out.println("Transposed:");
        for (int[] row : transposed) { for (int v : row) System.out.print(v + " "); System.out.println(); }
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int[][] m={{1,2},{3,4}}; for(int i=0;i<2;i++)for(int j=0;j<2;j++)System.out.print(m[j][i]+" "); } }
```

---

## Q.2 a) Summarize Java Operators. [5]

### Definition
An operator is a special symbol that performs an operation on operands and produces a result.

### Summary Table

| Category | Operators | Description |
|---|---|---|
| Arithmetic | `+ - * / %` | Basic math operations |
| Unary | `+ - ++ -- !` | Single operand; inc/dec/NOT |
| Relational | `== != > < >= <=` | Comparison; returns boolean |
| Logical | `&& \|\| !` | Combine booleans; short-circuit |
| Assignment | `= += -= *= /= %=` | Assign/compound-assign |
| Bitwise | `& \| ^ ~` | Operate on individual bits |
| Shift | `<< >> >>>` | Shift bits left/right |
| Ternary | `?:` | Shorthand if-else (3 operands) |
| instanceof | `instanceof` | Tests object type |

### Points
1. `&&` and `||` are short-circuit — skip second operand if first decides result.
2. `>>` preserves sign bit; `>>>` always fills with 0.
3. `~n = -(n+1)` (bitwise complement).
4. Precedence (high→low): Postfix → Unary → `*/%` → `+-` → Shift → Relational → `==!=` → `&^|` → `&&||` → Ternary → Assignment.

### Program
```java
public class OperatorsSummary {
    public static void main(String[] args) {
        int a = 10, b = 3;
        System.out.println(a + b + " " + a / b + " " + a % b);   // 13 3 1
        System.out.println(a > b && b > 0);                     // true
        System.out.println(a > b ? "a is bigger" : "b is bigger"); // ternary
        System.out.println(a & b + " " + (a << 1));             // 2 20
    }
}
```

---

## Q.2 b) Explain Java control statements. [5]

### Definition
Control statements let a program decide the order in which statements execute. Three categories:

### Selection Statements
1. **if** — executes block if condition is true.
2. **if-else** — one block if true, another if false.
3. **if-else-if ladder** — multiple conditions, first true wins.
4. **switch** — multi-way branch on a variable against constant `case` values; `break` exits.

### Iteration Statements
5. **while** — entry-controlled; checks before body; may run 0 times.
6. **do-while** — exit-controlled; checks after body; always runs ≥ 1 time.
7. **for** — `for (init; cond; update) { }` — combines all three in one line.
8. **for-each** — `for (int v : arr) { }` — no index, sequential.

### Jump Statements
9. **break** — exits loop/switch immediately.
10. **continue** — skips rest of current iteration.
11. **return** — exits method, optionally returns a value.

### Program (`programs/ControlStatementsDemo.java`)
```java
public class ControlStatementsDemo {
    public static void main(String[] args) {
        int num = 7;
        if (num % 2 == 0) System.out.println("Even");     // if-else
        else System.out.println("Odd");

        switch (num % 3) {                                  // switch
            case 0: System.out.println("Div by 3"); break;
            default: System.out.println("Not div by 3");
        }

        for (int k = 1; k <= 3; k++) System.out.print("for:" + k + " "); // for
        System.out.println();

        int[] arr = {10, 20, 30};
        for (int v : arr) System.out.print("each:" + v + " ");  // for-each
    }
}
```

---

## Q.2 c) Develop Java code to add two matrices. [10]

### Points
1. Both matrices must have the **same dimensions**.
2. `result[i][j] = a[i][j] + b[i][j]` for every row and column.
3. Traversed using nested loops.

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
