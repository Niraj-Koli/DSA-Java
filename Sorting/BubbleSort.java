public class BubbleSort {

    // Time -> O(n^2) //
    // Space -> O(1) //

    public static void bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };

        bubbleSort(nums);

        for (int number : nums) {
            System.out.print(number + " ");
        }
    }
}