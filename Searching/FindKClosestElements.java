/*
 * Given a sorted integer array arr, two integers k and x, return the k closest
 * integers to x in the array. The result should also be sorted in ascending
 * order.
 * 
 * An integer a is closer to x than an integer b if:
 * 
 * |a - x| < |b - x|, or
 * |a - x| == |b - x| and a < b
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0;
        int right = arr.length - 1;

        int value = arr[0];
        int index = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            int currDiff = Math.abs(arr[middle] - x);
            int resDiff = Math.abs(value - x);

            if ((currDiff < resDiff) || (currDiff == resDiff && arr[middle] < value)) {
                value = arr[middle];
                index = middle;
            }

            if (arr[middle] < x) {
                left = middle + 1;
            } else if (arr[middle] > x) {
                right = middle - 1;
            } else {
                break;
            }
        }

        left = right = index;

        for (int i = 0; i < k - 1; i++) {
            if (left == 0) {
                right += 1;
            } else if ((right == arr.length - 1) || x - arr[left - 1] <= arr[right + 1] - x) {
                left -= 1;
            } else {
                right += 1;
            }
        }

        int[] nums = Arrays.copyOfRange(arr, left, right + 1);

        List<Integer> result = new ArrayList<Integer>();

        for (int num : nums) {
            result.add(num);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 3;

        List<Integer> answer = findClosestElements(arr, k, x);

        System.out.println(answer);
    }
}

// class Solution {
// public List<Integer> findClosestElements(int[] arr, int k, int x) {
// int left = 0;
// int right = arr.length - k;

// while (left < right) {
// int middle = left + (right - left) / 2;

// if (x - arr[middle] > arr[middle + k] - x) {
// left = middle + 1;
// } else {
// right = middle;
// }
// }

// int[] nums = Arrays.copyOfRange(arr, left, left + k);

// List<Integer> result = new ArrayList<Integer>();

// for (int num : nums) {
// result.add(num);
// }

// return result;
// }
// }