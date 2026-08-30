// Q1b, Dec 2023/Jan 2024 — Develop a Java program to convert Celsius to Fahrenheit.
// Formula: F = (C * 9/5) + 32
import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature in Celsius: ");
        double celsius = sc.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println(celsius + " Celsius = " + fahrenheit + " Fahrenheit");
        sc.close();
    }
}
