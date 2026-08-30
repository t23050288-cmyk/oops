# 6. Operators

**Definition:** An operator is a special symbol that performs an operation on one, two,
or three operands and produces a result.

**Points (categories — answers "list the various operators supported by Java"):**
1. **Arithmetic**: `+ - * / %`
2. **Unary**: `+ - ++ -- !`
3. **Relational**: `== != > < >= <=`
4. **Logical**: `&& || ! & |`
5. **Assignment**: `= += -= *= /= %=`
6. **Bitwise**: `& | ^ ~ << >> >>>`
7. **Ternary (conditional)**: `?:`
8. **instanceof** — tests object type.
9. Classified also by operand count: Unary (1), Binary (2), Ternary (3).

---

## 6.1 Arithmetic Operators

| Operator | Meaning | a=10,b=3 |
|---|---|---|
| `+` | Addition | 13 |
| `-` | Subtraction | 7 |
| `*` | Multiplication | 30 |
| `/` | Division (integer division if both int) | 3 |
| `%` | Modulus/remainder | 1 |

**Program (also answers "Celsius to Fahrenheit"):** `programs/CelsiusToFahrenheit.java`

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=10,y=3; System.out.println((x+y)+" "+(x-y)+" "+(x*y)+" "+(x/y)+" "+(x%y)); } }
```

---

## 6.2 Unary Operators

**Points:**
1. `++`/`--` operate on a single operand — increment/decrement by 1.
2. **Post-increment** (`a++`) returns the *current* value, **then** increments.
3. **Pre-increment** (`++a`) increments **first**, then returns the new value.
4. `!` is logical NOT — flips a boolean.
5. Unary `-` negates a value.

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=5; System.out.println(x++ +" "+x+" "+ ++x); } }
```

---

## 6.3 Relational (Comparison) Operators

Result is always `boolean`. `== != > < >= <=`.

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=10,y=20; System.out.println((x<y)+" "+(x==y)); } }
```

---

## 6.4 Logical / Boolean & Short-Circuit Operators

**Definition:** Combine multiple boolean expressions into one.

**Points (answers "short circuit operators" & "bitwise and short circuit operators"):**
1. `&&` (AND) and `||` (OR) are the **short-circuit** logical operators.
2. **Short-circuit evaluation**: in `A && B`, if `A` is `false`, `B` is **never
   evaluated** (result is already known to be false) — saves time, avoids errors.
3. Similarly in `A || B`, if `A` is `true`, `B` is never evaluated.
4. `&` and `|` are the **boolean (non-short-circuit)** versions — they **always**
   evaluate both sides, even if the first already decides the result.
5. `!` is logical NOT — inverts a single boolean.
6. Short-circuit operators are safer for conditions like `if (obj != null && obj.value > 0)`
   — avoids a NullPointerException if `obj` is null, because the second part is skipped.

**Truth Table (&&, same for ||):**

| A | B | A&&B | A\|\|B |
|---|---|---|---|
| T | T | T | T |
| T | F | F | T |
| F | T | F | T |
| F | F | F | F |

**Easiest Program:**
```java
public class LogicalDemo {
    public static void main(String[] args) {
        int age = 25;
        boolean hasID = true;
        if (age >= 18 && hasID) System.out.println("Eligible to vote");   // short-circuit &&

        String s = null;
        if (s != null && s.length() > 0) System.out.println("has text");  // safe due to short-circuit
        else System.out.println("null or empty, checked safely");
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ System.out.println((true && false) + " " + (true || false) + " " + !true); } }
```

---

## 6.5 Assignment Operators

`= += -= *= /= %=` — compound operators combine an operation with assignment.
e.g. `a += 5` is equivalent to `a = a + 5`.

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=10; x+=5; x*=2; System.out.println(x); } }
```

---

## 6.6 Bitwise & Shift Operators

**Definition:** Bitwise operators work directly on the individual **bits** of integer
types.

**Points (answers "bitwise operators", ">> and >>> with example", "<<, >>, >>>"):**
1. `&` (AND) — result bit is 1 only if **both** bits are 1.
2. `|` (OR) — result bit is 1 if **at least one** bit is 1.
3. `^` (XOR) — result bit is 1 if the two bits are **different**.
4. `~` (complement) — unary, flips every bit. Rule: `~n = -(n+1)`. So `~5 = -6`.
5. `<<` (left shift) — shifts bits left, fills right with 0. `a << n` = `a * 2ⁿ`.
6. `>>` (signed/arithmetic right shift) — shifts bits right, fills left with the
   **sign bit** (preserves sign for negative numbers). `a >> n` ≈ `a / 2ⁿ`.
7. `>>>` (unsigned right shift) — shifts bits right, **always** fills left with `0`,
   even for negative numbers — so a negative number becomes a large positive number.
8. **Key difference `>>` vs `>>>`**: `>>` preserves sign (arithmetic), `>>>` always
   fills with zero (logical) — they behave identically for positive numbers, but differ
   for negative ones.

**Example (a=5=`0000 0101`, b=3=`0000 0011`):**

| Op | Result | Binary |
|---|---|---|
| `a & b` | 1 | `0000 0001` |
| `a \| b` | 7 | `0000 0111` |
| `a ^ b` | 6 | `0000 0110` |
| `~a` | -6 | `1111 1010` |
| `a << 1` | 10 | `0000 1010` |

**`>>` vs `>>>` example (the classic exam example):**
```java
int a = -8;
System.out.println(a >> 1);   // -4  (sign bit preserved, arithmetic shift)
System.out.println(a >>> 1);  // 2147483644 (sign bit replaced with 0, logical shift)
```

**Easiest Program:** `programs/ShiftAndBitwiseDemo.java`

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=5,y=3; System.out.println((x&y)+" "+(x|y)+" "+(x^y)+" "+(~x)+" "+(x<<1)+" "+(-8>>1)+" "+(-8>>>1)); } }
```

---

## 6.7 Ternary (Conditional) Operator

**Definition:** Java's only 3-operand operator; a shorthand for simple `if-else`.

**Syntax:** `variable = (condition) ? valueIfTrue : valueIfFalse;`

**Points:**
1. Evaluates `condition`; if `true` returns the first value, else the second.
2. Common use: finding min/max of numbers without writing full `if-else`.
3. Right-to-left associativity — can be chained for multiple conditions.

**Easiest Program (greatest of three numbers using ternary):** `programs/TernaryGreatest.java`

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=10,y=20; System.out.println(x>y ? x : y); } }
```

---

## 6.8 instanceof Operator

Tests whether an object is an instance of a class/interface; returns `boolean`.

```java
String str = "Hello";
System.out.println(str instanceof String);   // true
```

---

## 6.9 Operator Precedence & Associativity

**Points:**
1. **Precedence** decides which operator is evaluated first when several are present
   in one expression (higher precedence evaluates first).
2. Order (high→low, simplified): Postfix `++/--` → Unary → Multiplicative `* / %` →
   Additive `+ -` → Shift → Relational → Equality → Bitwise `& ^ |` → Logical `&& ||`
   → Ternary → Assignment.
3. **Associativity** decides evaluation order for operators of the **same** precedence
   — most are left-to-right, but Unary, Ternary, and Assignment are right-to-left.
4. `10 + 5 * 2` = `10 + (5*2)` = `20` — `*` has higher precedence than `+`.
5. Parentheses `()` have the **highest** precedence and override default order:
   `(10 + 5) * 2 = 30`.
6. Use parentheses freely to make complex expressions readable and avoid precedence bugs.

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ System.out.println(10 + 5 * 2); System.out.println((10 + 5) * 2); } }
```
