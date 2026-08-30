# 5. Arrays

**Definition:** An array is a collection of elements of the **same data type**, stored
in contiguous memory, referred to by a single variable name, and accessed via a
zero-based index.

**Points:**
1. Arrays in Java are **objects**, created dynamically with `new`; size is fixed once created.
2. Needed to: store many values under one name, access elements efficiently by index,
   simplify iteration with loops, and represent matrices/tables.
3. `arrayName.length` gives the size — it's a **field**, not a method (no `()`).
4. The reference variable lives in the stack; actual elements live in the heap.
5. Arrays can be **1D** (list) or **multi-dimensional** (e.g. **2D** = table/matrix,
   most common form beyond 1D).
6. Elements are indexed from `0` to `length-1`.
7. Limitations: fixed size, only same data type, costly insertion/deletion (needs shifting).

---

## 5.1 One-Dimensional (1D) Arrays

**Syntax:**
```java
dataType[] arrayName;                 // declaration
arrayName = new dataType[size];       // memory allocation
dataType[] arrayName = new dataType[size];   // combined
int[] numbers = {10, 20, 30, 40};     // declaration + initialization
```

**Easiest Program (declare, initialize, traverse — answers "how arrays are declared/initialized/used"):**
```java
public class ArrayDemo {
    public static void main(String[] args) {
        int[] marks = {90, 85, 76, 60};   // declared + initialized
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            System.out.println("Index " + i + ": " + marks[i]);
            sum += marks[i];
        }
        System.out.println("Total: " + sum + ", Average: " + (sum / (double) marks.length));
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int[] n={1,2,3}; System.out.println(n[0]+n.length); } }
```

---

## 5.2 Two-Dimensional (2D) Arrays

**Definition:** A 2D array is an array of arrays — represents data as a table/matrix
with rows and columns.

**Syntax (answers "syntax of declaration of 2D arrays"):**
```java
dataType[][] arrayName = new dataType[rows][columns];   // e.g. int[][] m = new int[3][3];
int[][] arr = { {1,2,3}, {4,5,6}, {7,8,9} };             // with initialization
// access: arr[row][col]; arr.length = rows; arr[i].length = columns in row i
```

**Points:**
1. Declared using two sets of brackets `[][]`.
2. Each "row" is itself a separate 1D array object.
3. `arr[i][j]` → element at row `i`, column `j`.
4. Traversed using **nested loops** — outer loop for rows, inner loop for columns.
5. Very commonly used for **matrix operations** (addition, transpose, multiplication).

**Easiest Program (2D array declared, initialized, traversed):**
```java
public class Array2DDemo {
    public static void main(String[] args) {
        int[][] arr = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
                sum += arr[i][j];
            }
            System.out.println();
        }
        System.out.println("Sum: " + sum);
    }
}
```

**Smallest Program:**
```java
public class Main { public static void main(String[] a){ int[][] m={{1,2},{3,4}}; System.out.println(m[1][1]); } }
```

---

## 5.3 Matrix Addition (asked with: plain 2x2, "order N", "using command line arguments")

**Points:**
1. To add two matrices, both must have the **same dimensions**.
2. `result[i][j] = a[i][j] + b[i][j]` for every row `i` and column `j`.
3. "Order N" just means the code should work for any N×N size, not a hardcoded 2x2.
4. "Using command line arguments" means reading matrix size/values from `args[]`
   passed to `main(String[] args)` instead of hardcoding them (or from `Scanner` — VTU
   accepts either; command-line args shown below since explicitly asked).

**Easiest Program — fixed order (2x2), the simplest correct version:**
`programs/MatrixAddition.java`

**Easiest Program — generic order N:**
`programs/MatrixAdditionN.java`

**Easiest Program — using command-line arguments:**
`programs/MatrixAdditionCLI.java`

**Smallest Program (2x2, minimal):**
```java
public class Main {
    public static void main(String[] a) {
        int[][] x = {{1,2},{3,4}}, y = {{5,6},{7,8}};
        for (int i = 0; i < 2; i++) for (int j = 0; j < 2; j++) System.out.print((x[i][j]+y[i][j]) + " ");
    }
}
```

---

## 5.4 Transpose of a Matrix

**Definition:** The transpose of a matrix swaps its rows and columns: `T[j][i] = M[i][j]`.

**Easiest Program:** `programs/TransposeMatrix.java`

**Smallest Program:**
```java
public class Main {
    public static void main(String[] a) {
        int[][] m = {{1,2},{3,4}};
        for (int i=0;i<2;i++) for (int j=0;j<2;j++) System.out.print(m[j][i] + " ");
    }
}
```

---

## 5.5 2D Array with for-each (initialize with values, print using for-each)

**Points:**
1. The for-each loop on a 2D array gives you each **row** (a 1D array) in the outer
   loop, so you still need an inner for-each (or for loop) to get individual elements.
2. Syntax: `for (dataType[] row : arr2D) { for (dataType val : row) { ... } }`

**Easiest Program:** `programs/ForEach2DArray.java`

**Smallest Program:**
```java
public class Main {
    public static void main(String[] a) {
        int[][] m = {{1,2},{3,4}};
        for (int[] row : m) for (int v : row) System.out.print(v + " ");
    }
}
```

---

## 5.6 Average of Array Elements (using for-each / plain loop)

**Points:**
1. Sum all elements, divide by `array.length`.
2. Cast to `double` before dividing to avoid integer division truncation.

**Easiest Program (average of {8,6,2,7}):** `programs/AverageArray.java`
**Easiest Program (average of {1,2,3,4,5} using for-each):** `programs/AverageForEach.java`

**Smallest Program:**
```java
public class Main {
    public static void main(String[] a) {
        int[] n = {8,6,2,7}; int s=0;
        for (int v : n) s += v;
        System.out.println(s / (double) n.length);
    }
}
```

---

## 5.7 Linear Search (keyboard input for both array and key)

**Definition:** Linear search checks each element one by one from the start until it
finds the target (key), or reaches the end.

**Points:**
1. Time complexity O(n) — checks every element in the worst case.
2. Works on unsorted arrays (unlike binary search).
3. Use `Scanner` to read array size, elements, and the key from the keyboard.
4. Loop through the array; if `arr[i] == key`, record the index and stop (or continue
   to report "not found" if the loop completes without a match).

**Easiest Program:** `programs/LinearSearch.java`

**Smallest Program (hardcoded, no keyboard input — the core logic only):**
```java
public class Main {
    public static void main(String[] a) {
        int[] arr = {4,8,15,16}; int key = 15, idx = -1;
        for (int i = 0; i < arr.length; i++) if (arr[i] == key) { idx = i; break; }
        System.out.println(idx);
    }
}
```

---

## 5.8 Sorting elements using a for loop

**Definition:** Sorting arranges elements in a defined order (ascending here) using
comparisons and swaps — **Bubble Sort** is the simplest for-loop-based approach.

**Points:**
1. Bubble sort: repeatedly compare adjacent elements, swap if out of order.
2. Needs a **nested for loop** — outer loop for passes, inner loop for comparisons.
3. After each full pass, the largest remaining element "bubbles" to the end.

**Easiest Program:** `programs/SortForLoop.java`

**Smallest Program:**
```java
public class Main {
    public static void main(String[] a) {
        int[] n = {5,2,4,1};
        for (int i=0;i<n.length-1;i++) for (int j=0;j<n.length-1-i;j++)
            if (n[j]>n[j+1]) { int t=n[j]; n[j]=n[j+1]; n[j+1]=t; }
        for (int v : n) System.out.print(v + " ");
    }
}
```
