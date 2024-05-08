/*
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it can trap after raining.
 */

class TrappingRainWater {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int trapWater(int[] height) {
        int n = height.length;

        int maxLeft = 0;
        int maxRight = 0;

        int left = 0;
        int right = n - 1;

        int res = 0;

        while (left <= right) {
            if (maxLeft < maxRight) {
                res += Math.max(0, maxLeft - height[left]);
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                res += Math.max(0, maxRight - height[right]);
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }

        return res;
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int trap(int[] height) {
        int n = height.length;

        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = height[0];

        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        maxRight[n - 1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        int[] trappedWater = new int[n];

        for (int i = 0; i < n; i++) {
            trappedWater[i] = Math.min(maxLeft[i], maxRight[i]) - height[i];
        }

        int totalTrappedWater = 0;

        for (int water : trappedWater) {
            totalTrappedWater += water;
        }

        return totalTrappedWater;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println(trap(height));
        System.out.println(trapWater(height));
    }
}