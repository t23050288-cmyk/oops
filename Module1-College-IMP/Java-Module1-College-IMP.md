# JAVA — Module 1 College IMP Questions (with Answers)

> The 10 questions below are exactly as given in the college "JAVA – Module 1
> QUESTIONS" sheet. Each answer follows: **Definition → Points → Syntax →
> Program with output**. All programs are in [programs/](programs/) and were
> **compiled and run** (JDK 17) to verify the output shown.

---

## 1. Discuss the lexical issues in Java.

### Definition
Lexical issues are the basic rules for how Java source code is written: the
smallest meaningful units (called **tokens**) that the compiler reads before it
understands the meaning of the program. A Java program is a collection of
whitespace, identifiers, literals, comments, separators and keywords.

### Syntax
```java
// Identifier rule
identifier = letter | _ | $  followed by  (letter | digit | _ | $)*

// Declaration using identifier + literal
dataType identifier = literal;

// Comments
// single-line comment
/* multi-line comment */
/** documentation comment */
```

### The 6 Lexical Elements

#### 1. Whitespace
1. Whitespace = space, tab, newline (and form feed).
2. Java is a **free-form** language: no special indentation is needed.
3. Whitespace separates tokens; extra whitespace is ignored by the compiler.
4. At least one whitespace is needed between two tokens that would otherwise
   merge (`int x` is valid, `intx` is a different identifier).

#### 2. Identifiers
Names given by the programmer to classes, methods, variables, etc.
1. Can contain letters, digits, underscore `_` and dollar `$`.
2. Must **not start with a digit**.
3. **Case-sensitive**: `Total` and `total` are different.
4. Cannot be a keyword (`class`, `int`...).
5. Valid: `AvgTemp`, `count`, `a4`, `$test`, `this_is_ok`.
   Invalid: `2count`, `high-temp`, `Not/ok`.

#### 3. Literals
A constant value written directly in the program.
| Type | Examples |
|---|---|
| Integer | `100`, `0x1F` (hex), `0b101` (binary), `017` (octal), `1_000_000` |
| Floating-point | `3.14`, `2.5f`, `1.5e3` |
| Character | `'A'`, `'\n'`, `'\u0041'` |
| String | `"Hello"` |
| Boolean | `true`, `false` |
| Null | `null` |

#### 4. Comments
Ignored by the compiler; used for documentation.
1. **Single-line:** `// comment`
2. **Multi-line:** `/* comment */`
3. **Documentation:** `/** comment */` (used by the `javadoc` tool)

#### 5. Separators
Symbols that separate/group code.
| Symbol | Name | Use |
|---|---|---|
| `;` | Semicolon | ends a statement |
| `,` | Comma | separates variables / parameters |
| `.` | Period | package/class/member access |
| `( )` | Parentheses | method calls, expressions, conditions |
| `{ }` | Braces | blocks, class body, array initializers |
| `[ ]` | Brackets | array declaration / indexing |

#### 6. Keywords
Reserved words with a fixed meaning; **cannot be used as identifiers**.
1. Java has **50 keywords** (e.g. `class`, `public`, `static`, `int`, `if`, `for`, `new`, `return`).
2. `true`, `false`, `null` are reserved literals (also cannot be used as names).
3. `const` and `goto` are reserved but not used.
4. All keywords are lowercase.

### Program (`programs/LexicalDemo.java`)
```java
public class LexicalDemo {                       // identifier + keywords
    public static void main(String[] args) {     // separators
        /* multi-line comment */
        int studentAge = 20;                     // identifier + integer literal
        double pi = 3.14;                        // floating literal
        char grade = 'A';                        // character literal
        String name = "Ravi";                    // string literal
        boolean pass = true;                     // boolean literal
        int hex = 0x1F, bin = 0b101, big = 1_000_000;
        System.out.println(name + " " + studentAge + " " + grade + " " + pi + " " + pass);
        System.out.println(hex + " " + bin + " " + big);
    }
}
```
**Output:**
```
Ravi 20 A 3.14 true
31 5 1000000
```

---

## 2. Explain the object-oriented principles of OOPS in detail.

### Definition
Object-Oriented Programming (OOP) is a programming approach that organizes a
program around **objects** (data + the methods that work on it) instead of
around functions. Its four principles are **Abstraction, Encapsulation,
Inheritance and Polymorphism**.

