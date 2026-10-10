# Java Assignment 1

Subject: Java Programming | Semester III | VTU | Total Marks: 50 (5 marks each)

All programs are in the `programs/` folder. Each one was compiled and run.

---

## 1. Explain different lexical issues in Java. [5]

**Definition:** Lexical issues are the basic building blocks used to write a Java program. The compiler first breaks the program into these small parts (called tokens) before it understands the code.

There are 6 lexical elements:

1. **Whitespace**
   - Space, tab and new line.
   - Java is a free-form language, so extra spaces do not matter.
   - We need at least one space between two words like `int x`.

2. **Identifiers**
   - Names given to classes, methods and variables.
   - Can have letters, digits, `_` and `$`.
   - Cannot start with a digit.
   - Case sensitive, so `Total` and `total` are different.
   - Valid: `marks`, `_age`, `a1`. Invalid: `2marks`, `my-name`.

3. **Literals**
   - A fixed value written directly in the program.
   - Integer `100`, floating `3.14`, character `'A'`, string `"Hello"`, boolean `true`, and `null`.

4. **Comments**
   - Ignored by the compiler. Used to explain the code.
   - Single line `//`, multi line `/* */`, documentation `/** */`.

5. **Separators**
   - `;` ends a statement.
   - `,` separates variables.
   - `.` is used to access members.
   - `( )` for methods and conditions.
   - `{ }` for blocks.
   - `[ ]` for arrays.

6. **Keywords**
   - Reserved words with a fixed meaning, like `class`, `int`, `if`, `for`, `static`.
   - They cannot be used as identifier names.
   - All are in lowercase.

**Syntax:**
```java
dataType identifier = literal;
```

**Code:**
```java
int marks = 85;               // int = keyword, marks = identifier, 85 = literal
String name = "Ravi";         // "Ravi" = string literal
// this is a comment
```

---

## 2. Explain for loop in detail with examples. [5]

**Definition:** The for loop is used to repeat a block of statements a fixed number of times. It keeps initialization, condition and update together in one line.

**Syntax:**
```java
for (initialization; condition; update) { statements; }
```

**Explanation:**

1. **Initialization** runs only once at the start. Example `int i = 1`.
2. **Condition** is checked before every round. If it is true the body runs, if false the loop stops.
3. **Body** is the set of statements that get repeated.
4. **Update** runs after every round. Example `i++`.
5. Then the control goes back to the condition again.

**Code:**
```java
for (int i = 1; i <= 10; i++) {
    if (i == 5) { System.out.println("ended"); break; }
    System.out.println(i);
}
```
Output: `1 2 3 4 ended`

**Variations of the for loop:**

1. **Multiple variables** using comma.
```java
for (int i = 0, j = 5; i < j; i++, j--) { System.out.println(i + " " + j); }
```

2. **Missing parts.** Any part can be left empty, but the two `;` must stay.
```java
int i = 1;
for (; i <= 3; i++) { System.out.println(i); }
```

3. **Infinite loop** (stopped with break).
```java
for (;;) { break; }
```

4. **Nested for loop** (a loop inside a loop).
```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= i; j++) System.out.print("* ");
    System.out.println();
}
```

5. **For-each loop** (to read every element of an array).
```java
int[] a = {10, 20, 30};
for (int x : a) System.out.print(x + " ");
```

---

## 3. Explain Type Conversion and Type Casting with examples. [5]

**Definition:**
- **Type conversion** means Java changes one data type into another automatically.
- **Type casting** means the programmer changes one data type into another manually.

### Type Conversion (Widening)

1. Done automatically by the compiler.
2. Happens when a smaller type goes into a bigger type.
3. No data is lost.
4. Both types must be compatible.
5. Order: `byte -> short -> int -> long -> float -> double`.

**Syntax:**
```java
biggerType variable = smallerTypeValue;
```

**Code:**
```java
int i = 10;
double d = i;                 // d = 10.0
```

### Type Casting (Narrowing)

1. Done manually by writing the type in brackets.
2. Needed when a bigger type goes into a smaller type.
3. Data may be lost. For example the decimal part is removed (not rounded).
4. `(byte) 300` gives 44 because 300 is more than the byte range.

**Syntax:**
```java
smallerType variable = (smallerType) biggerTypeValue;
```

**Code:**
```java
double x = 9.7;
int y = (int) x;              // y = 9
```

### Automatic type promotion
In an expression, `byte`, `short` and `char` are first promoted to `int`.
```java
byte a = 50, b = 20;
int c = a * b;                // c = 1000
```

