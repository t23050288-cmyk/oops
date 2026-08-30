# 4. Type Conversion, Type Casting, Type Promotion & Variable Scope

## 4.1 Type Conversion vs Type Casting

**Definition:** Type Conversion is converting a value from one data type to another.
It happens two ways in Java — **Implicit (Widening)** done automatically, and
**Explicit (Narrowing / Casting)** done manually by the programmer.

**Points:**
1. **Implicit/Widening conversion** — automatic, when a *smaller* type is assigned to
   a *larger, compatible* type. No data loss, so the compiler does it for you.
2. Widening order: `byte → short → int → long → float → double`, and `char → int`.
3. **Explicit/Narrowing conversion (Type Casting)** — required when converting a
   *larger* type into a *smaller* one. May lose data/precision, so it must be done
   manually using the **cast operator**.
4. **Cast syntax:** `(targetType) value` — written right before the value.
5. Casting `double` → `int` **truncates** (chops decimal), does **not** round.
   e.g. `(int) 199.99` → `199`.
6. Widening = safe, automatic, no syntax needed. Narrowing = risky, manual, needs `(type)`.
7. Type conversion matters wherever operands of different types combine — in
   expressions, method calls, assignments.

**Syntax:**
```java
// Implicit (widening) — no syntax needed
double d = someInt;

// Explicit (narrowing) — cast operator required
int i = (int) someDouble;
```

**Comparison Table:**

| Basis | Widening (Implicit) | Narrowing (Explicit/Casting) |
|---|---|---|
| Direction | Small → Large | Large → Small |
| Done by | Compiler | Programmer, with `(type)` |
| Data loss | None | Possible |
| Example | `int → double` | `double → int` |

**Easiest Program:**
```java
public class TypeConversionCasting {
    public static void main(String[] args) {
        // Implicit widening
        int num = 100;
        double d = num;                 // int -> double, automatic
        char ch = 'A';
        int code = ch;                  // char -> int, automatic

        // Explicit narrowing / casting
        double price = 199.99;
        int rounded = (int) price;      // must cast; truncates to 199

        System.out.println("Widened double: " + d + ", widened int: " + code);
        System.out.println("Narrowed (cast) int: " + rounded);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ double d = 9; System.out.println(d + " " + (int)9.9); } }
```

---

## 4.2 Automatic Type Promotion (in expressions)

**Definition:** The automatic conversion Java applies to smaller types **while
evaluating an arithmetic expression**, so intermediate results don't overflow.

**Points:**
1. `byte`, `short`, and `char` are **always promoted to `int`** in arithmetic expressions.
2. If one operand is `long`, the whole expression is promoted to `long`.
3. If one operand is `float` (and none is `double`), expression promotes to `float`.
4. If any operand is `double`, the expression promotes to `double`.
5. This is why `byte a=40, b=50; byte c = a*b;` fails to compile — `a*b` becomes `int`,
   and needs an explicit cast back: `byte c = (byte)(a*b);`.
6. Needed because e.g. `byte * byte` can produce a result outside byte's range
   (40×50=2000, but byte only goes to 127).

**Syntax:**
```java
byte a = 10, b = 20;
int sum = a + b;              // a, b promoted to int automatically
byte c = (byte)(a + b);       // must cast explicitly back to byte
```

**Easiest Program:**
```java
public class PromotionDemo {
    public static void main(String[] args) {
        byte a = 10, b = 20;
        int sum = a + b;              // promoted to int
        char c1 = 'A';
        int result = c1 + 1;          // char promoted to int
        System.out.println("Sum: " + sum + ", Result: " + result);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ byte x=5,y=6; System.out.println(x+y); } }
```

---

## 4.3 Scope of Variables

**Definition:** Scope defines the region of a program within which a variable is
visible/accessible; a **block** `{ }` defines that region for local variables.

**Points:**
1. A variable declared inside a block is accessible **only within that block** (and any
   nested block inside it).
2. An **outer** block cannot access a variable declared inside an **inner** block.
3. An **inner** block *can* access variables declared in its enclosing outer block.
4. Blocks are used with methods, classes, loops, `if`, and exception handling.
5. Types of scope: **class-level (fields)** — accessible anywhere in the class; and
   **local (inside a method/block)** — accessible only within that method/block.
6. A variable's scope begins at its declaration and ends at the closing `}` of its block.
7. You cannot re-declare a variable with the same name in a nested scope if it already
   exists in an enclosing scope (shadowing error in Java, unlike some other languages).

**Easiest Program:**
```java
public class ScopeDemo {
    public static void main(String[] args) {
        int x = 10;                 // scope: whole main() method
        {
            int y = 20;              // scope: only this inner block
            System.out.println(x);   // valid — outer var visible inside inner block
            System.out.println(y);
        }
        System.out.println(x);       // valid
        // System.out.println(y);    // ERROR — y is out of scope here
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int x=1; { int y=2; System.out.println(x+y); } } }
```