### Syntax
```java
// Abstraction
abstract class ClassName {
    abstract returnType methodName(parameters);
}
interface InterfaceName {
    returnType methodName(parameters);
}

// Encapsulation
class ClassName {
    private dataType variableName;
    public dataType getVariableName() { return variableName; }
    public void setVariableName(dataType value) { this.variableName = value; }
}

// Inheritance
class SubClass extends SuperClass {
    // members
}

// Polymorphism - overloading (same name, different parameters)
returnType methodName(type1 a) { }
returnType methodName(type1 a, type2 b) { }

// Polymorphism - overriding (same signature in subclass)
@Override
returnType methodName(parameters) { }
```

### Two Paradigms (background)
1. **Process-oriented (procedural):** code acts on data; data is global and
   less protected. Example: C.
2. **Object-oriented:** data and code are bundled into objects; data is
   protected. Example: Java.

### Principle 1: Abstraction
Hiding the complex implementation and showing only the essential features.
1. Focus on **what** an object does, not **how**.
2. Real life: you drive a car using steering, pedals; you don't need to know
   how the engine works.
3. In Java: achieved using **abstract classes** and **interfaces**.
4. Manages complexity and lets the internal code change without affecting users.
```java
abstract class Shape { abstract double area(); }   // only WHAT
```

### Principle 2: Encapsulation
Binding data and the methods that operate on it into one unit (the **class**),
and protecting the data from outside access.
1. Variables are kept `private`; accessed through `public` getter/setter methods.
2. Also called **data hiding**.
3. Gives control: a setter can validate before changing data.
4. Real life: a medicine capsule keeps the contents safe inside.
```java
class Circle {
    private double r;                       // hidden
    public double getR() { return r; }
    public void setR(double r) { if (r > 0) this.r = r; }   // validation
}
```

### Principle 3: Inheritance
One class (subclass) acquires the properties and methods of another class
(superclass) using the `extends` keyword.
1. Promotes **code reusability**: write common code once.
2. Creates an **IS-A** relationship (Circle IS-A Shape).
3. Subclass can add new members or override inherited methods.
4. Java supports single, multilevel and hierarchical inheritance (multiple
   inheritance of classes is not allowed; use interfaces).
```java
class Animal { void eat() {} }
class Dog extends Animal { void bark() {} }
```

### Principle 4: Polymorphism
"Many forms": the same method name behaves differently in different situations.
1. **Compile-time polymorphism:** method **overloading** (same name, different
   parameters, same class).
2. **Run-time polymorphism:** method **overriding** (subclass redefines the
   superclass method; chosen at run time by the actual object).
3. Real life: the same person is a student, a son and a friend.
```java
static int add(int a, int b)       { return a + b; }
static double add(double a, double b) { return a + b; }   // overloading
```

### Program (`programs/OOPPrinciplesDemo.java`)
```java
abstract class Shape { abstract double area(); }           // ABSTRACTION
class Circle extends Shape {                               // INHERITANCE
    private double r;                                      // ENCAPSULATION
    Circle(double r) { this.r = r; }
    double area() { return 3.14159 * r * r; }              // POLYMORPHISM (override)
}
class Rectangle extends Shape {
    private double l, b;
    Rectangle(double l, double b) { this.l = l; this.b = b; }
    double area() { return l * b; }
}
public class OOPPrinciplesDemo {
    static int add(int a, int b) { return a + b; }
    static double add(double a, double b) { return a + b; }
    public static void main(String[] args) {
        Shape s1 = new Circle(5), s2 = new Rectangle(4, 6);
        System.out.println("Circle area    = " + s1.area());
        System.out.println("Rectangle area = " + s2.area());
        System.out.println(add(2, 3) + " " + add(2.5, 3.5));
    }
}
```
**Output:**
```
Circle area    = 78.53975
Rectangle area = 24.0
5 6.0
```

---

## 3. Explain the different types of operators in Java with appropriate examples.

### Definition
An operator is a symbol that performs an operation on one or more operands
(values/variables) and produces a result.

### Syntax
```java
operand1 operator operand2;          // binary operators (+ - * / % == && & << ...)
operator operand;                    // unary operators (++ -- ! ~ -)
variable operator= value;            // compound assignment (+= -= *= ...)
variable = (condition) ? value1 : value2;     // ternary operator
objectName instanceof ClassName      // instanceof operator
```

### Types of Operators

