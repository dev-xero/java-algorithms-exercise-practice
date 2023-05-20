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

    public static void main(String[] args) {
        double testX = 0.1;
        double testY = 0.5;

        boolean[][] testTwoDmBooleanArray = new boolean[3][2];

        testTwoDmBooleanArray[0][0] = true;
        testTwoDmBooleanArray[0][1] = false;
        testTwoDmBooleanArray[1][0] = false;
        testTwoDmBooleanArray[1][1] = true;
        testTwoDmBooleanArray[2][0] = true;
        testTwoDmBooleanArray[2][1] = false;

        System.out.println(isBetweenZeroAndOne(testX, testY));
        System.out.println(toBinaryString(8));
        System.out.println();

        printTwoDmBooleanArray(testTwoDmBooleanArray);
    }
}
