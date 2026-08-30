# BCS306A — June/July 2024 Exam
## Module 1: Overview of Java, Data Types, Operators, Control Statements

---

## Q.1 a) Differentiate two paradigms of programming. [5]

### Definition
A paradigm is the fundamental style/approach used to organize a program. The two main paradigms are **Procedural** and **Object-Oriented**.

### Points
1. Every program is just **code** (logic) + **data** (values). The paradigm question is: which should the program be organized around?
2. **Procedural paradigm** (C, Pascal) organizes the program around **code** — functions that act on data.
3. **Object-Oriented paradigm** (Java, C++) organizes the program around **data** — objects that own their data and expose methods.
4. In procedural style, data is passive — passed around freely to functions.
5. In OOP, data controls access to code — outside code must go *through* an object's methods to touch its data.
6. Procedural works fine for small programs but breaks down as programs grow — shared data gets modified from everywhere.
7. OOP fixes this via **encapsulation**, making large programs easier to maintain.

### Comparison Table

| Basis | Procedural | Object-Oriented |
|---|---|---|
| Organized around | Code/functions | Data/objects |
| Data | Passive, freely shared | Encapsulated, protected |
| Reusability | Low | High (inheritance) |
| Example languages | C | Java, C++ |
| Best for | Small programs | Large, complex programs |

**Smallest Program (OOP style):**
```java
class Paradigm { int data = 10; void show() { System.out.println(data); }
    public static void main(String[] a) { new Paradigm().show(); } }
```

---

## Q.1 b) Explain the various bitwise and short circuit operators in Java. [8]

### Bitwise Operators

**Definition:** Bitwise operators work directly on the individual **bits** of integer types.

**Points:**
1. `&` (AND) — result bit is 1 only if **both** bits are 1.
2. `|` (OR) — result bit is 1 if **at least one** bit is 1.
3. `^` (XOR) — result bit is 1 if the two bits are **different**.
4. `~` (complement) — unary, flips every bit. `~n = -(n+1)`, so `~5 = -6`.
5. `<<` (left shift) — shifts bits left, fills with 0. `a << n = a × 2ⁿ`.
6. `>>` (signed right shift) — fills left with sign bit.
7. `>>>` (unsigned right shift) — fills left with 0 always.

### Short-Circuit Operators

**Definition:** `&&` (AND) and `||` (OR) are short-circuit logical operators that skip evaluating the second operand when the first already determines the result.

**Points:**
1. In `A && B`, if `A` is `false`, `B` is **never evaluated** — result is already false.
2. In `A || B`, if `A` is `true`, `B` is **never evaluated** — result is already true.
3. `&` and `|` are **non-short-circuit** versions — they **always** evaluate both sides.
4. Short-circuit operators are safer: `if (obj != null && obj.value > 0)` avoids NullPointerException.
5. `!` is logical NOT — inverts a boolean.

### Truth Table

| A | B | A&&B | A\|\|B | A&B | A\|B |
|---|---|---|---|---|---|
| T | T | T | T | T | T |
| T | F | F | T | F | T |
| F | T | F | T | F | T |
| F | F | F | F | F | F |

### Program
```java
public class LogicalDemo {
    public static void main(String[] args) {
        int age = 25;
        boolean hasID = true;
        if (age >= 18 && hasID) System.out.println("Eligible to vote");

        String s = null;
        if (s != null && s.length() > 0) System.out.println("has text");
        else System.out.println("null or empty, checked safely");

        int a = 5, b = 3;
        System.out.println("a & b = " + (a & b));   // 1
        System.out.println("a | b = " + (a | b));   // 7
        System.out.println("a ^ b = " + (a ^ b));   // 6
        System.out.println("~a    = " + (~a));      // -6
    }
}
```

---

## Q.1 c) Write a Java program with a method to check whether a given number is prime or not. [7]

### Definition
A prime number is a natural number greater than 1 that has no positive divisors other than 1 and itself.

### Points
1. Check divisibility from 2 up to √n (square root of n).
2. If any number in that range divides n, it's not prime.
3. Using √n instead of n makes it faster — O(√n) instead of O(n).
4. 0 and 1 are not prime.

