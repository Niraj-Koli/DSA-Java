class CheckIfANumberIsPowerOf2 {

    // Time -> O(1) //
    // Space -> O(1) //
    public static void main(String[] args) {
        int n = 16;

        boolean isPower = (n & n - 1) == 0;

        if (isPower) {
            System.err.println(n + " is power of 2");
        } else {
            System.out.println(n + " is not the power of 2");
        }

        // Delete last set bit int bit = (n & n - 1); //
    }
}
