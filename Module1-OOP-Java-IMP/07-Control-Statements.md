# 7. Control Statements

**Definition:** Control statements let a program decide the order in which its
statements execute. Three categories: **Selection** (`if`, `switch`), **Iteration**
(`while`, `do-while`, `for`, for-each), **Jump** (`break`, `continue`, `return`).

---

## 7.1 Selection Statements

### if / if-else / if-else-if / nested if

**Points:**
1. `if` executes a block **only if** its boolean condition is true.
2. Java requires the condition to be strictly `boolean` (unlike C, where an `int`
   works too).
3. **if-else**: runs one block if true, another if false.
4. **if-else-if ladder**: tests multiple conditions top-to-bottom; first true one
   wins, rest are skipped; final `else` is the default/catch-all.
5. **Nested if**: an `if` inside another `if`/`else` — used when a decision depends
   on another decision.
6. Only the first matching branch executes — after that, the rest of the ladder is skipped.

**Syntax (all four variations):**
```java
if (condition) { }                                  // simple
if (condition) { } else { }                          // if-else
if (c1) { } else if (c2) { } else { }                 // ladder
if (c1) { if (c2) { } }                               // nested
```

**Easiest Program (all types of if statements in one place):** `programs/IfStatementTypes.java`

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int age=20; System.out.println(age>=18 ? "Eligible" : "Not eligible"); } }
```

### switch statement

**Definition:** Java's multi-way branch statement — tests one variable/expression
against several constant `case` values.

**Points:**
1. Expression type can be `byte, short, int, char, String`, or `enum`.
2. `case` values must be **constants** and **unique** (no duplicates).
3. `break` exits the switch after a case runs — **without it, execution falls through**
   into the next case(s).
4. `default` is optional, runs when no case matches, and can appear anywhere in the block.

**Syntax:**
```java
switch (expression) {
    case value1: statement(s); break;
    case value2: statement(s); break;
    default: statement(s);
}
```

**Easiest Program:**
```java
public class SwitchDemo {
    public static void main(String[] args) {
        int day = 3;
        switch (day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            default: System.out.println("Other day");
        }
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ switch(2){ case 1: System.out.println("one"); break; case 2: System.out.println("two"); break; } } }
```

---

## 7.2 Iteration (Looping) Statements

### while loop — entry-controlled (checks condition BEFORE running body; may run 0 times)
```java
int i = 1;
while (i <= 5) { System.out.println(i); i++; }
```

### do-while loop — exit-controlled (checks condition AFTER; always runs >= 1 time)
```java
int i = 1;
do { System.out.println(i); i++; } while (i <= 5);
```

| Feature | while | do-while |
|---|---|---|
| Condition checked | Before body | After body |
| Min executions | 0 | 1 |
| Terminator | none | `;` after `while(...)` |

### for loop — combines init, condition, update in one line
```java
for (int i = 1; i <= 5; i++) { System.out.println(i); }
```

**Points (for-loop variations, all askable):**
1. Any of the 3 parts (init/condition/update) can be omitted (semicolons stay):
   `for (; i<=5; ) { ... i++; }`
2. **Infinite for loop**: `for (;;) { }` — no terminating condition.
3. **Multiple update expressions**, comma-separated:
   `for (int i=0, j=10; i<j; i++, j--) { ... }`
4. **`var` (Java 10+)**: lets the compiler infer the type — `for (var i = 0; i < 10; i++)`.

### for-each loop (Enhanced for) — cycles through a collection/array with no index

**Points:**
1. Syntax: `for (dataType variable : array) { ... }`
2. Purely sequential, start to finish — no manual index/counter, avoids boundary errors.
3. **Read-only** — changing the loop variable does not change the original array element.
4. Can't be used when you need the index itself (to skip elements, go backwards) — use
   a traditional `for` loop for those cases.

**Easiest Program (control statements with example — covers if + switch + all loops):** `programs/ControlStatementsDemo.java`

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int[] n={1,2,3}; for (int v: n) System.out.print(v); } }
```

### Nested Loops

A loop inside another loop — inner loop finishes all its iterations for each single
iteration of the outer loop. Used for matrices and pattern printing.

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) System.out.print(i * j + "\t");
    System.out.println();
}
```

---

## 7.3 Jump Statements

### break

**Points:**
1. Exits a loop (`while/do-while/for`) or a `switch` immediately.
2. **Unlabeled `break`** exits only the **innermost** loop when inside nested loops.
3. **Labeled `break`** (`break label;`) exits an **outer** loop directly from inside a nested loop.

```java
outer:
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        if (i == 2 && j == 2) break outer;   // exits outer loop entirely
        System.out.println("i="+i+" j="+j);
    }
}
```

### continue

**Points:**
1. Skips the **rest of the current iteration** and jumps to the loop's condition
   check (`while/do-while`) or update step (`for`).
2. **Labeled `continue`** skips to the next iteration of an **outer** loop.

```java
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) continue;    // skip even numbers
    System.out.println(i);       // prints only odd: 1 3 5 7 9
}
```

### return

**Points:**
1. Exits a method immediately, returning control to the caller.
2. `return;` — used in `void` methods (no value).
3. `return value;` — used in non-`void` methods, sends `value` back to the caller.

```java
static int square(int n) { return n * n; }
```

**Easiest Program (break, continue together):** `programs/BreakContinueDemo.java`

**Smallest Program:**
```java
public class Main {
    public static void main(String[] a) {
        for (int i = 1; i <= 5; i++) { if (i==3) continue; if (i==5) break; System.out.print(i); }
    }
}
```

---

## 7.4 Worked Trace Example — "what is the output?"

One IMP paper asks you to trace a `for` loop's output for a `HelloWorld`-style class
(the source scan was partly garbled, so here's the standard version of that exact
question style, fully traced step by step):

```java
class HelloWorld {
    public static void main(String[] args) {
        for (int b = 1; b <= 5; b++) {
            System.out.println(b);
        }
    }
}
```

**Trace:** `b=1`→prints 1; `b=2`→prints 2; ... up to `b=5`→prints 5; then `b=6` fails
`b<=5`, loop ends. **Output:** `1 2 3 4 5` (each on its own line).

See `programs/ForLoopTrace.java` for the runnable version with inline trace comments —
use it as the template for tracing *any* similar for-loop-output question in the exam
(write out variable value → check condition → print/act → update, one row at a time).