#### 1. Arithmetic: `+ - * / %`
1. `+` add, `-` subtract, `*` multiply, `/` divide, `%` remainder (modulus).
2. Integer division discards the fraction: `10 / 3 = 3`; `10 % 3 = 1`.

#### 2. Unary: `+ - ++ -- !`
1. `++` / `--` increase / decrease by 1.
2. **Post** (`x++`): use the value, then change it. **Pre** (`++x`): change it, then use it.
3. `-x` negates; `!` reverses a boolean.

#### 3. Relational: `== != > < >= <=`
1. Compare two values; the result is always `boolean`.
2. Used in `if` and loops.

#### 4. Logical: `&& || !`
1. `&&` AND (true only if both true), `||` OR (true if any true), `!` NOT.
2. **Short-circuit:** `&&` skips the right side if the left is false; `||`
   skips it if the left is true.

#### 5. Assignment: `= += -= *= /= %=`
1. `x += 5` means `x = x + 5` (compound assignment).

#### 6. Bitwise: `& | ^ ~`
Work on individual bits of integers. With `5 = 0101`, `3 = 0011`:
`5 & 3 = 1`, `5 | 3 = 7`, `5 ^ 3 = 6`, `~5 = -6`.

#### 7. Shift: `<< >> >>>`
1. `<<` left shift: multiplies by 2 per shift (`8 << 2 = 32`).
2. `>>` signed right shift: divides by 2, keeps sign (`8 >> 2 = 2`).
3. `>>>` unsigned right shift: fills with 0 (`-8 >>> 28 = 15`).

#### 8. Ternary: `? :`
Short form of if-else: `result = (condition) ? value1 : value2;`

#### 9. instanceof
Checks whether an object belongs to a class; returns `boolean`.

### Program (`programs/OperatorsDemo.java`)
```java
public class OperatorsDemo {
    public static void main(String[] args) {
        int a = 10, b = 3;
        System.out.println("a+b=" + (a+b) + " a-b=" + (a-b) + " a*b=" + (a*b) + " a/b=" + (a/b) + " a%b=" + (a%b));
        int x = 5;
        System.out.println("x++=" + (x++) + " x=" + x + " ++x=" + (++x) + " -x=" + (-x));
        System.out.println("a>b " + (a>b) + ", a==b " + (a==b) + ", a!=b " + (a!=b));
        System.out.println("&&: " + (a>5 && b<5) + "  ||: " + (a<5 || b<5) + "  !: " + !(a>5));
        int c = 5; c += 3; c *= 2;
        System.out.println("c=" + c);
        System.out.println("5&3=" + (5&3) + " 5|3=" + (5|3) + " 5^3=" + (5^3) + " ~5=" + (~5));
        System.out.println("8<<2=" + (8<<2) + " 8>>2=" + (8>>2) + " -8>>>28=" + (-8>>>28));
        int max = (a > b) ? a : b;
        System.out.println("max=" + max);
        String s = "hi";
        System.out.println("s instanceof String: " + (s instanceof String));
    }
}
```
**Output:**
```
a+b=13 a-b=7 a*b=30 a/b=3 a%b=1
x++=5 x=6 ++x=7 -x=-7
a>b true, a==b false, a!=b true
&&: true  ||: true  !: false
c=16
5&3=1 5|3=7 5^3=6 ~5=-6
8<<2=32 8>>2=2 -8>>>28=15
max=10
s instanceof String: true
```

---

## 4. Explain the selection statements in Java and discuss its different types with suitable examples.

### Definition
Selection (decision-making) statements choose which block of code to execute
depending on a condition. Java has two: **`if`** and **`switch`**.

### Syntax
```java
// simple if
if (condition) {
    statements;
}

// if-else
if (condition) {
    statements;
} else {
    statements;
}

// if-else-if ladder
if (condition1) {
    statements;
} else if (condition2) {
    statements;
} else {
    statements;
}

// nested if
if (condition1) {
    if (condition2) {
        statements;
    }
}

// switch
switch (expression) {
    case value1: statements; break;
    case value2: statements; break;
    default: statements;
}
```

### A. The `if` statement and its types

#### (i) Simple if
Runs the block only if the condition is true.
```java
if (condition) { statements; }
```

#### (ii) if-else
Runs one block if true, another if false.
```java
if (condition) { ... } else { ... }
```

#### (iii) if-else-if ladder
Tests conditions from top to bottom; the first true one runs and the rest are
skipped; the last `else` is the default.
```java
if (c1) { ... } else if (c2) { ... } else if (c3) { ... } else { ... }
```

