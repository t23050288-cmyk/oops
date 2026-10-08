/* Lexical elements: whitespace, identifiers, literals, comments, separators, keywords */
public class LexicalDemo {                       // identifier: LexicalDemo, keywords: public, class
    public static void main(String[] args) {     // separators: ( ) { } [ ] ;
        /* multi-line comment */
        int studentAge = 20;                     // identifier + integer literal
        double pi = 3.14;                        // floating-point literal
        char grade = 'A';                        // character literal
        String name = "Ravi";                    // string literal
        boolean pass = true;                     // boolean literal
        int hex = 0x1F, bin = 0b101, big = 1_000_000;  // hex, binary, underscore literals
        System.out.println(name + " " + studentAge + " " + grade + " " + pi + " " + pass);
        System.out.println(hex + " " + bin + " " + big);
    }
}
