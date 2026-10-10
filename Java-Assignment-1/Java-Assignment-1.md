# Java Assignment 1

Subject: Java Programming (BCS306A) | Semester III | VTU

Every program is in the `programs/` folder (one folder per question). Each one was compiled and run, and the output shown is the real output.

---

## 1. Explain different lexical issues in Java.

**Definition:** Lexical issues are the basic building blocks used to write a Java program. Before understanding the meaning, the compiler first breaks the program into these small parts, called tokens. A Java program is made of whitespace, identifiers, literals, comments, separators and keywords.

**Syntax:**
```java
dataType identifier = literal;
```

### 1. Whitespace

1. Whitespace means space, tab, new line and form feed.
2. Java is a free-form language, so we need not follow any special indentation.
3. Extra spaces and blank lines are ignored by the compiler.
4. At least one whitespace is needed between two words like `int x`, otherwise `intx` becomes one name.

**Example:**
```java
int      studentAge   =   20;      // same as: int studentAge = 20;
```

### 2. Identifiers

1. Identifiers are the names given to classes, methods and variables.
2. They can contain letters, digits, underscore `_` and dollar `$`.
3. They must not start with a digit.
4. They are case sensitive, so `Total` and `total` are different.
5. A keyword cannot be used as an identifier.
6. Valid: `marks1`, `_count`, `$total`. Invalid: `2marks`, `my-name`, `int`.

**Syntax:**
```java
dataType identifierName;
```

**Example:**
```java
int _count = 5, $total = 10, marks1 = 85;     // valid identifiers
// int 2marks = 3;                            // error: starts with a digit
```

### 3. Literals

1. A literal is a fixed value written directly in the program.
2. Types: integer, floating-point, character, string, boolean and null.

| Type | Example |
|---|---|
| Integer | `100`, `0x1F` (hex), `0b101` (binary), `1_000_000` |
| Floating-point | `3.14`, `2.5f` |
| Character | `'A'` |
| String | `"Ravi"` |
| Boolean | `true`, `false` |
| Null | `null` |

**Example:**
```java
double pi = 3.14;
char grade = 'A';
String name = "Ravi";
boolean pass = true;
int hex = 0x1F, bin = 0b101, big = 1_000_000;
String nothing = null;
```

### 4. Comments

1. Comments are ignored by the compiler. They are used to explain the code.
2. Three types: single line `//`, multi line `/* */` and documentation `/** */`.

**Syntax:**
```java
// single line comment
/* multi line comment */
/** documentation comment */
```

**Example:**
```java
// this is a single line comment
/* this comment
   goes to two lines */
/** Main method of the program */
```

### 5. Separators

1. Separators are symbols that separate or group the code.

| Symbol | Name | Use |
|---|---|---|
| `;` | Semicolon | ends a statement |
| `,` | Comma | separates variables |
| `.` | Period | access a member (`System.out`) |
| `( )` | Parentheses | method calls and conditions |
| `{ }` | Braces | block of code, array values |
| `[ ]` | Brackets | arrays |

**Example:**
```java
int[] arr = {1, 2, 3};                 // [ ] { } , ;
System.out.println(arr[0]);            // . ( ) [ ] ;
```

### 6. Keywords

1. Keywords are reserved words that have a fixed meaning in Java.
2. They cannot be used as identifier names.
3. All keywords are in lowercase. Java has 50 keywords, for example `class`, `public`, `static`, `int`, `if`, `for`, `new`, `return`.
4. `true`, `false` and `null` are also reserved and cannot be used as names.

**Example:**
```java
public class LexicalDemo { }       // public, class are keywords; LexicalDemo is an identifier
```

### Program (all six together)
```java
public class LexicalDemo {                 // keywords: public, class | identifier: LexicalDemo
    /* multi-line comment */
    public static void main(String[] args) {
        int      studentAge   =   20;       // whitespace
        int _count = 5, $total = 10, marks1 = 85;   // identifiers
        double pi = 3.14;                   // literals
        char grade = 'A';
        String name = "Ravi";
        boolean pass = true;
        int hex = 0x1F, bin = 0b101, big = 1_000_000;
        String nothing = null;
        int[] arr = {1, 2, 3};              // separators
        System.out.println(name + " " + studentAge + " " + grade + " " + pi + " " + pass);
        System.out.println(_count + " " + $total + " " + marks1);
        System.out.println(hex + " " + bin + " " + big + " " + nothing + " " + arr[0]);
    }
}
```
**Output:**
```
Ravi 20 A 3.14 true
5 10 85
31 5 1000000 null 1
```

