# 3. Data Types in Java

**Definition:** A data type defines the kind of value a variable can hold, the
operations allowed on it, and how much memory it needs. Java is **statically & strongly
typed** — every variable's type is fixed at declaration and checked at compile time.

**Points:**
1. Two categories: **Primitive** (8 built-in types) and **Non-Primitive/Reference**
   (`String`, Array, Class, Interface, Enum).
2. Primitive types store the **actual value** directly in stack memory.
3. Non-primitive types store a **reference/address** to an object in heap memory.
4. Primitive type names start lowercase (`int`); reference types usually start
   uppercase (`String`).
5. Once declared, a variable can't hold a different type's value without conversion.
6. Every primitive type has a **default value** (used for instance fields, not locals).
7. Non-primitive types can be `null`; primitives cannot.

---

## 3.1 Primitive Data Types (8 types, in 4 groups)

| Group | Types |
|---|---|
| Integer | `byte, short, int, long` |
| Floating-point | `float, double` |
| Character | `char` |
| Boolean | `boolean` |

**Details table (size, range hint, default value, literal suffix):**

| Type | Size | Default | Example Literal |
|---|---|---|---|
| `byte` | 1 byte | `0` | `byte b = 100;` |
| `short` | 2 bytes | `0` | `short s = 20000;` |
| `int` | 4 bytes | `0` | `int i = 50000;` |
| `long` | 8 bytes | `0L` | `long l = 15000000000L;` — needs `L` suffix |
| `float` | 4 bytes | `0.0f` | `float f = 10.5f;` — needs `f` suffix |
| `double` | 8 bytes | `0.0` | `double d = 10.5;` — default decimal type |
| `char` | 2 bytes (Unicode) | `'\u0000'` | `char c = 'A';` |
| `boolean` | 1 bit (JVM-dependent) | `false` | `boolean flag = true;` |

**Points:**
1. `byte`/`short` save memory in large arrays but are rarely used for normal variables.
2. `int` is the most commonly used type — counters, loop indices, general numbers.
3. `long` is needed when a value exceeds `int` range — **must** be suffixed with `L`.
4. `float` needs suffix `f`/`F`, else Java treats the decimal literal as `double` (compile error).
5. `double` is the default type for any decimal literal.
6. `char` stores a single 16-bit **Unicode** character (not just ASCII) — can also hold
   a numeric code, e.g. `char c = 65;` prints `'A'`.
7. `boolean` only has `true`/`false` — used for conditions.
8. Integer literals default to `int`; without `L`, a value bigger than `int`'s range is
   a **compile-time error**.

**Easiest Program (data types + default values + literals):**
```java
public class DataTypesDemo {
    static int instanceInt;          // default 0 (fields get defaults, locals don't)
    static boolean instanceBool;     // default false
    public static void main(String[] args) {
        byte b = 100;
        short s = 20000;
        int i = 50000;
        long l = 15000000000L;       // L required — exceeds int range
        float f = 10.5f;             // f required — else double
        double d = 3.14159;
        char c = 'A';
        boolean flag = true;

        System.out.println("byte=" + b + " short=" + s + " int=" + i);
        System.out.println("long=" + l + " float=" + f + " double=" + d);
        System.out.println("char=" + c + " boolean=" + flag);
        System.out.println("default int field=" + instanceInt + " default boolean field=" + instanceBool);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ System.out.println((byte)1+" "+(short)2+" "+3+" "+4L+" "+5.5f+" "+6.6+" "+'C'+" "+true); } }
```

---

## 3.2 Non-Primitive (Reference) Data Types

**Points:**
1. **String** — sequence of characters; a built-in class, not a primitive.
   `String name = "John";`
2. **Array** — collection of same-type elements in contiguous memory. **(see file
   05-Arrays.md for full detail, syntax, and "Define array" answer)**
3. **Class** — user-defined blueprint from which objects are created.
   `class Student { String name; int rollNo; }`
4. **Interface** — reference type with only abstract methods/constants, used for abstraction.
5. Created mostly by the programmer (except `String`, which Java provides).
6. Stored in **heap** memory; the reference variable itself lives in the **stack**.
7. Can be `null`. Support method calls (`str.length()`) — primitives cannot.

**Primitive vs Non-Primitive:**

| Basis | Primitive | Non-Primitive |
|---|---|---|
| Defined by | Java (built-in) | Programmer (mostly) |
| Stores | Actual value | Reference/address |
| Memory | Stack | Heap (object) + Stack (reference) |
| Can be null? | No | Yes |
| Example | `int, char, boolean` | `String, Array, Class` |

**Easiest Program:**
```java
public class RefTypesDemo {
    public static void main(String[] args) {
        String name = "Prahlad";        // String (reference)
        int[] marks = {90, 85, 76};     // Array (reference)
        System.out.println(name + " has " + marks.length + " marks, first: " + marks[0]);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ System.out.println("hi".length()); } }
```
