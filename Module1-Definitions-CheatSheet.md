# Module 1 — All Definitions Cheat Sheet (Easy to Understand & Tell to Ma'am)

> Each concept: **simple definition → key points to remember → syntax (if applicable)**
> Read this before the exam and you can explain any term to ma'am confidently.

---

## 1. Programming Paradigm

**What it is:** A paradigm is the style/approach used to organize a program — basically, "how do we structure code?"

**Points to remember:**
- Two main paradigms: **Procedural** (organize around code/functions) and **Object-Oriented** (organize around data/objects)
- Procedural = data is passive, functions act on it (e.g. C)
- OOP = data and methods are bundled together into objects (e.g. Java)
- OOP is better for large programs because data is protected, not floating around

---

## 2. Compile Once, Run Anywhere (Platform Independence)

**What it is:** You compile Java code once, and the resulting bytecode runs on any OS (Windows, Mac, Linux) without recompiling.

**Points to remember:**
- `.java` file → compiled by `javac` → `.class` file (bytecode)
- Bytecode is NOT machine code — it's an intermediate form
- Every OS has its own JVM that reads the same bytecode and runs it
- So you compile once, and that same `.class` runs anywhere a JVM exists

**Flow:**
```
MyProg.java → (javac) → MyProg.class (bytecode) → (JVM on any OS) → Output
```

---

## 3. Abstraction

**What it is:** Hiding the unnecessary internal details and showing only the essential features of an object.

**Easy example:** When you drive a car, you just know the steering, brake, and accelerator. You don't need to know how the engine works inside — that's abstraction.

**Points to remember:**
- Focus on **what** an object does, not **how** it does it
- Achieved using **abstract classes** and **interfaces** in Java
- Makes code easier to use — you don't need to understand internals
- Internal implementation can change later without breaking outside code

**Syntax (interface = pure abstraction):**
```java
interface Shape {
    double area();    // only the "what", no body — no "how"
}
```

---

## 4. Encapsulation

**What it is:** Wrapping data and the methods that work on that data into a single unit (a class), and hiding the data from outside access.

**Easy example:** A capsule pill — the medicine (data) is enclosed inside a protective shell (class). You can only take it through the proper method (swallowing), not directly.

**Points to remember:**
- Data is kept `private` — outside code can't access it directly
- Access is through `public` methods (getters/setters)
- Also called **data hiding**
- Protects data from being changed accidentally by outside code
- Makes class easy to modify internally without breaking other code

**Syntax:**
```java
class Student {
    private String name;                          // hidden data
    public void setName(String n) { name = n; }   // controlled access
    public String getName() { return name; }
}
```

---

## 5. Inheritance

**What it is:** One class (child/subclass) acquires the properties and methods of another class (parent/superclass).

**Easy example:** A child inherits traits from their parent — like how a Dog inherits the ability to eat from the Animal class.

**Points to remember:**
- Uses the `extends` keyword
- Creates an **IS-A relationship** (Dog IS-A Animal)
- Promotes **code reuse** — write common code once in parent, reuse in children
- Child can add its own extra methods on top of inherited ones
- Enables method overriding → runtime polymorphism

**Syntax:**
```java
class Animal { void eat() { } }
class Dog extends Animal { void bark() { } }   // Dog inherits eat() + adds bark()
```

---

## 6. Polymorphism

**What it is:** The ability of the same method/operation to behave differently depending on the object. "Poly" = many, "morph" = forms.

**Easy example:** The word "run" means different things — an athlete runs on a track, code runs on a computer, a tap runs with water. Same word, different behavior.

**Points to remember:**
- Two types in Java:
  - **Compile-time (Method Overloading):** same method name, different parameters, in the same class
  - **Runtime (Method Overriding):** child class redefines a method inherited from parent, same signature
- One interface, multiple implementations
- Makes code flexible and extensible

**Syntax (overloading — same name, different params):**
```java
class Calc {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }   // same name, diff params
}
```