---

## 2. Explain for loop in detail with examples.

**Definition:** The for loop is used to repeat a block of statements a fixed number of times. It keeps the initialization, condition and update together in one line, so it is the best loop when we know how many times to repeat.

**Syntax:**
```java
for (initialization; condition; update) { statements; }
```

### Working of the for loop

1. **Initialization** runs only once, at the start. Example `int i = 1`.
2. **Condition** is checked before every round. If true, the body runs. If false, the loop ends.
3. **Body** is the set of statements that get repeated.
4. **Update** runs after every round. Example `i++`.
5. Then control goes back to the condition (step 2).
6. A variable declared in the initialization is local to the loop, so it cannot be used outside.

**Example:**
```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) { System.out.println("ended"); break; }
    System.out.println(i);
}
```
Output: `1 2 3 4 ended`

### Variations of the for loop

#### 1. Multiple variables (comma)
Two or more variables can be used in the initialization and the update, separated by commas.
```java
for (int i = 0, j = 5; i < j; i++, j--) System.out.print("(" + i + "," + j + ") ");
```
Output: `(0,5) (1,4) (2,3)`

#### 2. Missing initialization
The variable is declared before the loop. The first `;` must stay.
```java
int k = 1;
for (; k <= 3; k++) System.out.print(k + " ");
```
Output: `1 2 3`

#### 3. Missing update
The update is done inside the body.
```java
for (int m = 1; m <= 3; ) { System.out.print(m + " "); m++; }
```
Output: `1 2 3`

#### 4. Infinite loop
No condition means the loop never stops by itself. We stop it with `break`.
```java
int n = 0;
for (;;) { if (++n > 3) break; System.out.print(n + " "); }
```
Output: `1 2 3`

#### 5. Empty body
The work is done inside the update part and the body is just a `;`.
```java
int sum = 0;
for (int i = 1; i <= 5; sum += i++) ;
System.out.println("sum = " + sum);
```
Output: `sum = 15`

#### 6. Nested for loop
A for loop inside another for loop. The inner loop completes fully for each round of the outer loop.
```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= i; j++) System.out.print("* ");
    System.out.println();
}
```
Output:
```
*
* *
* * *
```

#### 7. For-each loop
Used to read every element of an array without using an index.
```java
for (dataType variable : arrayName) { statements; }
```
```java
int[] a = {10, 20, 30};
for (int x : a) System.out.print(x + " ");
```
Output: `10 20 30`

### Full program
Program: `programs/Q2/ForLoopDemo.java` contains all the above variations together. Compiled and run, the output is exactly as shown.

---

## 3. Explain Type Conversion and Type Casting with examples.

**Definition:**
- **Type conversion:** the compiler changes one data type to another automatically.
- **Type casting:** the programmer changes one data type to another manually using brackets.

**Syntax:**
```java
biggerType variable = smallerTypeValue;            // conversion (automatic)
smallerType variable = (smallerType) biggerValue;  // casting (manual)
```

### A. Type Conversion (Widening, automatic)

1. Done by the compiler without any extra code.
2. It happens only when both conditions are true: the two types are compatible, and the destination type is bigger than the source type.
3. No data is lost.
4. The order is: `byte -> short -> int -> long -> float -> double`. Also `char -> int`.
5. Number types are not compatible with `boolean`.

**Example:**
```java
int i = 100;
long l = i;           // int to long
float f = l;          // long to float
double d = f;         // float to double
System.out.println(i + " " + l + " " + f + " " + d);
```
Output: `100 100 100.0 100.0`

### B. Type Casting (Narrowing, manual)