#### (iv) Nested if
An `if` inside another `if`; used when one decision depends on another.
```java
if (c1) { if (c2) { ... } }
```
**Points:** the condition must be a `boolean` expression (an `int` is not
allowed, unlike C).

### B. The `switch` statement
Multi-way branch: compares one expression against several constant `case` values.

**Syntax:**
```java
switch (expression) {
    case value1: statements; break;
    case value2: statements; break;
    default: statements;
}
```
**Points:**
1. Expression can be `byte, short, int, char, String` or `enum`.
2. `case` values must be constants and unique.
3. **`break`** exits the switch; without it, execution **falls through** into
   the next case.
4. `default` is optional and runs when nothing matches.

### Program (`programs/SelectionDemo.java`)
```java
public class SelectionDemo {
    public static void main(String[] args) {
        int marks = 72;
        if (marks >= 35) System.out.println("Pass");
        if (marks % 2 == 0) System.out.println("Even"); else System.out.println("Odd");
        if (marks >= 90) System.out.println("Grade S");
        else if (marks >= 70) System.out.println("Grade A");
        else if (marks >= 50) System.out.println("Grade B");
        else System.out.println("Grade C");
        int age = 20; boolean hasId = true;
        if (age >= 18) { if (hasId) System.out.println("Can vote"); }
        int day = 3;
        switch (day) {
            case 1: System.out.println("Mon"); break;
            case 2: System.out.println("Tue"); break;
            case 3: System.out.println("Wed"); break;
            default: System.out.println("Other");
        }
        switch (2) { case 1: System.out.print("one "); case 2: System.out.print("two "); case 3: System.out.println("three"); }
    }
}
```
**Output:**
```
Pass
Even
Grade A
Can vote
Wed
two three          <- fall-through: no break after case 2
```

---

## 5. Explain the looping statements in Java.

### Definition
Looping (iteration) statements execute a block of code **repeatedly** as long
as a condition is true.

### Syntax
```java
// while
while (condition) {
    statements;
}

// do-while
do {
    statements;
} while (condition);

// for
for (initialization; condition; update) {
    statements;
}

// for-each
for (dataType variable : arrayName) {
    statements;
}
```

### The 4 Loops (explained)

#### 1. while (entry-controlled)
Condition checked **before** the body; may run **0 times**.
```java
while (condition) { body; }
```

#### 2. do-while (exit-controlled)
Condition checked **after** the body; always runs **at least once**. Note the
semicolon at the end.
```java
do { body; } while (condition);
```

#### 3. for
Puts initialization, condition and update in one line (best when the number
of repetitions is known).
```java
for (initialization; condition; update) { body; }
```

#### 4. for-each (enhanced for)
Goes through every element of an array/collection with no index.
```java
for (dataType var : array) { body; }
```

### Comparison
| Loop | Condition checked | Min. runs | Use when |
|---|---|---|---|
| while | before body | 0 | count unknown |
| do-while | after body | 1 | must run once (menus) |
| for | before body | 0 | count known |
| for-each | automatic | 0 | traverse array/collection |

### Program (`programs/LoopsDemo.java`)
```java
public class LoopsDemo {
    public static void main(String[] args) {
        int i = 1;
        System.out.print("while: ");
        while (i <= 5) { System.out.print(i + " "); i++; }
        System.out.print("\ndo-while (runs once even if false): ");
        int j = 10;
        do { System.out.print(j + " "); j++; } while (j < 5);
        System.out.print("\nfor: ");
        for (int k = 1; k <= 5; k++) System.out.print(k + " ");
        System.out.print("\nfor-each: ");
        int[] arr = {10, 20, 30};
        for (int v : arr) System.out.print(v + " ");
        System.out.println();
    }
}
```
**Output:**
```
while: 1 2 3 4 5
do-while (runs once even if false): 10
for: 1 2 3 4 5
for-each: 10 20 30
```

---

## 6. Explain the for statement in detail. Also explain the different variations of the for loop with suitable examples.

### Definition
The `for` statement is a loop that combines **initialization, condition and
update** in a single line, making it compact for counter-controlled repetition.

### Syntax
```java
for (initialization; condition; update) {
    statements;
}

// for-each variation
for (dataType variable : arrayName) {
    statements;
}
```

