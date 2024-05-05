class TwoDistinctNumbers {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int[] twoOddNum(int[] nums) {
        int n = nums.length;

        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        int index = 0;

        while (xor != 0) {
            if ((xor & 1) == 1) {
                break;
            }
            index++;

            xor = xor >> 1;
        }

        int res1 = 0;
        int res2 = 0;

        for (int i = 0; i < n; i++) {
            if (((1 << index) & nums[i]) != 0) {
                res1 ^= nums[i];
            } else {
                res2 ^= nums[i];
            }
        }

        return new int[] { res1, res2 };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 5, 3, 2, 3, 4, 7, 4 };

        int[] ans = twoOddNum(nums);

        System.out.println("[" + ans[0] + ", " + ans[1] + "]");
    }
}
