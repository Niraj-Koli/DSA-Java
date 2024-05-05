class BitsManipulation {

    // Time -> O(log(n)) //
    // Space -> O(log(n)) //

    private static String printBits(int n) {
        return Integer.toBinaryString(n);
    }

    public static void main(String[] args) {
        int x = 12;
        int y = 10;

        System.out.println("x: " + x + " = " + printBits(x));
        System.out.println("y: " + y + " = " + printBits(y));

        // And //

        int and = x & y;
        System.out.println("And: " + and + " = " + printBits(and));

        // Or //

        int or = x | y;
        System.out.println("Or: " + or + " = " + printBits(or));

        // Xor //

        int xor = x ^ y;
        System.out.println("Xor: " + xor + " = " + printBits(xor));

        // Left Shift //

        int leftX = x << 2;
        int leftY = y << 2;

        System.out.println("leftX: " + leftX + " = " + printBits(leftX));
        System.out.println("leftY: " + leftY + " = " + printBits(leftY));

        // Right Shift //

        int rightX = x >> 2;
        int rightY = y >> 2;

        System.out.println("RightX: " + rightX + " = " + printBits(rightX));
        System.out.println("RightY: " + rightY + " = " + printBits(rightY));

        // Not //
        
        int notX = ~x;
        int notY = ~y;

        System.out.println("~x: " + notX + " = " + printBits(notX));
        System.out.println("~y: " + notY + " = " + printBits(notY));
    }
}