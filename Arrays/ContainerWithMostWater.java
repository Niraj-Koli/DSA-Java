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

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int len = height.length;

        int i = 0;
        int j = len - 1;

        int max = Integer.MIN_VALUE;

        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, height[i] * (j - i));
                i++;
            } else {
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        int answer = maxArea(height);

        System.out.println(answer);
    }
}

// class Solution {
// public int maxArea(int[] hs) {
// int max = 0, i = 0, j = hs.length - 1;
// while (i < j) {
// int h = Math.min(hs[i], hs[j]);
// max = Math.max(max, h * (j - i));
// while (hs[i] <= h && i < j) i++;
// while (hs[j] <= h && i < j) j--;
// }
// return max;
// }
// }