1. Needed when a bigger type is put into a smaller type.
2. The target type is written in brackets before the value.
3. Data may be lost.
4. For `double` to `int`, the decimal part is cut off (truncated, not rounded). `(int) 9.99` gives `9`.
5. When a value is too big for the target type, it is reduced by the range of that type. `(byte) 300` gives `44` because 300 - 256 = 44.
6. `char` and `int` can be cast to each other.

**Example:**
```java
double x = 9.99;
int y = (int) x;               // 9
int big = 300;
byte b = (byte) big;           // 44
char c = 'A';
int code = c;                  // 65
char next = (char) (c + 1);    // 'B'
```
Output: `9.99 -> 9`, `300 -> 44`, `A 65 B`

### C. Automatic type promotion in expressions

1. In an expression, `byte`, `short` and `char` are first promoted to `int`.
2. If any one operand is `long`, `float` or `double`, the whole expression is promoted to that type.
3. So `byte * byte` gives an `int`.

**Example:**
```java
byte p = 50, q = 20;
int r = p * q;                 // 1000, would not fit in a byte
System.out.println(7 / 2);             // 3 (int division)
System.out.println((double) 7 / 2);    // 3.5
```

### Difference

| Type Conversion | Type Casting |
|---|---|
| Done automatically by compiler | Done manually by programmer |
| Smaller to bigger type | Bigger to smaller type |
| No data loss | Data may be lost |
| No brackets needed | Needs `(type)` |

---

## 4. How to create and initialize an Array? Write a Java program to implement the addition of two matrices.

**Definition:** An array is a group of variables of the same data type stored under one name. Each element is accessed with an index, and the index starts from 0.

**Syntax:**
```java
dataType[] arrayName = new dataType[size];
```

### Creating an array (two steps)

1. **Declare** the array variable: `int[] a;`
2. **Allocate memory** using `new`: `a = new int[5];`
3. Both can be written in one line: `int[] a = new int[5];`
4. The default value is 0 for numbers, `false` for boolean and `null` for objects.
5. The size of an array is found using `a.length`.

### Initializing an array

**1. Using index**
```java
int[] a = new int[5];
a[0] = 10;
```

**2. At the time of declaration**
```java
int[] b = {10, 20, 30};
```

**3. Using a loop**
```java
int[] c = new int[3];
for (int i = 0; i < 3; i++) c[i] = i * 10;
```

Output for `a[0]`, `a[1]`, `b[2]`, `c[2]`, `b.length` is `10 0 | 30 | 20 | length = 3`.

### Two dimensional array

**Syntax:**
```java
dataType[][] arrayName = new dataType[rows][columns];
```
```java
int[][] m = {{1, 2}, {3, 4}};      // 2 rows, 2 columns
```
`m[0][1]` is the element in row 0 and column 1, which is `2`.

### Program: addition of two matrices

**Logic:** Add the elements at the same position: `sum[i][j] = m1[i][j] + m2[i][j]`. Matrices must have the same number of rows and columns.

```java
public class MatrixAdd {
    public static void main(String[] args) {
        int[][] m1 = {{1, 2}, {3, 4}};
        int[][] m2 = {{5, 6}, {7, 8}};
        int[][] sum = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                sum[i][j] = m1[i][j] + m2[i][j];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) System.out.print(sum[i][j] + " ");
            System.out.println();
        }
    }
}
```
**Output:**
```
6 8
10 12
```

---

## 5. What are constructors? Explain types of constructors with an example program.

**Definition:** A constructor is a special method that initializes an object immediately when it is created. It is called automatically when we use the `new` keyword.

**Syntax:**
```java
ClassName(parameters) { statements; }
```

### Rules of a constructor

1. The constructor name must be the same as the class name.
2. It has no return type, not even `void`. The implicit return type is the class type itself.
3. It is called automatically at the time of object creation.
4. If we do not write any constructor, Java supplies a default one. It sets all instance variables to zero (or `null` / `false`).
5. Once we write our own constructor, the default constructor is no longer supplied.
6. Constructors can be overloaded, which means one class can have many constructors with different parameters.

### Types of constructors

#### 1. Default constructor (no parameters)
Gives the same fixed values to every object.
```java
Box() { width = height = depth = -1; }
```

