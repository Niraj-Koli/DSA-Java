/*
 * Given an array of integers. Find the Inversion Count in the array.
 * 
 * Inversion Count: For an array, inversion count indicates how far (or close)
 * the array is from being sorted. If the array is already sorted then the
 * inversion count is 0.
 * If an array is sorted in the reverse order then the inversion count is the
 * maximum.
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i <
 * j.
 */

import java.util.ArrayList;

class CountInversions {

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static int merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();

        int left = low;
        int right = mid + 1;

        int count = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                count += (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }

        return count;
    }

    private static int mergeSort(int[] arr, int low, int high) {
        int count = 0;

        if (low >= high) {
            return count;
        }

        int mid = (low + high) / 2;

        count += mergeSort(arr, low, mid);
        count += mergeSort(arr, mid + 1, high);

        count += merge(arr, low, mid, high);

        return count;
    }

    private static int numberOfInversions(int[] arr, int n) {
        return mergeSort(arr, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 1, 3, 5 };
        int n = 5;

        System.out.println(numberOfInversions(arr, n));
    }
}