---

## 4. How to create and initialize an array? Write a Java program to implement the addition of two matrices. [5]

**Definition:** An array is a group of variables of the same data type stored under one name. Each value is accessed using an index that starts from 0.

### Creating an array (2 steps)

1. Declare the array.
2. Allocate memory using `new`.

**Syntax:**
```java
dataType[] arrayName = new dataType[size];
```

**Code:**
```java
int[] a = new int[5];         // creates array of 5 integers, default value 0
```

### Initializing an array

1. **Using index:** `a[0] = 10;`
2. **At the time of declaration:**
```java
int[] a = {10, 20, 30};
```
3. **Using a loop:**
```java
for (int i = 0; i < 3; i++) a[i] = i * 10;
```

### Two dimensional array (matrix)

**Syntax:**
```java
dataType[][] arrayName = new dataType[rows][columns];
```

**Code:**
```java
int[][] m = {{1, 2}, {3, 4}};
```

### Program: addition of two matrices

**Logic:** Add the elements which are at the same position: `c[i][j] = a[i][j] + b[i][j]`.

```java
public class MatrixAdd {
    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                c[i][j] = a[i][j] + b[i][j];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(c[i][j] + " ");
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

## 5. What are constructors? Explain types of constructors with an example program. [5]

**Definition:** A constructor is a special method that is called automatically when an object is created. It is used to give initial values to the object.

**Syntax:**
```java
ClassName(parameters) { statements; }
```

**Rules:**

1. Constructor name must be same as the class name.
2. It has no return type, not even `void`.
3. It is called automatically when we use `new`.
4. If we do not write any constructor, Java gives a default one.

### Types of constructors

1. **Default constructor**
   - Has no parameters.
   - Gives fixed values to every object.
   ```java
   Student() { id = 0; name = "unknown"; }
   ```

2. **Parameterized constructor**
   - Has parameters.
   - Gives different values to different objects.
   ```java
   Student(int i, String n) { id = i; name = n; }
   ```

3. **Copy constructor**
   - Takes an object of the same class and copies its values.
   ```java
   Student(Student s) { id = s.id; name = s.name; }
   ```

### Program

```java
class Student {
    int id;
    String name;
    Student() { id = 0; name = "unknown"; }
    Student(int i, String n) { id = i; name = n; }
    Student(Student s) { id = s.id; name = s.name; }
    void show() { System.out.println(id + " " + name); }
}
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student(101, "Ravi");
        Student s3 = new Student(s2);
        s1.show(); s2.show(); s3.show();
    }
}
```
**Output:**
```
0 unknown
101 Ravi
101 Ravi
```

---

## 6. Define recursion. Write a recursive program to find factorial of a number. [5]

**Definition:** Recursion is a process in which a method calls itself again and again until a stopping condition is reached.

**Syntax:**
```java
returnType methodName(parameters) { if (base case) return value; return methodName(smaller value); }
```

**Points:**

1. Every recursive method must have a **base case**. This is the condition that stops the calls.
2. It also has a **recursive case**, where the method calls itself with a smaller value.
3. Without a base case the calls never stop and we get `StackOverflowError`.
4. Each call is stored in the stack memory.

**Factorial:** n! = n x (n-1) x ... x 1. Also 0! = 1 and 1! = 1.

**Program:**
```java
public class Factorial {
    static int fact(int n) {
        if (n == 0 || n == 1)
            return 1;                  // base case
        return n * fact(n - 1);        // recursive call
    }
    public static void main(String[] args) {
        System.out.println("Factorial of 5 = " + fact(5));
    }
}
```
**Output:** `Factorial of 5 = 120`

**Working for fact(3):**
```
fact(3) = 3 * fact(2)
fact(2) = 2 * fact(1)
fact(1) = 1
So fact(3) = 3 * 2 * 1 = 6
```

---

## 7. Explain the various access specifiers in Java. [5]

**Definition:** Access specifiers (access modifiers) decide who can access a class, variable or method. They are used to control visibility and to protect data.

**Syntax:**
```java
accessSpecifier dataType variableName;
```

There are 4 access specifiers:

1. **public**
   - Can be accessed from anywhere, even from other packages.
   ```java
   public int a = 1;
   ```

2. **protected**
   - Can be accessed in the same package, and in subclasses of other packages.
   ```java
   protected int b = 2;
   ```

3. **default** (no keyword written)
   - Can be accessed only inside the same package.
   ```java
   int c = 3;
   ```

4. **private**
   - Can be accessed only inside the same class.
   - Used for data hiding. We give access using getter and setter methods.
   ```java
   private int d = 4;
   ```

**Table:**

| Specifier | Same class | Same package | Subclass (other package) | Other package |
|---|---|---|---|---|
| public | Yes | Yes | Yes | Yes |
| protected | Yes | Yes | Yes | No |
| default | Yes | Yes | No | No |
| private | Yes | No | No | No |

**Program:**
```java
class A {
    public int a = 1;
    protected int b = 2;
    int c = 3;
    private int d = 4;
    int getD() { return d; }       // private accessed through method
}
public class Test {
    public static void main(String[] args) {
        A obj = new A();
        System.out.println(obj.a + " " + obj.b + " " + obj.c);
        System.out.println(obj.getD());
        // obj.d gives error because d is private
    }
}
```
**Output:**
```
1 2 3
4
```

---

## 8. Explain call by value and call by reference with an example program. [5]

**Definition:**
- **Call by value:** a copy of the value is passed to the method. The change made inside the method does not change the original.
- **Call by reference:** the address (reference) of the object is passed. The change made inside the method changes the original object.

**Syntax:**
```java
methodName(variable);       // call by value (primitive)
methodName(arrayOrObject);  // call by reference (array or object)
```

**Points:**

1. Java always passes a copy. For primitives (`int`, `float`...) the copy is the value, so the original is safe.
2. For arrays and objects the copy is the reference (address), so both point to the same object.
3. So changing the data inside the object changes the original.
4. Primitive types are call by value. Arrays and objects work like call by reference.

**Program:**
```java
public class Test {
    static void change(int x) { x = 100; }              // call by value
    static void change(int[] arr) { arr[0] = 100; }     // call by reference

