# 2. Lexical Issues in Java

**Definition:** Lexical issues (lexical structure/elements) are the basic rules that
govern how Java source code is written using its character set, before the compiler
can understand its meaning — i.e. how the smallest meaningful units (**tokens**) are
formed.

**The 6 lexical issues:** Whitespace, Identifiers, Literals, Comments, Separators, Keywords.

---

## 2.1 Whitespace

**Points:**
1. Whitespace = space, tab, or newline.
2. Used to separate one token from another and improve readability.
3. Extra whitespace between tokens is ignored by the compiler.
4. At least one whitespace is required between two tokens that would otherwise merge
   (e.g. a keyword and identifier: `int` and `x` need a space, else it reads `intx`).
5. Indentation is **not** syntactically significant — used only for human readability.

**Smallest Program:**
```java
public class W { public static void main(String[] a) { int   x   =   5 ; System.out.println(x); } }
```

## 2.2 Identifiers

**Definition:** Names given by the programmer to variables, methods, classes,
interfaces, arrays, packages, etc.

**Points (rules):**
1. May contain letters (A-Z, a-z), digits (0-9), underscore `_`, and dollar `$`.
2. Must **not** begin with a digit.
3. Case-sensitive — `Total` and `total` are different identifiers.
4. No length limit.
5. Cannot be a reserved keyword (`int`, `class`, `for`, ...).
6. No other special characters allowed (no spaces, `@`, `#`, `%`, `-`).

**Valid:** `AvgTemp`, `count`, `a_1`, `$salary`, `_value`
**Invalid:** `2count` (starts with digit), `avg-temp` (hyphen), `class` (keyword)

## 2.3 Literals

**Definition:** A literal is a constant value written directly in code and assigned to
a variable (it never changes).

**Points (6 types):**
1. **Integer literal** — whole numbers: `10`, `010` (octal), `0x1A` (hex), `0b1010` (binary).
2. **Floating-point literal** — has a decimal point: `3.14`, `2.0f`.
3. **Character literal** — one character in single quotes: `'A'`, `'9'`, `'\n'`.
4. **String literal** — text in double quotes: `"Hello World"`.
5. **Boolean literal** — only `true` or `false`.
6. **Null literal** — `null`, absence of a reference; cannot be assigned to primitives.
7. Integer literals default to `int`; must add `L` for values exceeding `int` range (long).
8. Decimal literals default to `double`; must add `f`/`F` to make them `float`.

**Easiest Program:**
```java
public class LiteralsDemo {
    public static void main(String[] args) {
        int a = 10;            // integer literal
        long pop = 5000000000L; // long literal, L required
        double d = 3.14;        // double (default)
        float f = 3.14f;        // float, f required
        char ch = 'A';          // character literal
        String s = "Hello";     // string literal
        boolean b = true;       // boolean literal
        String nm = null;       // null literal
        System.out.println(a + " " + pop + " " + d + " " + f + " " + ch + " " + s + " " + b + " " + nm);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ System.out.println(10 + " " + 3.14 + " " + 'A' + " " + true); } }
```

## 2.4 Comments

**Points (3 types):**
1. **Single-line**: `// comment` — till end of line.
2. **Multi-line/block**: `/* comment */` — cannot be nested.
3. **Documentation**: `/** ... */` — processed by the `javadoc` tool with tags like
   `@author`, `@version` to auto-generate HTML documentation.
4. All comments are ignored by the compiler — zero effect on the compiled bytecode.
5. Used purely to explain code to human readers.

**Syntax:**
```java
// single-line
/* multi
   line */
/** doc comment
 *  @author Name
 */
```

## 2.5 Separators (Punctuators)

**Points:**

| Symbol | Name | Use |
|---|---|---|
| `()` | Parentheses | Method calls, parameter lists, grouping |
| `{}` | Braces | Defines a block (class/method/loop body) |
| `[]` | Brackets | Array declaration/indexing |
| `;` | Semicolon | Terminates a statement |
| `,` | Comma | Separates identifiers/parameters |
| `.` | Period/Dot | Package names, accessing class/object members |

## 2.6 Keywords (Reserved Words)

**Definition:** Words reserved by Java for a predefined purpose — cannot be used as identifiers.

**Points:**
1. Java has 50+ keywords, e.g. `abstract, boolean, break, byte, case, catch, char,
   class, continue, default, do, double, else, enum, extends, final, finally, float,
   for, if, implements, import, instanceof, int, interface, long, new, package,
   private, protected, public, return, short, static, super, switch, synchronized,
   this, throw, throws, try, void, volatile, while`.
2. `const` and `goto` are reserved but **not used** in Java.
3. `true`, `false`, `null` are technically **literals**, not keywords, but are also
   reserved and can't be used as identifiers.
4. Keywords are always lowercase.
5. Trying to use a keyword as a variable name (e.g. `int class = 5;`) is a compile error.
