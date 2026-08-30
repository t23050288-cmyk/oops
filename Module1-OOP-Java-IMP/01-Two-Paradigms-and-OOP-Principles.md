# 1. Programming Paradigms, Java Features & OOP Principles

Covers: differentiating paradigms, features of Java / OOP, "compile once run anywhere",
Abstraction, Encapsulation, Inheritance, Polymorphism.

---

## 1.1 The Two Programming Paradigms

**Definition:** A paradigm is the fundamental style/approach used to organize a
program. Java is built on the **Object-Oriented paradigm**, which was created to fix
problems in the older **Procedural (process-oriented) paradigm**.

**Points:**
1. Every program is just **code** (logic) + **data** (values it works on). The paradigm
   question is: which one should the program be organized around?
2. **Procedural paradigm** (C, Pascal) organizes the program around **code** — a
   sequence of instructions/functions that act on data.
3. In procedural style, data is passive — it's passed around freely to functions, and
   functions manipulate it directly.
4. **Object-Oriented paradigm** (Java, C++) organizes the program around **data**,
   wrapped as **objects** — each object owns its data and exposes methods to work on it.
5. In OOP, data controls access to code — outside code must go *through* an object's
   interface (methods) to touch its data, not access it directly.
6. Procedural works fine for small programs, but breaks down as programs grow — shared
   data gets modified from everywhere, making bugs hard to trace.
7. OOP fixes this via **encapsulation** (bundling data+methods, hiding internals),
   making large programs easier to maintain and extend.
8. Procedural = "what is happening" (action-centric). OOP = "who is affected"
   (data/object-centric).

**Comparison Table:**

| Basis | Procedural | Object-Oriented |
|---|---|---|
| Organized around | Code/functions | Data/objects |
| Data | Passive, freely shared | Encapsulated, protected |
| Reusability | Low (copy-paste functions) | High (inheritance) |
| Example languages | C | Java, C++ |
| Best for | Small programs | Large, complex programs |

**Smallest program (shows OOP style — data wrapped in a class):**
```java
class Paradigm {
    int data = 10;                       // data owned by the object
    void show() { System.out.println(data); }   // access through a method
    public static void main(String[] a) { new Paradigm().show(); }
}
```

---

## 1.2 Features of Java / "Compile Once, Run Anywhere"

**Definition:** "Compile once, run anywhere" (platform independence) means Java source
code compiles to an intermediate form (**bytecode**) that runs unmodified on any
device with a **JVM (Java Virtual Machine)**, regardless of the underlying OS/hardware.

**Points (also answers "List features of Java"):**
1. **Simple** — syntax based on C/C++ but removes complex features like pointers and
   multiple inheritance of classes.
2. **Object-Oriented** — everything (except primitives) is built around objects/classes.
3. **Platform Independent** — `.java` → compiled by `javac` into `.class` **bytecode**,
   not native machine code.
4. **Bytecode + JVM** — every platform (Windows/Linux/Mac) has its own JVM that
   interprets/JIT-compiles the *same* bytecode into that platform's native instructions.
5. So you compile **once** on any machine, and that single `.class` file **runs
   anywhere** a JVM exists — you never recompile for each OS. This justifies the slogan.
6. **Robust** — strong type checking at compile time, automatic garbage collection,
   exception handling — reduces crashes.
7. **Secure** — bytecode is verified before execution; no direct pointer/memory access.
8. **Multithreaded** — built-in support for running multiple tasks concurrently.
9. **Architecture-neutral & portable** — no implementation-dependent aspects (e.g. `int`
   is always 4 bytes, unlike C where it varies).
10. **High Performance** — via Just-In-Time (JIT) compilation of bytecode.

**Flow:**
```
MyProg.java --(javac)--> MyProg.class (bytecode) --(JVM on any OS)--> Output
```

**Smallest program (the bytecode it produces is identical no matter what OS you run javac on):**
```java
class Hi { public static void main(String[] a){ System.out.println("Runs anywhere"); } }
```

---

## 1.3 Abstraction

**Definition:** Abstraction is hiding unnecessary implementation details and exposing
only the essential features of an object to the outside world.

**Points:**
1. Lets a programmer focus on **what** an object does, not **how** it does it.
2. Manages complexity in large systems by hiding internal detail.
3. Shows only essential functionality to the user of the class.
4. Makes programs easier to understand and use correctly.
5. Allows internal implementation to change later without breaking code that uses it.
6. **Hierarchical abstraction**: a complex object is one entity at a high level, but a
   collection of smaller subsystems at lower levels (e.g. a Car = Engine + Wheels + ...).
7. In Java, abstraction is achieved using **abstract classes** and **interfaces**.

**Syntax (interface = pure abstraction):**
```java
interface Shape {
    double area();          // only WHAT, not HOW
}
```

