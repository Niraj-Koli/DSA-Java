/*
 * You are given a sorted array ‘arr’ of length ‘n’, which contains positive
 * integer positions of ‘n’ gas stations on the X-axis.
 * 
 * You are also given an integer ‘k’.
 * 
 * You have to place 'k' new gas stations on the X-axis.
 * 
 * You can place them anywhere on the non-negative side of the X-axis, even on
 * non-integer positions.
 * 
 * Let 'dist' be the maximum value of the distance between adjacent gas stations
 * after adding 'k' new gas stations.
 * 
 * Find the minimum value of dist.
 */

class MinimizeMaxDistanceToGasStation {

    // Time -> O(n * log(max)) //
    // Space -> O(1) //

    private static int numberOfGasStations(int[] nums, double dist) {
        int n = nums.length;

        int res = 0;

        for (int i = 1; i < n; i++) {
            int numberInBetween = (int) ((nums[i] - nums[i - 1]) / dist);

            if ((nums[i] - nums[i - 1]) == (dist * numberInBetween)) {
                numberInBetween--;
            }

            res += numberInBetween;
        }

        return res;
    }

    private static double minimiseMaxDistance(int[] nums, int k) {
        int n = nums.length;

        double left = 0;
        double right = 0;

        for (int i = 0; i < n - 1; i++) {
            right = Math.max(right, (double) (nums[i + 1] - nums[i]));
        }

        double diff = 1e-6;

        while (right - left > diff) {
            double mid = left + ((right - left) / (2.0));

            int res = numberOfGasStations(nums, mid);

            if (res <= k) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 6;

        System.out.println(minimiseMaxDistance(nums, k));
    }
}