### How it works (flow)
```
1. initialization   (executed ONCE)
2. condition?  -- false --> exit loop
        | true
3. body
4. update  --> back to step 2
```
**Points:**
1. Initialization runs only once, at the start.
2. Condition is tested before every iteration.
3. Update runs after every iteration of the body.
4. A variable declared in the initialization is local to the loop.

### Variations of the for loop

| # | Variation | Example |
|---|---|---|
| 1 | Standard | `for (int i=1; i<=3; i++)` |
| 2 | Multiple variables (comma) | `for (int i=0, j=5; i<j; i++, j--)` |
| 3 | Missing initialization | `int k=1; for (; k<=3; k++)` |
| 4 | Missing update | `for (int m=1; m<=3; ) { ...; m++; }` |
| 5 | Infinite loop | `for (;;) { if (cond) break; }` |
| 6 | Empty body | `for (int i=1; i<=5; sum += i++) ;` |
| 7 | Nested for | a loop inside a loop (patterns, matrices) |
| 8 | For-each | `for (int v : arr)` |

### Program (`programs/ForVariations.java`)
```java
public class ForVariations {
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) System.out.print(i + " ");
        System.out.println("<- standard");
        for (int i = 0, j = 5; i < j; i++, j--) System.out.print("(" + i + "," + j + ") ");
        System.out.println("<- two variables");
        int k = 1;
        for (; k <= 3; k++) System.out.print(k + " ");
        System.out.println("<- no init");
        for (int m = 1; m <= 3; ) { System.out.print(m + " "); m++; }
        System.out.println("<- no update");
        int n = 0;
        for (;;) { if (++n > 3) break; System.out.print(n + " "); }
        System.out.println("<- infinite with break");
        int sum = 0;
        for (int i = 1; i <= 5; sum += i++) ;
        System.out.println("sum=" + sum + " <- empty body");
        for (int i = 1; i <= 3; i++) { for (int j = 1; j <= i; j++) System.out.print("* "); System.out.println(); }
        for (String s : new String[]{"a", "b", "c"}) System.out.print(s + " ");
        System.out.println("<- for-each");
    }
}
```
**Output:**
```
1 2 3 <- standard
(0,5) (1,4) (2,3) <- two variables
1 2 3 <- no init
1 2 3 <- no update
1 2 3 <- infinite with break
sum=15 <- empty body
*
* *
* * *
a b c <- for-each
```

---

## 7. Explain the jump statements in Java with suitable examples.

### Definition
Jump statements transfer control to another part of the program. Java has
three: **`break`, `continue`, `return`** (Java has no `goto`).

### Syntax
```java
break;                  // exit loop / switch
break label;            // exit labeled outer loop

continue;               // skip to next iteration
continue label;         // next iteration of labeled outer loop

return;                 // exit a void method
return value;           // exit method and give back a value

label:                  // label placed before the loop
for (initialization; condition; update) { statements; }
```

### 1. break
1. Immediately **exits** the loop or `switch` it is in.
2. **Labeled break** `break label;` exits an outer (named) loop.
```java
for (int i = 1; i <= 5; i++) { if (i == 4) break; System.out.print(i + " "); }  // 1 2 3
```

### 2. continue
1. **Skips** the rest of the current iteration and goes to the next one.
2. **Labeled continue** `continue label;` jumps to the next iteration of the outer loop.
```java
for (int i = 1; i <= 5; i++) { if (i == 3) continue; System.out.print(i + " "); } // 1 2 4 5
```

### 3. return
1. **Exits the current method** and returns control to the caller.
2. Can return a value: `return value;` (or nothing in a `void` method).

### Program (`programs/JumpDemo.java`)
```java
public class JumpDemo {
    static int square(int n) { return n * n; }
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) { if (i == 4) break; System.out.print(i + " "); }
        System.out.println("<- break");
        for (int i = 1; i <= 5; i++) { if (i == 3) continue; System.out.print(i + " "); }
        System.out.println("<- continue");
        outer:
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 3; j++) {
                if (j == 2) continue outer;
                if (i == 3) break outer;
                System.out.print("(" + i + "," + j + ") ");
            }
        System.out.println("<- labeled");
        System.out.println(square(6) + " <- return");
    }
}
```
**Output:**
```
1 2 3 <- break
1 2 4 5 <- continue
(1,1) (2,1) <- labeled
36 <- return
```

---

## 8. Explain type conversion and type casting in Java with suitable examples.

### Definition
- **Type conversion:** changing a value from one data type to another
  **automatically** by the compiler.
