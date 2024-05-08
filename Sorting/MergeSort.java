import java.util.ArrayList;

class MergeSort {

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static void merge(int[] nums, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }

        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            nums[i] = temp.get(i - low);
        }
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);

        merge(nums, low, mid, high);
    }

    public static void main(String[] args) {
        int[] nums = { 10, 7, 21, 47, 73, 91, 36, 52, 2, 69 };

        int n = nums.length;

        mergeSort(nums, 0, n - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