    public static void main(String[] args) {
        int n = 10;
        change(n);
        System.out.println(n);          // 10, not changed

        int[] a = {10, 20};
        change(a);
        System.out.println(a[0]);       // 100, changed
    }
}
```
**Output:**
```
10
100
```

---

## 9. Explain the use of `this` in Java with an example. [5]

**Definition:** `this` is a keyword that refers to the current object, which is the object that is calling the method or constructor.

**Syntax:**
```java
this.variableName;      this.methodName();      this(arguments);
```

**Uses of `this`:**

1. **To separate instance variable from parameter** when both have the same name.
```java
Student(int id, String name) { this.id = id; this.name = name; }
```

2. **To call another constructor** of the same class. It must be the first statement.
```java
Student() { this(0, "unknown"); }
```

3. **To call a method** of the current object.
```java
this.show();
```

4. **To return the current object.**
```java
Student getObject() { return this; }
```

**Program:**
```java
class Student {
    int id;
    String name;
    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    Student() { this(0, "unknown"); }
    Student getObject() { return this; }
    void show() { System.out.println(this.id + " " + this.name); }
}
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student(101, "Ravi");
        Student s2 = new Student();
        s1.getObject().show();
        s2.show();
    }
}
```
**Output:**
```
101 Ravi
0 unknown
```

Without `this`, the line `id = id;` would only assign the parameter to itself and the instance variable would stay 0.

---

## 10. Explain the method overriding with a suitable example. [5]

**Definition:** Method overriding is when a subclass writes its own version of a method that is already present in its superclass, with the same name, same parameters and same return type.

**Syntax:**
```java
class SubClass extends SuperClass { @Override returnType methodName(parameters) { statements; } }
```

**Rules and points:**

1. Inheritance is needed (`extends`).
2. Method name and parameters must be exactly same as in the superclass.
3. The subclass method cannot have weaker access. A `public` method cannot be made `private`.
4. `final`, `static` and `private` methods cannot be overridden.
5. `@Override` is optional but good, because the compiler shows an error if we make a mistake.
6. The method to run is decided at run time based on the actual object. This is called **run-time polymorphism** (dynamic method dispatch).
7. `super.methodName()` can be used to call the superclass version.

**Program:**
```java
class Animal {
    void sound() { System.out.println("Animal makes a sound"); }
}
class Dog extends Animal {
    @Override
    void sound() { System.out.println("Dog barks"); }
}
class Cat extends Animal {
    @Override
    void sound() { System.out.println("Cat meows"); }
}
public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();     // superclass reference, subclass object
        a.sound();
        a = new Cat();
        a.sound();
    }
}
```
**Output:**
```
Dog barks
Cat meows
```

**Overloading vs overriding:** overloading is same name with different parameters in the same class (compile time). Overriding is same name and same parameters in a subclass (run time).
