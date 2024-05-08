/*
 * We are given an array asteroids of integers representing asteroids in a row.
 * 
 * For each asteroid, the absolute value represents its size, and the sign
 * represents its direction (positive meaning right, negative meaning left).
 * Each asteroid moves at the same speed.
 * 
 * Find out the state of the asteroids after all collisions. If two asteroids
 * meet, the smaller one will explode. If both are the same size, both will
 * explode. Two asteroids moving in the same direction will never meet.
 */

import java.util.ArrayDeque;

class AsteroidCollision {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && asteroid < 0 && stack.peekLast() > 0) {
                int diff = asteroid + stack.peekLast();

                if (diff < 0) {
                    stack.pollLast();
                } else if (diff > 0) {
                    asteroid = 0;
                } else {
                    asteroid = 0;
                    stack.pollLast();
                }
            }

            if (asteroid != 0) {
                stack.offer(asteroid);
            }
        }

        int n = stack.size();

        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            res[i] = stack.pollLast();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = { 5, 10, -5 };

        int[] ans = asteroidCollision(asteroids);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}