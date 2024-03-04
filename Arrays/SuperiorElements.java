/*
 * There is an integer array ‘a’ of size ‘n’.
 * 
 * An element is called a Superior Element if it is greater than all the
 * elements present to its right.
 * 
 * You must return an array all Superior Elements in the array ‘a’.
 * 
 * The last element of the array is always a Superior Element.
 */

import java.util.ArrayList;

public class SuperiorElements {

    // Time -> O(n)
    // Space -> O(n)

    private static ArrayList<Integer> superiorElements(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> res = new ArrayList<Integer>();

        int superior = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > superior) {
                res.add(nums[i]);
                superior = nums[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2 };

        System.out.println(superiorElements(nums));
    }
}