- **Type casting:** changing a value from one data type to another
  **manually (explicitly)** by the programmer using `(type)`.

### Syntax
```java
// Widening (automatic) - no cast needed
largerType variable = smallerTypeValue;

// Narrowing (explicit casting)
smallerType variable = (smallerType) largerTypeValue;
```

### 1. Automatic (Widening) Conversion
Done automatically when **both** conditions hold: the types are compatible and
the destination is **larger** than the source (no data loss).
```
byte -> short -> int -> long -> float -> double
              char -> int
```
```java
int i = 100;  long l = i;  float f = l;  double d = f;   // all automatic
```

### 2. Explicit (Narrowing) Casting
Needed when converting a **larger** type to a **smaller** type; may lose data.
```java
(target-type) value
```
1. `double` to `int`: fractional part is **truncated** (not rounded).
   `(int) 9.99` gives `9`.
2. `int` to `byte`: value is reduced modulo 256.
   `(byte) 300` gives `44` (300 - 256).
3. `char` to `int` gives the Unicode value: `'A'` gives `65`.

### 3. Automatic Type Promotion in Expressions
`byte`, `short` and `char` are promoted to `int` when used in an expression,
so `byte * byte` gives an `int`.
```java
byte p = 50, q = 20;
int r = p * q;     // 1000: needs int, would overflow a byte
```

### Program (`programs/ConversionDemo.java`)
```java
public class ConversionDemo {
    public static void main(String[] args) {
        int i = 100; long l = i; float f = l; double d = f;
        System.out.println(i + " " + l + " " + f + " " + d);
        double x = 9.99; int y = (int) x;
        System.out.println(x + " -> " + y);
        int big = 300; byte b = (byte) big;
        System.out.println(big + " -> " + b);
        char c = 'A'; int code = c; char next = (char)(c + 1);
        System.out.println(c + " " + code + " " + next);
        byte p = 50, q = 20; int r = p * q;
        System.out.println(r);
        System.out.println(7 / 2 + " " + (double) 7 / 2);
    }
}
```
**Output:**
```
100 100 100.0 100.0
9.99 -> 9
300 -> 44
A 65 B
1000
3 3.5
```

---

## 9. Explain operator precedence and associativity in Java with suitable examples.

### Definition
- **Precedence:** decides which operator is evaluated **first** when an
  expression has several different operators (higher precedence first).
- **Associativity:** decides the order (left-to-right or right-to-left) when
  operators have the **same precedence**.

### Syntax
```java
result = operand1 operator1 operand2 operator2 operand3;   // precedence decides order

result = (operand1 operator1 operand2) operator2 operand3; // () forces order

variable1 = variable2 = value;                             // right-to-left associativity
```

### Precedence Table (highest to lowest)
| Level | Operators | Associativity |
|---|---|---|
| 1 | `()` `[]` `.` | left to right |
| 2 | `x++` `x--` (postfix) | left to right |
| 3 | `++x` `--x` `+x` `-x` `!` `~` (unary) | **right to left** |
| 4 | `*` `/` `%` | left to right |
| 5 | `+` `-` | left to right |
| 6 | `<<` `>>` `>>>` | left to right |
| 7 | `<` `<=` `>` `>=` `instanceof` | left to right |
| 8 | `==` `!=` | left to right |
| 9 | `&` | left to right |
| 10 | `^` | left to right |
| 11 | `\|` | left to right |
| 12 | `&&` | left to right |
| 13 | `\|\|` | left to right |
| 14 | `? :` (ternary) | **right to left** |
| 15 | `=` `+=` `-=` ... | **right to left** |

### Examples
1. `10 + 5 * 2 = 20` : `*` has higher precedence than `+`.
2. `(10 + 5) * 2 = 30` : parentheses override precedence.
3. `100 / 10 * 2 = 20` : `/` and `*` are equal, so **left to right**: (100/10)*2.
4. `a = b = c = 5` : assignment is **right to left**: c=5, then b=c, then a=b.
5. `2 + 3 + "A" + 2 + 3 = 5A23` : `+` is left to right; 2+3=5 first, then string joining.

