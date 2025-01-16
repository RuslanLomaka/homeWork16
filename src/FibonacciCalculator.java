public class FibonacciCalculator {

    public int calculateRecursive(int n) {
        return switch (n) {
            case 0 -> 0;
            case 1, 2 -> 1;
            default -> calculateRecursive(n - 1) + calculateRecursive(n - 2);
        };
    }

    public int calculateIterative(int n) {
        return switch (n) {
            case 0 -> 0;
            case 1, 2 -> 1;
            default -> this.iterate(n);
        };
    }

    public int calculateDynamically(int n){
        return n;
    }

    private int iterate(int n) {
        int r = 0;    // r   stands for result
        int pr = 1;   // pr  stands for previous result
        int ppr;      // ppr stands for pre-previous result
        for (int i = 0; i < n; i++) {
            ppr = pr;
            pr = r;
            r = pr + ppr;
        }
        return r;
    }
}

class FibonacciCalculatorTest {
    public static void main(String[] args) {
        FibonacciCalculator fc = new FibonacciCalculator();
        for (int testInput = 0; testInput <= 10; testInput++) {
            System.out.println("\nfc.calculateRecursive(" + testInput + ") = " + fc.calculateRecursive(testInput));
            System.out.println("fc.calculateIterative(" + testInput + ") = " + fc.calculateIterative(testInput));
        }
    }
}