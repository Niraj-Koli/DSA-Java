/*
 * There are ‘n’ fruit trees that are planted along a road. The trees are
 * numbered from 0 to n-1. The type of fruit each tree bears is represented by
 * an integer from 1 to 'n'.
 * 
 * A Ninja is walking along that road. He has two baskets and wants to put the
 * maximum number of fruits in them. The restriction is that each basket can
 * have only one type of fruit.
 * 
 * Ninja can start with any tree and end at any tree, but once he has started,
 * he cannot skip a tree i.e if he picks fruit from the tree ‘i’, then he has to
 * pick fruit from tree ‘i+1’ before going to the tree ‘i+2’. He will pick one
 * fruit from each tree until he cannot, i.e, he will stop when he has to pick a
 * fruit of the third type because only two different fruits can fill both
 * baskets.
 * 
 * You are given an array ‘arr’. The ‘i’th integer in this array represents the
 * type of fruit tree ‘i’ bears. Return the maximum number of fruits Ninja can
 * put in both baskets after satisfying all the conditions.
 */

import java.util.HashMap;

public class FruitsAndBaskets {

    // Time -> O(n)
    // Space -> O(1)

    private static int findMaxFruits(int[] fruits) {
        int n = fruits.length;

        int k = 2;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int res = 0;

        for (int i = 0, j = 0; j < n; j++) {
            int fruitAtJ = fruits[j];

            map.put(fruitAtJ, map.getOrDefault(fruitAtJ, 0) + 1);

            if (map.size() == k) {
                res = Math.max(res, j - i + 1);
            }

            while (map.size() > k) {
                int fruitAtI = fruits[i];

                map.put(fruitAtI, map.get(fruitAtI) - 1);

                if (map.get(fruitAtI) == 0) {
                    map.remove(fruitAtI);
                }
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] fruits = { 1, 1, 2, 3 };

        System.out.println(findMaxFruits(fruits));
    }
}