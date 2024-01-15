public class QuickSelect {

    public static int quickSelect(int[] nums, int left, int right, int k) {
        if (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (k < pivotIndex - left + 1) {
                return quickSelect(nums, left, pivotIndex - 1, k);
            } else if (k > pivotIndex - left + 1) {
                return quickSelect(nums, pivotIndex + 1, right, k - (pivotIndex - left + 1));
            } else {
                return nums[pivotIndex];
            }
        }

        return -1;
    }

    public static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, right);

        return i + 1;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 4, 2, 2, 5, 3 };
        int k = 3;

        int n = nums.length;

        int answer = quickSelect(nums, 0, n - 1, k);

        System.out.println(answer);
    }
}
