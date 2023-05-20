public class PracticeAlgorithms {
    public static boolean isBetweenZeroAndOne(double x, double y) {
        return (0 < x && x < 1) && (0 < y && y < 1);
    }

    public static String toBinaryString(int x) {
        StringBuilder binaryString = new StringBuilder();
        binaryString.append(binaryFormString(x, binaryString.toString()));

        return binaryString.reverse().toString();
    }

    private static String binaryFormString(int x, String binString) {
        if (x == 1) return binString + "1";

        return (x % 2) + binaryFormString(x / 2, binString);
    }

    public static void main(String[] args) {
        double testX = 0.1;
        double testY = 0.5;

        System.out.println(isBetweenZeroAndOne(testX, testY));

        System.out.println(toBinaryString(7));
    }
}