### Syntax (method)
```java
static boolean isPrime(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}
```

### Program (`programs/PrimeCheck.java`)
```java
import java.util.Scanner;
public class PrimeCheck {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        if (isPrime(num)) System.out.println(num + " is a prime number");
        else System.out.println(num + " is not a prime number");
        sc.close();
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int n=7; boolean p=n>1; for(int i=2;i*i<=n;i++) if(n%i==0) p=false; System.out.println(p?"Prime":"Not prime"); } }
```

---

## Q.2 a) Explain various scopes of variables in Java. [5]

### Definition
Scope defines the region of a program within which a variable is visible/accessible; a **block** `{ }` defines that region for local variables.

### Points
1. A variable declared inside a block is accessible **only within that block** (and any nested block inside it).
2. An **outer** block cannot access a variable declared inside an **inner** block.
3. An **inner** block *can* access variables declared in its enclosing outer block.
4. Types of scope: **class-level (fields)** — accessible anywhere in the class; **local (inside a method/block)** — accessible only within that method/block.
5. A variable's scope begins at its declaration and ends at the closing `}` of its block.
6. You cannot re-declare a variable with the same name in a nested scope if it already exists in an enclosing scope.

### Program (`programs/ScopeDemo.java`)
```java
public class ScopeDemo {
    static int classVar = 100;   // class-level scope
    public static void main(String[] args) {
        int x = 10;               // scope: whole main()
        {
            int y = 20;            // scope: only this inner block
            System.out.println(x); // valid — outer var visible inside
            System.out.println(y);
            System.out.println(classVar); // valid — class-level
        }
        System.out.println(x);
        // System.out.println(y);  // ERROR — y is out of scope
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=1; { int y=2; System.out.println(x+y); } } }
```

---

## Q.2 b) Explain control statements in Java. [8]

### Definition
Control statements let a program decide the order in which its statements execute. Three categories: **Selection** (`if`, `switch`), **Iteration** (`while`, `do-while`, `for`, for-each), **Jump** (`break`, `continue`, `return`).

### Selection Statements
1. **if** — executes a block only if its boolean condition is true.
2. **if-else** — runs one block if true, another if false.
3. **if-else-if ladder** — tests multiple conditions top-to-bottom; first true one wins.
4. **switch** — multi-way branch; tests one variable against several constant `case` values. `break` exits after a case runs.

### Iteration Statements
5. **while** — entry-controlled; checks condition BEFORE body; may run 0 times.
6. **do-while** — exit-controlled; checks condition AFTER body; always runs ≥ 1 time.
7. **for** — combines init, condition, update in one line: `for (init; cond; update) { }`
8. **for-each** — cycles through arrays/collections with no index: `for (int v : arr) { }`

### Jump Statements
9. **break** — exits a loop or switch immediately.
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

## Q.2 c) Write a Java program to perform linear search on array elements accepted from keyboard and key element also accepted from keyboard. [7]

### Definition
Linear search checks each element one by one from the start until it finds the target (key), or reaches the end.

### Points
1. Time complexity O(n) — checks every element in the worst case.
2. Works on unsorted arrays (unlike binary search).
3. Use `Scanner` to read array size, elements, and the key from the keyboard.
4. Loop through the array; if `arr[i] == key`, record the index and stop.

### Syntax
```java
Scanner sc = new Scanner(System.in);
int n = sc.nextInt();         // read size
int[] arr = new int[n];
for (int i = 0; i < n; i++) arr[i] = sc.nextInt();   // read elements
int key = sc.nextInt();       // read key
```

### Program (`programs/LinearSearch.java`)
```java
import java.util.Scanner;
public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();

        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) { index = i; break; }
        }
        if (index != -1) System.out.println("Key found at index " + index);
        else System.out.println("Key not found in the array");
        sc.close();
    }
}
```

**Smallest Program (core logic, hardcoded):**
```java
public class Main { public static void main(String[] a){ int[] arr={4,8,15,16}; int key=15,idx=-1; for(int i=0;i<arr.length;i++) if(arr[i]==key){idx=i;break;} System.out.println(idx); } }
```
