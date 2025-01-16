import java.util.Arrays;

class FibonacciCalculatorTest {
    public static void main(String[] args) {
        FibonacciCalculator fc = new FibonacciCalculator();
        for (int testInput = 10; testInput >= 0; testInput--) {
            System.out.println("\nfc.calculateRecursive(" + testInput + ") = " + fc.calculateRecursive(testInput));
            System.out.println("fc.calculateIterative(" + testInput + ") = " + fc.calculateIterative(testInput));
            System.out.println("fc.calculateDynamically(" + testInput + ") = " + fc.calculateDynamically(testInput));
        }
    }
}

public class FibonacciCalculator {

    public int calculateRecursive(int n) {
        return switch (n) {
            case 0 -> 0;
            case 1, 2 -> 1;
            default -> calculateRecursive(n - 1) + calculateRecursive(n - 2);
        };
    }

    int[] dpArray = new int[]{0, 1, 1};

    public int calculateDynamically(int n) {
        if (n <= dpArray.length-2) {
            return dpArray[n];
        } else {
            int previousLength = dpArray.length;
            dpArray = Arrays.copyOf(dpArray, (n + 1));
            for (int i = previousLength; i < dpArray.length; i++) {
                dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
            }
            for(int f:dpArray){
                System.out.print(" " + f);
            }
            System.out.println();
        }
        return dpArray[n];
    }

    public int calculateIterative(int n) {
        return switch (n) {
            case 0 -> 0;
            case 1, 2 -> 1;
            default -> this.iterate(n);
        };
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