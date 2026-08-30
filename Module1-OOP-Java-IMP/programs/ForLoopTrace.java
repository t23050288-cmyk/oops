// Undated Paper Q1b — Trace the output of a for loop (template method for any similar question).
public class ForLoopTrace {
    public static void main(String[] args) {
        // Trace: b=1 (1<=5 true, print 1, b becomes 2)
        //        b=2 (true, print 2, b becomes 3) ... up to b=5 (true, print 5, b becomes 6)
        //        b=6 (6<=5 false) -> loop stops
        for (int b = 1; b <= 5; b++) {
            System.out.println(b);
        }
        // Output: 1 2 3 4 5 (one per line)
    }
}
