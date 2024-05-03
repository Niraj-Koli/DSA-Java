/*
 * You are given an integer array height of length n. There are n vertical lines
 * drawn such that the two endpoints of the ith line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 */

class ContainerWithMostWater {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int maxArea(int[] height) {
        int n = height.length;

        int i = 0;
        int j = n - 1;

        int area = Integer.MIN_VALUE;

        while (i < j) {
            int currentArea = Math.min(height[i], height[j]) * (j - i);
            area = Math.max(area, currentArea);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(maxArea(height));
    }
}