---

## 1.4 Three OOP Principles: Encapsulation, Inheritance, Polymorphism

### Encapsulation

**Definition:** Binding data and the methods that operate on it into a single unit
(a `class`), and protecting that data from outside/unauthorized access.

**Points:**
1. The `class` is Java's basic mechanism for encapsulation.
2. Combines data (fields) + behavior (methods) into one unit.
3. Controls access using access modifiers (`private`, `public`) — data is usually kept
   `private`, accessed only via `public` getter/setter methods.
4. Provides a well-defined interface for the outside world to interact with the object.
5. Hides internal complexity — the user doesn't need to know how a method works.
6. Makes the class easy to modify internally without breaking external code.
7. Also called **data hiding**.

**Syntax:**
```java
class ClassName {
    private dataType field;              // hidden data
    public returnType getField() { ... }  // controlled access
    public void setField(dataType v) { ... }
}
```

**Easiest Program:**
```java
class Student {
    private String name;      // encapsulated (hidden) data
    private int marks;

    public void setDetails(String n, int m) { name = n; marks = m; }
    public void display() { System.out.println(name + " scored " + marks); }
}
public class EncapsulationDemo {
    public static void main(String[] args) {
        Student s = new Student();
        s.setDetails("Prahlad", 90);
        s.display();
    }
}
```

**Smallest Program:**
```java
class Box { private int size = 5; int getSize(){ return size; } }
public class Main { public static void main(String[] a){ System.out.println(new Box().getSize()); } }
```

### Inheritance

**Definition:** The mechanism by which one class (**subclass/child**) acquires the
properties and behavior of another class (**superclass/parent**).

**Points:**
1. Promotes **code reusability** — common code is written once in the superclass.
2. Uses the `extends` keyword in Java.
3. Establishes an **IS-A relationship** (e.g. Dog IS-A Animal).
4. A subclass can add its own extra fields/methods on top of what it inherits.
5. Supports **hierarchical classification** (Animal → Mammal → Dog).
6. Avoids repeating common characteristics in every class.
7. Enables **method overriding**, which supports runtime polymorphism.
8. Java supports single, multilevel, and hierarchical inheritance (not multiple
   inheritance of classes — only via interfaces).

**Syntax:**
```java
class Superclass { ... }
class Subclass extends Superclass { ... }
```

**Easiest Program:**
```java
class Animal {
    void eat() { System.out.println("This animal eats food"); }
}
class Dog extends Animal {      // Dog inherits eat() from Animal
    void bark() { System.out.println("Dog barks"); }
}
public class InheritanceDemo {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();     // inherited
        d.bark();    // own method
    }
}
```

**Smallest Program:**
```java
class A { void hi(){ System.out.println("hi"); } }
class B extends A {}
public class Main { public static void main(String[] a){ new B().hi(); } }
```

### Polymorphism

**Definition:** The ability of the same interface/operation to exhibit different
behaviors depending on the object or situation ("many forms").

**Points:**
1. One interface, multiple implementations/behaviors.
2. Two types in Java: **compile-time (method overloading)** and **runtime (method
   overriding)**.
3. **Overloading**: same method name, different parameter list, in the same class.
4. **Overriding**: subclass redefines a method already defined in its superclass, with
   the same signature — resolved at runtime.
5. Reduces complexity by letting different objects be treated through one common
   interface (e.g. all `Shape` objects have `.area()` but compute it differently).
6. Increases flexibility and extensibility of code.
7. Achieved via inheritance + method overriding in Java.

**Syntax (overriding):**
```java
class Parent { void show(){ ... } }
class Child extends Parent { @Override void show(){ ... } }  // same signature
```

**Easiest Program:**
```java
class Shape {
    double area() { return 0; }
}
class Circle extends Shape {
    double r;
    Circle(double r) { this.r = r; }
    double area() { return 3.14 * r * r; }     // overridden — different behavior
}
class Square extends Shape {
    double s;
    Square(double s) { this.s = s; }
    double area() { return s * s; }            // overridden — different behavior
}
public class PolymorphismDemo {
    public static void main(String[] args) {
        Shape sh1 = new Circle(3);
        Shape sh2 = new Square(4);
        System.out.println("Circle area: " + sh1.area());
        System.out.println("Square area: " + sh2.area());
    }
}
```

**Smallest Program (overloading — simplest form of polymorphism):**
```java
class Calc {
    int add(int a, int b) { return a + b; }
    double add(double a, double b) { return a + b; }   // same name, diff params
}
public class Main {
    public static void main(String[] a) {
        Calc c = new Calc();
        System.out.println(c.add(2, 3) + " " + c.add(2.5, 3.5));
    }
}
```

**Summary — Encapsulation → Protect, Inheritance → Reuse, Polymorphism → Many Forms.**
