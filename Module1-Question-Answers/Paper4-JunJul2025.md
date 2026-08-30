# BCS306A — June/July 2025 Exam
## Module 1: Overview of Java, Data Types, Operators, Control Statements

---

## Q.1 a) List and explain control statements in Java with programming example. [10]

### Definition
Control statements let a program decide the order in which its statements execute. Three categories: **Selection** (`if`, `switch`), **Iteration** (`while`, `do-while`, `for`, for-each), **Jump** (`break`, `continue`, `return`).

### Selection Statements
1. **if** — executes a block only if its boolean condition is true. Java requires strictly `boolean` conditions.
2. **if-else** — runs one block if true, another if false.
3. **if-else-if ladder** — tests multiple conditions top-to-bottom; first true one wins; final `else` is default.
4. **switch** — multi-way branch; tests one variable against several constant `case` values. `break` exits after a case. Supports `byte, short, int, char, String, enum`.

### Iteration Statements
5. **while** — entry-controlled; checks condition BEFORE body; may run 0 times.
   ```java
   while (condition) { ... }
   ```
6. **do-while** — exit-controlled; checks condition AFTER body; always runs ≥ 1 time.
   ```java
   do { ... } while (condition);   // note the semicolon
   ```
7. **for** — combines init, condition, update in one line.
   ```java
   for (init; condition; update) { ... }
   ```
8. **for-each** — cycles through arrays/collections with no index.
   ```java
   for (dataType var : array) { ... }
   ```

### Jump Statements
9. **break** — exits a loop or switch immediately. Labeled `break label;` exits outer loop.
10. **continue** — skips rest of current iteration, jumps to next.
11. **return** — exits a method immediately, optionally returning a value.

### Program (`programs/ControlStatementsDemo.java`)
```java
public class ControlStatementsDemo {
    public static void main(String[] args) {
        // Selection: if
        int num = 7;
        if (num % 2 == 0) System.out.println("Even");
        else System.out.println("Odd");

        // Selection: switch
        switch (num % 3) {
            case 0: System.out.println("Divisible by 3"); break;
            default: System.out.println("Not divisible by 3");
        }

        // Iteration: while
        int i = 1;
        while (i <= 3) { System.out.print("while:" + i + " "); i++; }
        System.out.println();

        // Iteration: do-while
        int j = 1;
        do { System.out.print("do-while:" + j + " "); j++; } while (j <= 3);
        System.out.println();

        // Iteration: for
        for (int k = 1; k <= 3; k++) System.out.print("for:" + k + " ");
        System.out.println();

        // Iteration: for-each
        int[] arr = {10, 20, 30};
        for (int v : arr) System.out.print("for-each:" + v + " ");
        System.out.println();

        // Jump: break/continue
        for (int k = 1; k <= 5; k++) {
            if (k == 4) break;
            if (k == 2) continue;
            System.out.print("jump:" + k + " ");
        }
    }
}
```

---

## Q.1 b) List and explain operators in Java. [10]

### Definition
An operator is a special symbol that performs an operation on one, two, or three operands and produces a result.

### 1. Arithmetic Operators: `+ - * / %`
1. `+` addition, `-` subtraction, `*` multiplication, `/` division, `%` modulus.
2. Integer division truncates: `10/3 = 3`.

### 2. Unary Operators: `+ - ++ -- !`
1. `++`/`--` increment/decrement by 1.
2. Post (`a++`) returns current value then increments; Pre (`++a`) increments then returns.
3. `!` logical NOT.

### 3. Relational Operators: `== != > < >= <=`
1. Result is always `boolean`.
2. Used in `if` conditions and loop checks.

### 4. Logical / Short-Circuit Operators: `&& || !`
1. `&&` (AND) and `||` (OR) are short-circuit — skip second operand if first decides result.
2. `&` and `|` are non-short-circuit — always evaluate both sides.
3. `!` is logical NOT.

### 5. Assignment Operators: `= += -= *= /= %=`
1. `a += 5` is equivalent to `a = a + 5`.
2. Compound operators combine operation with assignment.

### 6. Bitwise Operators: `& | ^ ~`
1. Work on individual bits of integer types.
2. `~n = -(n+1)` (bitwise complement).

### 7. Shift Operators: `<< >> >>>`
1. `<<` left shift: `a << n = a × 2ⁿ`.
2. `>>` signed right shift: fills with sign bit.
3. `>>>` unsigned right shift: always fills with 0.

### 8. Ternary Operator: `?:`
1. Shorthand for `if-else`: `var = (condition) ? val1 : val2;`

### 9. instanceof
1. Tests whether an object is an instance of a class/interface; returns `boolean`.

### Operator Precedence (high → low)
Postfix `++/--` → Unary → `* / %` → `+ -` → Shift → Relational → `== !=` → `& ^ |` → `&& ||` → Ternary → Assignment.

### Program
```java
public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 10, b = 3;
        System.out.println(a + b);      // 13
        System.out.println(a / b);      // 3 (integer division)
        System.out.println(a % b);      // 1
        System.out.println(a > b);      // true
        System.out.println(a > 5 && b < 5);  // true (short-circuit)
        int x = 5;
        System.out.println(x++ + " " + ++x);  // 5 7
        System.out.println(a > b ? a : b);    // 10 (ternary)
        System.out.println(a & b);     // 2 (bitwise)
        System.out.println(a << 1);    // 20 (left shift)
    }
}
```

---

## Q.2 a) How are arrays declared and initialized in Java? Explain with suitable example. [10]

### Definition
An array is a collection of elements of the **same data type**, stored in contiguous memory, referred to by a single variable name, and accessed via a zero-based index.

### Points
1. Arrays in Java are **objects**, created dynamically with `new`; size is fixed once created.
2. `arrayName.length` gives the size — it's a **field**, not a method.
3. Elements are indexed from `0` to `length-1`.
4. The reference variable lives in the stack; actual elements live in the heap.

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

## Q.2 b) Develop a Java program to add two matrices of suitable order N. [10]

### Points
1. Both matrices must have the **same dimensions**.
2. `result[i][j] = a[i][j] + b[i][j]` for every row `i` and column `j`.
3. "Order N" means the code works for any N×N size, not hardcoded 2×2.
4. Use `Scanner` to read N and the matrix elements.

### Program (`programs/MatrixAdditionN.java`)
```java
import java.util.Scanner;
public class MatrixAdditionN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter order N: ");
        int n = sc.nextInt();

        int[][] a = new int[n][n];
        int[][] b = new int[n][n];
        int[][] result = new int[n][n];

        System.out.println("Enter elements of matrix A:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        System.out.println("Enter elements of matrix B:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                b[i][j] = sc.nextInt();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = a[i][j] + b[i][j];

        System.out.println("Sum of matrices:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) System.out.print(result[i][j] + " ");
            System.out.println();
        }
        sc.close();
    }
}
```

**Smallest Program (2×2 hardcoded):**
```java
public class Main { public static void main(String[] a){ int[][] x={{1,2},{3,4}},y={{5,6},{7,8}}; for(int i=0;i<2;i++)for(int j=0;j<2;j++)System.out.print((x[i][j]+y[i][j])+" "); } }
```