#### 2. Parameterized constructor
Takes parameters, so different objects can get different values.
```java
Box(double w, double h, double d) { width = w; height = h; depth = d; }
```
Also, `Box(double len)` is a parameterized constructor used to make a cube.

#### 3. Copy constructor
Takes an object of the same class as a parameter and copies its values into the new object.
```java
Box(Box ob) { width = ob.width; height = ob.height; depth = ob.depth; }
```

### Constructor vs Method

| Constructor | Method |
|---|---|
| Initializes a new object | Does operations on an existing object |
| Name same as class name | Name can be anything |
| No return type | Must have a return type |
| Called automatically by `new` | Called by the programmer |
| Cannot be inherited | Can be inherited |

### Program
```java
class Box {
    double width, height, depth;
    Box() { width = height = depth = -1; }                       // default
    Box(double len) { width = height = depth = len; }            // cube
    Box(double w, double h, double d) { width = w; height = h; depth = d; }   // parameterized
    Box(Box ob) { width = ob.width; height = ob.height; depth = ob.depth; }   // copy
    double volume() { return width * height * depth; }
}
public class ConstructorDemo {
    public static void main(String[] args) {
        Box b1 = new Box(10, 20, 15);
        Box b2 = new Box();
        Box cube = new Box(7);
        Box clone = new Box(b1);
        System.out.println("Volume of b1 is " + b1.volume());
        System.out.println("Volume of b2 is " + b2.volume());
        System.out.println("Volume of cube is " + cube.volume());
        System.out.println("Volume of clone is " + clone.volume());
    }
}
```
**Output:**
```
Volume of b1 is 3000.0
Volume of b2 is -1.0
Volume of cube is 343.0
Volume of clone is 3000.0
```
The constructor to run is chosen by the arguments given in `new`.

---

## 6. Define recursion. Write a recursive program to find factorial of a number.

**Definition:** Recursion is the process of defining something in terms of itself. In Java, it is the feature that allows a method to call itself. A method that calls itself is called a recursive method.

**Syntax:**
```java
returnType methodName(parameters) { if (base condition) return value; return methodName(smaller value); }
```

### Points

1. A recursive method must have a **base case**. This is the condition that stops the calls.
2. It also has a **recursive case**, where the method calls itself with a smaller value.
3. If the base case is missing, the method never returns and we get `StackOverflowError`.
4. Every call gets its own new local variables and parameters on the stack. When the calls return, they are removed.
5. Recursion makes the code of some problems (factorial, Fibonacci, tree traversal) clearer and simpler than loops.
6. The disadvantage is that it uses more memory because of the stack.

### Factorial

The factorial of N is the product of all numbers from 1 to N. Example: 3! = 1 x 2 x 3 = 6.

```java
int fact(int n) {
    if (n == 1) return 1;          // base case
    return fact(n - 1) * n;        // recursive call
}
```

### Working of fact(3)
```
fact(3) = fact(2) * 3
fact(2) = fact(1) * 2
fact(1) = 1                  <- base case, calls start returning
fact(2) = 1 * 2 = 2
fact(3) = 2 * 3 = 6
```

### Program
```java
class Factorial {
    int fact(int n) {
        if (n == 1) return 1;
        return fact(n - 1) * n;
    }
}
public class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();
        System.out.println("Factorial of 3 is " + f.fact(3));
        System.out.println("Factorial of 4 is " + f.fact(4));
        System.out.println("Factorial of 5 is " + f.fact(5));
    }
}
```
**Output:**
```
Factorial of 3 is 6
Factorial of 4 is 24
Factorial of 5 is 120
```

### One more example: printing an array recursively
```java
void printArray(int i) {
    if (i == 0) return;                      // base case
    printArray(i - 1);                       // recursive call
    System.out.println("[" + (i - 1) + "] " + values[i - 1]);
}
```
Calling `printArray(5)` prints `[0] 0`, `[1] 1`, `[2] 2`, `[3] 3`, `[4] 4`.

---

## 7. Explain the various access specifiers in Java.

**Definition:** Access specifiers (access modifiers) decide which code can access a class member (variable or method). By allowing access only through a well-defined set of methods, we can prevent misuse of the data. This is called data hiding (encapsulation).

