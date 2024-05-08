class CountingSort {

    // Time -> O(n + k) //
    // Space -> O(k) //

    private static void countingSort(int[] nums, int maxValue) {
        int n = nums.length;

        int[] count = new int[maxValue + 1];
        int[] output = new int[n];

        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i <= maxValue; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[nums[i]] - 1] = nums[i];
            count[nums[i]]--;
        }

        System.arraycopy(output, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };
        int max = 91;

        countingSort(nums, max);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}