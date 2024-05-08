class SelectionSort {

    // Time -> O(n^2) //
    // Space -> O(1) //

    private static void selectionSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };

        selectionSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