**Syntax:**
```java
accessSpecifier dataType variableName;
accessSpecifier returnType methodName(parameters) { }
```

Java has four access levels: `public`, `protected`, default (no keyword) and `private`.

### 1. public
1. Can be accessed by any other code, from anywhere.
2. `main()` is always `public` because it is called by the Java run-time system, which is outside the program.
```java
public int a;
```

### 2. protected
1. Can be accessed in the same package, and also by subclasses in other packages.
2. It matters only when inheritance is involved.
```java
protected int b;
```

### 3. default (no keyword)
1. When no specifier is written, the member is public within its own package, but cannot be accessed outside the package.
```java
int c;
```

### 4. private
1. Can be accessed only by the other members of its own class.
2. Outside code must use public methods (getter and setter).
```java
private int d;
```

### Table

| Specifier | Same class | Same package | Subclass (other package) | Other package |
|---|---|---|---|---|
| public | Yes | Yes | Yes | Yes |
| protected | Yes | Yes | Yes | No |
| default | Yes | Yes | No | No |
| private | Yes | No | No | No |

### Program
```java
class Test {
    public int a;          // public
    protected int b;       // protected
    int c;                 // default
    private int d;         // private
    void setd(int i) { d = i; }
    int getd() { return d; }
}
public class AccessTest {
    public static void main(String[] args) {
        Test ob = new Test();
        ob.a = 10;
        ob.b = 20;
        ob.c = 30;
        // ob.d = 100;     // error: d has private access in Test
        ob.setd(100);      // OK, through the method
        System.out.println("a, b, c and d: " + ob.a + " " + ob.b + " " + ob.c + " " + ob.getd());
    }
}
```
**Output:**
```
a, b, c and d: 10 20 30 100
```
If we remove the `//` before `ob.d = 100;`, the program will not compile because of the access violation.

---

## 8. Explain call by value and call by reference with an example program.

**Definition:**
- **Call by value:** the value of the argument is copied into the formal parameter. Changes made to the parameter do not affect the original argument.
- **Call by reference:** a reference to the argument is passed. Changes made to the parameter affect the original argument.

**Syntax:**
```java
methodName(primitiveVariable);     // call by value
methodName(objectName);            // call by reference (object)
```

### Points

1. Java uses both approaches, depending on what is passed.
2. When a **primitive type** (`int`, `float`, `char`...) is passed, it is passed by value. The method gets a copy, so the original is safe.
3. When an **object** is passed, the effect is call by reference. The parameter and the argument refer to the same object, so the changes made inside the method do change the original object.
4. Strictly, the reference itself is passed by value, but since the copy points to the same object, the object is changed.

### A. Call by value (primitive types)
```java
class Value {
    void meth(int i, int j) { i *= 2; j /= 2; }
}
```
```java
int a = 15, b = 20;
v.meth(a, b);
```
Output:
```
a and b before call: 15 20
a and b after call: 15 20
```
The operations inside `meth()` had no effect on `a` and `b`.

### B. Call by reference (objects)
```java
class Ref {
    int a, b;
    Ref(int i, int j) { a = i; b = j; }
    void meth(Ref o) { o.a *= 2; o.b /= 2; }
}
```
```java
Ref ob = new Ref(15, 20);
ob.meth(ob);
```
Output:
```
ob.a and ob.b before call: 15 20
ob.a and ob.b after call: 30 10
```
The object itself changed.

### Full program
```java
class Value {
    void meth(int i, int j) { i *= 2; j /= 2; }
}
class Ref {
    int a, b;
    Ref(int i, int j) { a = i; b = j; }
    void meth(Ref o) { o.a *= 2; o.b /= 2; }
}
public class CallByValueRef {
    public static void main(String[] args) {
        Value v = new Value();
        int a = 15, b = 20;
        System.out.println("a and b before call: " + a + " " + b);
        v.meth(a, b);
        System.out.println("a and b after call: " + a + " " + b);

        Ref ob = new Ref(15, 20);
        System.out.println("ob.a and ob.b before call: " + ob.a + " " + ob.b);
        ob.meth(ob);
        System.out.println("ob.a and ob.b after call: " + ob.a + " " + ob.b);
    }
}
```

