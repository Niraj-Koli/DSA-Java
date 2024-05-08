class K {
    private static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            int xor = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j <= i; j++) {
                System.out.print(xor);
                xor ^= 1;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;

        pattern(n);
    }
}