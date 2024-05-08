class QuickSort {

    // Time -> O(n * log(n)) //
    // Space -> O(log(n)) //

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        
        return i + 1;
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(nums, low, high);

            quickSort(nums, low, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };

        int n = nums.length;

        quickSort(nums, 0, n - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
