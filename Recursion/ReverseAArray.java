import java.util.Arrays;

class ReverseAArray {
    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static void reverse(int[] nums, int i) {
        int n = nums.length;

        if (i >= n / 2) {
            return;
        }

        swap(nums, i, n - 1 - i);

        reverse(nums, i + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        System.out.println(Arrays.toString(nums));

        reverse(nums, 0);

        System.out.println(Arrays.toString(nums));
    }
}