class SetithBit {

    // Time -> O(1) //
    // Space -> O(1) //
    public static void main(String[] args) {
        int n = 12;
        int i = 1;

        int setBit = ((1 << i) | n);

        System.out.println(setBit);

        int j = 2;

        int clearBit = (~(1 << j) & n);

        System.out.println(clearBit);
    }
}