### Program (`programs/PrecedenceDemo.java`)
```java
public class PrecedenceDemo {
    public static void main(String[] args) {
        System.out.println(10 + 5 * 2);
        System.out.println((10 + 5) * 2);
        System.out.println(100 / 10 * 2);
        System.out.println(2 + 3 > 4 && 1 < 2);
        int a, b, c;
        a = b = c = 5;
        System.out.println(a + " " + b + " " + c);
        int x = 2;
        int y = x++ + ++x * 2;
        System.out.println(y + " " + x);
        System.out.println(true ? 1 : false ? 2 : 3);
        System.out.println(2 + 3 + "A" + 2 + 3);
    }
}
```
**Output:**
```
20
30
20
true
5 5 5
10 4          <- x++ gives 2 (x becomes 3); ++x makes x 4, gives 4; 2 + 4*2 = 10
1
5A23
```

---

## 10. Discuss about the primitive data types in Java.

### Definition
Primitive data types are the **8 basic built-in types** of Java that store
simple values **directly** (not as objects). Java is **strongly typed**: every
variable must be declared with a type.

### Syntax
```java
dataType variableName;                  // declaration
dataType variableName = value;          // declaration + initialization

// 8 primitive types
byte    variableName = value;
short   variableName = value;
int     variableName = value;
long    variableName = valueL;          // L suffix
float   variableName = valuef;          // f suffix
double  variableName = value;
char    variableName = 'character';
boolean variableName = true / false;
```

### The 8 Primitive Types
Grouped into four categories:

| Group | Type | Size | Range | Default | Example |
|---|---|---|---|---|---|
| Integer | `byte` | 8 bits | -128 to 127 | 0 | `byte b = 100;` |
| Integer | `short` | 16 bits | -32,768 to 32,767 | 0 | `short s = 20000;` |
| Integer | `int` | 32 bits | -2^31 to 2^31-1 (about +-2.1 billion) | 0 | `int i = 50000;` |
| Integer | `long` | 64 bits | -2^63 to 2^63-1 | 0L | `long l = 15000000000L;` |
| Floating | `float` | 32 bits | about 7 decimal digits precision | 0.0f | `float f = 10.5f;` |
| Floating | `double` | 64 bits | about 15 decimal digits precision | 0.0 | `double d = 3.14;` |
| Character | `char` | 16 bits | 0 to 65,535 (Unicode) | '\u0000' | `char c = 'A';` |
| Boolean | `boolean` | JVM-dependent | `true` / `false` | false | `boolean ok = true;` |

### Points
1. **Integers** hold whole numbers (signed); `int` is the most commonly used.
2. **Floating-point** hold numbers with fractions; `double` is the default for
   decimal literals, so `float` needs the `f` suffix.
3. `long` literals need the `L` suffix when beyond the `int` range.
4. **char** uses 16-bit **Unicode** (not 8-bit ASCII), so it supports all languages.
5. **boolean** holds only `true`/`false`; it cannot be converted to/from numbers.
6. Sizes are **fixed** on every machine, which makes Java portable.
7. Default values apply to instance/static variables; **local variables must
   be initialized** before use.
8. Primitives are not objects; each has a wrapper class (`Integer`, `Double`...).

### Program (`programs/PrimitiveTypesDemo.java`)
```java
public class PrimitiveTypesDemo {
    static byte db; static short ds; static int di; static long dl;
    static float df; static double dd; static char dc; static boolean dbo;
    public static void main(String[] args) {
        byte b = 100; short s = 20000; int i = 50000; long l = 15000000000L;
        float f = 10.5f; double d = 3.14159; char c = 'A'; boolean flag = true;
        System.out.println("byte=" + b + " short=" + s + " int=" + i + " long=" + l);
        System.out.println("float=" + f + " double=" + d + " char=" + c + " boolean=" + flag);
        System.out.println("Ranges: byte " + Byte.MIN_VALUE + ".." + Byte.MAX_VALUE
            + ", short " + Short.MIN_VALUE + ".." + Short.MAX_VALUE);
        System.out.println("int " + Integer.MIN_VALUE + ".." + Integer.MAX_VALUE);
        System.out.println("long " + Long.MIN_VALUE + ".." + Long.MAX_VALUE);
        System.out.println("Defaults: " + db + " " + ds + " " + di + " " + dl + " " + df + " " + dd + " [" + (int) dc + "] " + dbo);
    }
}
```
**Output:**
```
byte=100 short=20000 int=50000 long=15000000000
float=10.5 double=3.14159 char=A boolean=true
Ranges: byte -128..127, short -32768..32767
int -2147483648..2147483647
long -9223372036854775808..9223372036854775807
Defaults: 0 0 0 0 0.0 0.0 [0] false
```
