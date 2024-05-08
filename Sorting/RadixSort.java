import java.util.Arrays;

class RadixSort {

    // Time -> O(nk) //
    // Space -> O(n + k) //

    private static void countingSort(int[] nums, int exp) {
        int n = nums.length;

        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        for (int i = 0; i < n; i++) {
            count[(nums[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, nums, 0, n);
    }

    private static void radixSort(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(nums, exp);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };

        radixSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
