class CheckIfABitIsSet {

    // Time -> O(1) //
    // Space -> O(1) //
    public static void main(String[] args) {
        int n = 12;
        int i = 3;

        boolean set = ((1 << i) & n) != 0;
        // boolean set = ((n >> i) & 1) != 0;

        if (set) {
            System.out.println("ith Bit Is Set");
        } else {
            System.out.println("ith Bit Is Not Set");
        }
    }
}
