// Q2b Dec 2025/Jan 2026, Q02b Model Paper — Sort the elements using a for loop (Bubble Sort).
public class SortForLoop {
    public static void main(String[] args) {
        int[] arr = {29, 10, 14, 37, 14};

        // Bubble sort: nested for loops
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Sorted array:");
        for (int v : arr) System.out.print(v + " ");
    }
}
