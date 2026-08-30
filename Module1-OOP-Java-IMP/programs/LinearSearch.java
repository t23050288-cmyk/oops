// Q2c, Jun/Jul 2024 — Linear search on array elements accepted from keyboard, key also from keyboard.
import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.print("Enter the key to search: ");
        int key = sc.nextInt();

        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                index = i;
                break;                 // stop as soon as found
            }
        }

        if (index != -1) System.out.println("Key found at index " + index);
        else System.out.println("Key not found in the array");

        sc.close();
    }
}
