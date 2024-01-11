public class XORFromRanges {
    public static int xorOfn(int n) {
        if (n % 4 == 0) {
            return n;
        } else if (n % 4 == 1) {
            return 1;
        } else if (n % 4 == 2) {
            return n + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int n = 14;

        int answer = xorOfn(n);

        System.out.println(answer);

        int l = 3;
        int r = 9;

        int ans1 = xorOfn(l);
        int ans2 = xorOfn(r);

        int ans = ans2 ^ ans1;

        System.out.println(ans);
    }
}