### Difference

| Call by value | Call by reference |
|---|---|
| Copy of the value is passed | Reference of the object is passed |
| Original is not changed | Original is changed |
| Used for primitive types | Used for objects and arrays |

---

## 9. Explain the use of `this` in Java with an example.

**Definition:** `this` is a keyword that refers to the current object, which is the object on which the method or constructor was invoked. It can be used inside any method wherever a reference to an object of the current class type is allowed.

**Syntax:**
```java
this.variableName;      this.methodName();      this(arguments);
```

### Uses of `this`

#### 1. To remove the confusion between instance variables and local variables (instance variable hiding)
1. In Java, a local variable or a parameter can have the same name as an instance variable. Then the local variable hides the instance variable.
2. `this.variableName` refers to the instance variable, and the plain name refers to the parameter.
```java
Box(double width, double height, double depth) {
    this.width = width;        // this.width = instance variable, width = parameter
    this.height = height;
    this.depth = depth;
}
```
Without `this`, the line `width = width;` would only assign the parameter to itself and the instance variable would stay 0.

#### 2. To call another constructor of the same class
It must be the first statement in the constructor.
```java
Box() { this(1, 1, 1); }
```

#### 3. To return the current object
```java
Box getBox() { return this; }
```

#### 4. To access the members of the current object
```java
double volume() { return this.width * this.height * this.depth; }
```
This use is redundant but perfectly correct. Inside the method, `this` always refers to the invoking object.

### Program
```java
class Box {
    double width, height, depth;
    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    Box() { this(1, 1, 1); }
    Box getBox() { return this; }
    double volume() { return this.width * this.height * this.depth; }
}
public class ThisDemo {
    public static void main(String[] args) {
        Box b1 = new Box(10, 20, 15);
        Box b2 = new Box();
        System.out.println(b1.volume());
        System.out.println(b2.volume());
        System.out.println(b1.getBox() == b1);
    }
}
```
**Output:**
```
3000.0
1.0
true
```

---

## 10. Explain the method overriding with a suitable example.

**Definition:** When a method in a subclass has the same name, same parameters and same return type as a method in its superclass, the subclass method is said to override the superclass method. When it is called through a subclass object, the subclass version is always executed and the superclass version is hidden.

**Syntax:**
```java
class SubClass extends SuperClass { @Override returnType methodName(parameters) { statements; } }
```

### Points

1. Overriding needs inheritance (`extends`).
2. The method name, parameter list and return type must be exactly the same.
3. The subclass method cannot have weaker access. A `public` method cannot be made `private`.
4. `final`, `static` and `private` methods cannot be overridden.
5. `@Override` is optional, but it is good practice. The compiler gives an error if we make a mistake in the method name or parameters.
6. `super.methodName()` can be used to call the superclass version from the subclass.
7. A method which is not overridden still runs from the superclass.

### Dynamic method dispatch (run-time polymorphism)

1. A superclass reference variable can refer to a subclass object.
2. When an overridden method is called through that reference, Java decides which version to run **at run time**, based on the type of the object, not the type of the reference.
3. This is called dynamic method dispatch, and it is how Java implements run-time polymorphism.

### Program
```java
class Animal {
    void sound() { System.out.println("Animal makes a sound"); }
    void eat() { System.out.println("Animal eats"); }
}
class Dog extends Animal {
    @Override
    void sound() {
        super.sound();                         // calls the superclass version
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    @Override
    void sound() { System.out.println("Cat meows"); }
}
public class OverridingDemo {
    public static void main(String[] args) {
        Animal a = new Animal();
        a.sound();
        a = new Dog();             // superclass reference, subclass object
        a.sound();
        a = new Cat();
        a.sound();
        a.eat();                   // not overridden, so superclass version runs
    }
}
```
**Output:**
```
Animal makes a sound
Animal makes a sound
Dog barks
Cat meows
Animal eats
```

### Overloading vs Overriding

| Overloading | Overriding |
|---|---|
| Same name, different parameters | Same name, same parameters |
| Within the same class | Between superclass and subclass |
| Decided at compile time | Decided at run time |
| Return type alone cannot differ | Return type must be same |