**Syntax (overriding — child redefines parent's method):**
```java
class Shape { double area() { return 0; } }
class Circle extends Shape { double area() { return 3.14 * r * r; } }  // overridden
```

---

## 7. Whitespace

**What it is:** Spaces, tabs, and newlines in code.

**Points to remember:**
- Used to separate one token from another
- Extra whitespace is ignored by the compiler
- At least one whitespace is needed between two tokens that would otherwise merge (e.g. `int x` not `intx`)
- Indentation is just for human readability — no syntactic meaning

---

## 8. Identifier

**What it is:** A name given by the programmer to a variable, method, class, etc.

**Points to remember:**
- Can contain letters (A-Z, a-z), digits (0-9), underscore `_`, dollar `$`
- Must NOT start with a digit
- Case-sensitive — `Total` and `total` are different
- Cannot be a keyword (e.g. `int`, `class`)
- No spaces or special chars like `-`, `@`, `#`

**Valid:** `AvgTemp`, `count`, `a_1`, `$salary`
**Invalid:** `2count` (starts with digit), `avg-temp` (hyphen), `class` (keyword)

---

## 9. Literal

**What it is:** A constant value written directly in the code and assigned to a variable.

**Points to remember:**
- 6 types:
  1. **Integer:** `10`, `0x1A` (hex), `0b1010` (binary)
  2. **Floating-point:** `3.14`, `2.0f`
  3. **Character:** `'A'`, `'\n'`
  4. **String:** `"Hello World"`
  5. **Boolean:** `true` or `false`
  6. **Null:** `null` (no reference)
- Integer literals default to `int` — add `L` for long
- Decimal literals default to `double` — add `f` for float

**Example:**
```java
int a = 10;          // integer literal
long l = 5000000000L; // long literal (L needed)
float f = 3.14f;      // float literal (f needed)
char c = 'A';         // character literal
String s = "Hello";   // string literal
boolean b = true;     // boolean literal
```

---

## 10. Comment

**What it is:** Text in code that is ignored by the compiler — written for humans to read.

**Points to remember:**
- 3 types:
  1. **Single-line:** `// this is a comment`
  2. **Multi-line:** `/* this is a comment */` (cannot be nested)
  3. **Documentation:** `/** ... */` — used by `javadoc` tool to generate HTML docs
- Zero effect on the compiled program — compiler skips them entirely

---

## 11. Separators

**What it is:** Special symbols used to structure Java code and separate elements.

| Symbol | Name | Use |
|---|---|---|
| `()` | Parentheses | Method calls, parameter lists, grouping |
| `{}` | Braces | Defines a block (class/method/loop body) |
| `[]` | Brackets | Array declaration and indexing |
| `;` | Semicolon | Terminates a statement |
| `,` | Comma | Separates identifiers/parameters |
| `.` | Period | Package names, accessing class/object members |

---

## 12. Keyword (Reserved Word)

**What it is:** A word reserved by Java for a predefined purpose — you cannot use it as a variable/class name.

**Points to remember:**
- Java has 50+ keywords: `class, int, if, for, while, return, new, extends, public, private`, etc.
- `const` and `goto` are reserved but NOT used in Java
- `true`, `false`, `null` are reserved literals (not keywords, but still can't be used as names)
- Keywords are always lowercase
- Using a keyword as a name (e.g. `int class = 5;`) is a compile error

---

## 13. Data Type

**What it is:** A data type defines what kind of value a variable can hold and how much memory it uses.

**Points to remember:**
- Two categories: **Primitive** (8 built-in types) and **Non-Primitive/Reference** (String, Array, Class)
- Primitives store actual value in stack; non-primitives store a reference to heap
- Primitives can't be `null`; non-primitives can
- Every primitive has a default value (for fields, not local variables)

**8 Primitive Types:**

| Type | Size | Default | What it holds |
|---|---|---|---|
| `byte` | 1 byte | 0 | -128 to 127 |
| `short` | 2 bytes | 0 | small integers |
| `int` | 4 bytes | 0 | most common integer type |
| `long` | 8 bytes | 0L | very large integers (needs `L`) |
| `float` | 4 bytes | 0.0f | decimals (needs `f`) |
| `double` | 8 bytes | 0.0 | default decimal type |
| `char` | 2 bytes | '\u0000' | single Unicode character |
| `boolean` | 1 bit | false | only true or false |

---

## 14. Type Conversion (Widening / Implicit)

**What it is:** Automatically converting a smaller data type to a larger, compatible type. Done by the compiler, no data loss.

**Easy example:** Pouring a small cup of water into a big bucket — no spillage, no problem.

**Points to remember:**
- Direction: small → large (`byte → short → int → long → float → double`, `char → int`)
- No syntax needed — happens automatically
- Safe — no data loss

**Example:**
```java
int num = 100;
double d = num;   // automatic widening, no cast needed
```

---

## 15. Type Casting (Narrowing / Explicit)

**What it is:** Manually converting a larger data type to a smaller one using the cast operator. May lose data.

**Easy example:** Pouring a big bucket of water into a small cup — some water will spill (data loss).

**Points to remember:**
- Direction: large → small (`double → int`, `long → int`, etc.)
- Requires cast operator: `(targetType) value`
- May lose data/precision — that's why programmer must do it manually
- `double → int` truncates (chops decimal), does NOT round: `(int) 199.99 = 199`

**Example:**
```java
double price = 199.99;
int rounded = (int) price;   // must cast; result is 199
```

---

## 16. Automatic Type Promotion

**What it is:** In arithmetic expressions, Java automatically promotes smaller types to larger ones so intermediate results don't overflow.

**Points to remember:**
- `byte`, `short`, `char` are ALWAYS promoted to `int` in expressions
- If one operand is `long`, whole expression becomes `long`
- If one operand is `float`, expression becomes `float`
- If one operand is `double`, expression becomes `double`
- This is why `byte a=40, b=50; byte c = a*b;` fails — `a*b` becomes `int`, needs cast back

**Example:**
```java
byte a = 10, b = 20;
int sum = a + b;           // a, b promoted to int automatically
byte c = (byte)(a + b);    // must cast back to byte explicitly
```

---

## 17. Scope of a Variable

**What it is:** The region of a program where a variable is visible and can be used.

**Points to remember:**
- A variable declared inside a block `{ }` is only visible inside that block
- Inner block can access outer block's variables
- Outer block CANNOT access inner block's variables
- Class-level fields are accessible everywhere in the class
- Local variables are accessible only within their method/block

**Example:**
```java
public class ScopeDemo {
    public static void main(String[] args) {
        int x = 10;           // visible in all of main()
        {
            int y = 20;        // visible only inside this block
            System.out.println(x);  // OK — inner can see outer
        }
        // System.out.println(y);  // ERROR — y not visible here
    }
}
```

---

## 18. Array

**What it is:** A collection of same-type elements stored in contiguous memory, accessed by a zero-based index.

**Points to remember:**
- Arrays are objects in Java, created with `new`; size is fixed
- `arrayName.length` gives the size (it's a field, not a method)
- Elements indexed from `0` to `length-1`
- 1D array = list; 2D array = table/matrix (array of arrays)
- Reference in stack, actual data in heap

**Syntax:**
```java
int[] arr = new int[5];               // 1D, declare + allocate
int[] arr = {10, 20, 30};             // 1D, declare + initialize
int[][] matrix = new int[3][3];       // 2D
int[][] matrix = {{1,2},{3,4}};       // 2D with values
```

---

## 19. Operator

**What it is:** A special symbol that performs an operation on one or more operands and produces a result.

**Points to remember — 9 categories:**
1. **Arithmetic:** `+ - * / %`
2. **Unary:** `++ -- ! -` (single operand)
3. **Relational:** `== != > < >= <=` (returns boolean)
4. **Logical/Short-circuit:** `&& || !`
5. **Assignment:** `= += -= *= /= %=`
6. **Bitwise:** `& | ^ ~` (works on individual bits)
7. **Shift:** `<< >> >>>`
8. **Ternary:** `?:` (only 3-operand operator)
9. **instanceof:** tests object type

---

## 20. Short-Circuit Operators (&& and ||)

**What it is:** `&&` (AND) and `||` (OR) skip evaluating the second operand when the first one already decides the result.

**Easy example:** If someone says "if it's raining AND I have an umbrella, I'll go out" — if it's NOT raining, you don't even need to check for the umbrella. First condition false → skip second.

**Points to remember:**
- `A && B` — if A is false, B is never evaluated (result already false)
- `A || B` — if A is true, B is never evaluated (result already true)
- `&` and `|` are non-short-circuit versions — always evaluate both sides
- Short-circuit is safer: `if (obj != null && obj.length() > 0)` avoids NullPointerException

---

## 21. Bitwise Operators

**What it is:** Operators that work directly on individual bits of integer types.

| Operator | Name | Rule |
|---|---|---|
| `&` | AND | 1 only if both bits are 1 |
| `\|` | OR | 1 if at least one bit is 1 |
| `^` | XOR | 1 if bits are different |
| `~` | Complement | Flips every bit; `~n = -(n+1)` |

**Example:** `5 & 3 = 1`, `5 | 3 = 7`, `5 ^ 3 = 6`, `~5 = -6`

---

## 22. Shift Operators (<<, >>, >>>)

**What it is:** Operators that shift bits of an integer left or right.

**Points to remember:**
- `<<` (left shift): shifts left, fills right with 0. `a << n = a × 2ⁿ`. Example: `5 << 1 = 10`
- `>>` (signed right shift): shifts right, fills left with sign bit (preserves sign). Example: `-8 >> 1 = -4`
- `>>>` (unsigned right shift): shifts right, always fills left with 0. Example: `-8 >>> 1 = 2147483644`
- `>>` and `>>>` give the same result for positive numbers; differ for negatives

---

## 23. Ternary Operator (?:)

**What it is:** Java's only 3-operand operator — a shorthand for simple if-else.

**Points to remember:**
- Evaluates condition; if true returns first value, else second
- Common use: find min/max without writing full if-else
- Can be chained for multiple conditions

**Syntax:**
```java
variable = (condition) ? valueIfTrue : valueIfFalse;
```

**Example:**
```java
int a = 15, b = 42, c = 27;
int greatest = (a > b) ? ((a > c) ? a : c) : ((b > c) ? b : c);  // 42
```

---

## 24. Operator Precedence & Associativity

**What it is:** Precedence decides which operator is evaluated first. Associativity decides order for operators of the same precedence.

**Points to remember:**
- Order (high → low): Postfix `++/--` → Unary → `* / %` → `+ -` → Shift → Relational → `== !=` → `& ^ |` → `&& ||` → Ternary → Assignment
- `10 + 5 * 2 = 20` (not 30) because `*` has higher precedence than `+`
- Parentheses `()` override everything: `(10 + 5) * 2 = 30`
- Most operators are left-to-right; Unary, Ternary, and Assignment are right-to-left

---

## 25. Control Statements

**What it is:** Statements that control the flow/order of execution in a program.

**3 categories:**
1. **Selection:** `if`, `if-else`, `if-else-if`, `switch` — choose between options
2. **Iteration:** `while`, `do-while`, `for`, `for-each` — repeat code
3. **Jump:** `break`, `continue`, `return` — alter loop flow

---

## 26. if Statement (4 Types)

**What it is:** A selection statement that runs code based on a boolean condition.

**4 types:**
1. **Simple if:** runs block only if condition is true
2. **if-else:** runs one block if true, another if false
3. **if-else-if ladder:** tests multiple conditions, first true wins
4. **Nested if:** an if inside another if — decision depends on another decision

**Syntax:**
```java
if (cond) { }                                    // simple
if (cond) { } else { }                            // if-else
if (c1) { } else if (c2) { } else { }              // ladder
if (c1) { if (c2) { } }                            // nested
```

---

## 27. switch Statement

**What it is:** A multi-way branch that tests one variable against several constant case values.

**Points to remember:**
- Works with `byte, short, int, char, String, enum`
- `case` values must be constants and unique
- `break` exits the switch — without it, execution falls through to next case
- `default` runs when no case matches (optional, can be anywhere)

**Syntax:**
```java
switch (expression) {
    case value1: statement; break;
    case value2: statement; break;
    default: statement;
}
```

---

## 28. while Loop

**What it is:** An entry-controlled loop — checks condition BEFORE running the body. May run 0 times.

**Points to remember:**
- Condition checked first — if false, body never runs
- Used when you don't know how many times to loop

**Syntax:**
```java
while (condition) { // body }
```

---

## 29. do-while Loop

**What it is:** An exit-controlled loop — checks condition AFTER running the body. Always runs at least once.

**Points to remember:**
- Body runs first, then condition checked
- Minimum 1 execution guaranteed
- Don't forget the semicolon after `while(condition);`

**Syntax:**
```java
do { // body } while (condition);   // note the semicolon!
```

---

## 30. for Loop

**What it is:** A loop that combines initialization, condition, and update in one line.

**Points to remember:**
- Any of the 3 parts can be omitted (semicolons stay): `for (; i<5; ) { }`
- Infinite loop: `for (;;) { }`
- Multiple updates: `for (int i=0, j=10; i<j; i++, j--) { }`

**Syntax:**
```java
for (init; condition; update) { // body }
```

---

## 31. for-each Loop (Enhanced for)

**What it is:** A loop that cycles through arrays/collections sequentially without using an index.

**Points to remember:**
- No index/counter needed — avoids boundary errors
- Read-only — changing the loop variable doesn't change the original array
- Can't go backwards or skip elements — use regular for loop for those

**Syntax:**
```java
for (dataType variable : array) { // body }
```

**Example (2D array):**
```java
for (int[] row : matrix) {
    for (int value : row) {
        System.out.print(value + " ");
    }
}
```

---

## 32. break Statement

**What it is:** Exits a loop or switch immediately, skipping all remaining iterations.

**Points to remember:**
- Unlabeled `break` exits only the innermost loop
- Labeled `break label;` exits an outer loop from inside a nested loop
- Also used in switch to prevent fall-through

```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) break;      // stops loop at 5
    System.out.print(i);    // prints 1 2 3 4
}
```

---

## 33. continue Statement

**What it is:** Skips the rest of the current iteration and jumps to the next iteration of the loop.

**Points to remember:**
- Does NOT exit the loop — just skips to next iteration
- Labeled `continue label;` skips to next iteration of an outer loop

```java
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) continue;   // skip even numbers
    System.out.print(i);        // prints 1 3 5 7 9
}
```

---

## 34. return Statement

**What it is:** Exits a method immediately, optionally returning a value to the caller.

**Points to remember:**
- `return;` — used in void methods (no value returned)
- `return value;` — used in non-void methods, sends value back

```java
static int square(int n) { return n * n; }  // returns the result
```

---

## 35. instanceof Operator

**What it is:** Tests whether an object is an instance of a specific class or interface. Returns a boolean.

```java
String s = "Hello";
System.out.println(s instanceof String);   // true
```

---

## 36. Lexical Issues

**What it is:** The basic rules that govern how Java source code is written before the compiler understands its meaning — how tokens (smallest meaningful units) are formed.

**6 lexical issues:**
1. **Whitespace** — spaces, tabs, newlines; separate tokens
2. **Identifiers** — names for variables/methods/classes
3. **Literals** — constant values written in code
4. **Comments** — text ignored by compiler (//, /* */, /** */)
5. **Separators** — symbols like `() {} [] ; , .` that structure code
6. **Keywords** — reserved words with predefined meaning (50+)

---

## Quick Memory Summary (for telling ma'am in one line each)

| Term | One-line definition |
|---|---|
| Paradigm | Style of organizing a program (procedural vs OOP) |
| Platform Independence | Compile once to bytecode, run on any OS with JVM |
| Abstraction | Hide internal details, show only essentials |
| Encapsulation | Bundle data + methods in a class, hide data as private |
| Inheritance | Child class acquires parent class properties (extends) |
| Polymorphism | Same method, different behavior (overloading/overriding) |
| Identifier | Name given to a variable/method/class by the programmer |
| Literal | A constant value written directly in code |
| Keyword | Reserved word with predefined meaning, can't be used as a name |
| Data Type | Defines what kind of value a variable holds and memory size |
| Type Conversion | Auto-convert smaller type to larger (no data loss) |
| Type Casting | Manually convert larger type to smaller (may lose data) |
| Type Promotion | Auto-promote byte/short/char to int in expressions |
| Scope | Region where a variable is visible/accessible |
| Array | Same-type elements in contiguous memory, zero-indexed |
| Operator | Symbol that performs an operation on operands |
| Short-circuit &&/\|\| | Skip second operand if first decides result |
| Bitwise operators | Work on individual bits (& \| ^ ~) |
| Shift operators | Move bits left/right (<< >> >>>) |
| Ternary ?: | Shorthand for if-else (3 operands) |
| Control statement | Decides order of execution (selection/iteration/jump) |
| break | Exit loop/switch immediately |
| continue | Skip current iteration, go to next |
| return | Exit method, optionally return a value |
