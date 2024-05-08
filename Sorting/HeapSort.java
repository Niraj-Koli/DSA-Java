class HeapSort {

    // Time -> O(n * log(n)) //
    // Space -> O(1) //

    private static void heapify(int[] nums, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && nums[leftChild] > nums[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && nums[rightChild] > nums[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int swap = nums[i];
            nums[i] = nums[largest];
            nums[largest] = swap;

            heapify(nums, n, largest);
        }
    }

    private static void heapSort(int[] nums) {
        int n = nums.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;

            heapify(nums, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };

        heapSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
