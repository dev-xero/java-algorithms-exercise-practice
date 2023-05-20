import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * class containing static methods to compute the fibonacci sequence sum for an integer
 * the class contains two implementations:
 * 1. a recursive method
 * 2. a much faster method utilizing memoization and dynamic programming
 * */
class Fibonacci {
    // recursive implementation
    public static long Fib(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;

        return Fib(N - 2) + Fib(N - 1);
    }


    // dynamic programming and memoization
    public static long FastFib(int N, HashMap<Integer, Long> cache) {
        if (N == 0) {
            cache.put(N, 0L);
            return 0;
        }

        if (N == 1) {
            cache.put(N, 1L);
            return 1;
        }

        cache.put(N, cache.get(N - 2) + cache.get(N - 1));
        return cache.get(N);
    }
}


public class PracticeAlgorithms {
    public static boolean isBetweenZeroAndOne(double x, double y) {
        return (0 < x && x < 1) && (0 < y && y < 1);
    }


    /**
     * static method to return the binary string representation of an integer
     * */
    public static String toBinaryString(int x) {
        StringBuilder binaryString = new StringBuilder();
        binaryString.append(binaryFormString(x, binaryString.toString()));

        return binaryString.toString();
    }


    /**
     * static recursive method that "builds" the binary string
     * */
    private static String binaryFormString(int x, String binString) {
        if (x == 1) return binString + "1";

        return binaryFormString(x / 2, binString) + (x % 2);
    }


    /**
    * static method to print a "*" or " " depending on the contents in a two-dimensional array
    * */
    public static void printTwoDmBooleanArray(boolean[][] theArray) {
        for (boolean[] row : theArray) {
            for (boolean column : row) {
                if (column) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    /**
     * static method to print the formatted contents of a two-dimensional int array
     * */
    public static void printTwoDmIntArray(int[][] theArray) {

        for (int[] rows : theArray) {
            for (int cols : rows) {
                System.out.printf("[%d] ", cols);
            }
            System.out.println();
        }
    }


    /**
     * static method to print the formatted contents of an int array
     * */
    public static void printIntArray(int[] theArray) {
        for (int item : theArray) {
            System.out.printf("%d ", item);
        }
        System.out.println();
    }


    /**
     * static method that returns the transposition of an input matrix
     * */
    public static int[][] matrixTransposition(int[][] theMatrix) {
        int rows = theMatrix.length;
        int cols = theMatrix[0].length;

        int[][] transposedMatrix = new int[cols][rows];

        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                transposedMatrix[j][i] = theMatrix[i][j];
            }
        }

        return transposedMatrix;
    }


    /**
     * static recursive method that returns the greatest integer not greater than log(N)
     * to base two
     * */
    public static int lg(int N) {
        if (N <= 1) return 0;

        return 1 + lg(N / 2);
    }

    /**
     * static recursive method to compute the factorial of an integer "N"
     * */
    public static long fact(int N) {
        if (N == 1) return 1;

        return N * fact(N - 1);
    }


    /**
     * static method that calls rank to binary search for "key"
     * */
    public static int binarySearch(int key, int[] array) {
        Arrays.sort(array); // we need the array to be sorted
        return rank(key, array, 0, array.length - 1);
    }


    /**
     * static recursive method that implements binary search
     * */
    private static int rank(int key, int[] array, int minIndex, int maxIndex) {
        if (minIndex > maxIndex) return -1;
        int midIndex = minIndex + (maxIndex - minIndex) / 2;

        if (array[midIndex] == key) return midIndex;

        if (array[midIndex] < key)
            return rank(key, array, midIndex + 1, maxIndex);
        else
            return rank(key, array, minIndex, maxIndex - 1);
    }


    /**
     * static method to brute force search for a "key" in an int array
     * */
    public static int bruteForceSearch(int key, int[] theArray) {
        for (int i = 0; i < theArray.length; i++) {
            if (theArray[i] == key) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Random generator = new Random();
        HashMap<Integer, Long> cache = new HashMap<>();

        double testX = 0.1;
        double testY = 0.5;

        boolean[][] testTwoDmBooleanArray = new boolean[3][2];
        int[][] testIntMatrix = new int[3][2];

        int[] testIntArray = new int[10];

        testIntArray[0] = 5;
        testIntArray[1] = 7;
        testIntArray[2] = 6;
        testIntArray[3] = 9;
        testIntArray[4] = 3;
        testIntArray[5] = 8;
        testIntArray[6] = 2;
        testIntArray[7] = 4;
        testIntArray[8] = 1;
        testIntArray[9] = 10;

        int[] sortedTestIntArray = Arrays.copyOf(testIntArray, testIntArray.length);
        Arrays.sort(sortedTestIntArray);

        testTwoDmBooleanArray[0][0] = true;
        testTwoDmBooleanArray[0][1] = false;
        testTwoDmBooleanArray[1][0] = false;
        testTwoDmBooleanArray[1][1] = true;
        testTwoDmBooleanArray[2][0] = true;
        testTwoDmBooleanArray[2][1] = false;

        for (int i = 0; i < testIntMatrix.length; i++) {
            for (int j = 0; j < testIntMatrix[i].length; j++) {
                testIntMatrix[i][j] = generator.nextInt(10);
            }
        }

        System.out.println(isBetweenZeroAndOne(testX, testY));
        System.out.println(toBinaryString(8));
        System.out.println();

        printTwoDmBooleanArray(testTwoDmBooleanArray);
        System.out.println();

        System.out.println("- Matrix");
        printTwoDmIntArray(testIntMatrix);
        System.out.println();

        System.out.println("- Transposed");
        printTwoDmIntArray(matrixTransposition(testIntMatrix));
        System.out.println();

        System.out.println(lg(32));
        System.out.println();

        // loop utilizing dynamic programming and memoization
        System.out.println("- Dynamic Programming and Memoization");
        for (int i = 0; i <= 40; i++) {
            System.out.println(Fibonacci.FastFib(i, cache));
        }
        System.out.println();

         // loop utilizing the recursive fib method
         System.out.println("- Recursion");
         for (int i = 0; i <= 40; i++) {
         System.out.println(Fibonacci.Fib(i));
         }
         System.out.println();

        System.out.printf("31!: %d\n", fact(31)); // N > 31 causes overflow
        System.out.println();

        System.out.println("- The Sorted Array");
        printIntArray(sortedTestIntArray);
        System.out.println();

        System.out.println("- Binary Search: key = 5");
        System.out.println("index: " + binarySearch(5, testIntArray));
        System.out.println();

        System.out.println("- Brute Force Search: key = 3");
        System.out.println("index: " + bruteForceSearch(3, testIntArray));
        System.out.println();
    }
}
