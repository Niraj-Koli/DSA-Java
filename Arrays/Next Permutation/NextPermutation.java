/*
 * A permutation of an array of integers is an arrangement of its members into a
 * sequence or linear order.
 * 
 * For example, for arr = [1,2,3], the following are all the permutations of
 * arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
 * The next permutation of an array of integers is the next lexicographically
 * greater permutation of its integer. More formally, if all the permutations of
 * the array are sorted in one container according to their lexicographical
 * order, then the next permutation of that array is the permutation that
 * follows it in the sorted container. If such arrangement is not possible, the
 * array must be rearranged as the lowest possible order (i.e., sorted in
 * ascending order).
 * 
 * For example, the next permutation of arr = [1,2,3] is [1,3,2].
 * Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
 * While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does
 * not have a lexicographical larger rearrangement.
 * Given an array of integers nums, find the next permutation of nums.
 * 
 * The replacement must be in place and use only constant extra memory.
 */

public class NextPermutation {

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i + 1);

        return nums;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;

        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2 };

        int[] result = nextPermutation(nums);

        for (int integer : result) {
            System.out.println(integer);
        }
    }
}

// LeetCode //

// class Solution {
// public List<List<Integer>> generate(int numRows) {

// List<List<Integer>> ans = new ArrayList<>();

// // Store the entire Pascal's triangle:
// for (int row = 1; row <= numRows; row++) {
// List<Integer> tempLst = new ArrayList<>(); // temporary list
// for (int col = 1; col <= row; col++) {
// tempLst.add(ncr(row - 1, col - 1));
// }
// ans.add(tempLst);
// }
// return ans;
// }
// public static int ncr(int n , int r){
// long res = 1;
// for(int i= 0 ; i<r ; i++){
// res = res * (n-i);
// res = res / (i+1);
// }
// return (int)res;
// }
// }