/*
 * Alice has some number of cards and she wants to rearrange the cards into
 * groups so that each group is of size groupSize, and consists of groupSize
 * consecutive cards.
 * 
 * Given an integer array hand where hand[i] is the value written on the ith
 * card and an integer groupSize, return true if she can rearrange the cards, or
 * false otherwise.
 */

import java.util.Arrays;
import java.util.HashMap;

class HandOfStraights {

    // Time -> O(n * log(n)) //
    // Space -> O(n) //

    private static boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);

        for (int num : hand) {
            if (map.getOrDefault(num, 0) > 0) {
                for (int i = 0; i < groupSize; i++) {
                    int nextNum = num + i;

                    if (map.getOrDefault(nextNum, 0) == 0) {
                        return false;
                    }

                    map.put(nextNum, map.get(nextNum) - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        int groupSize = 3;

        System.out.println(isNStraightHand(hand, groupSize));
    }
}