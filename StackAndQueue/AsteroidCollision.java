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

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
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
                stack.offerLast(asteroid);
            }
        }

        int n = stack.size();

        int[] result = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            result[i] = stack.pollLast();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = { 5, 10, -5 };

        int[] answer = asteroidCollision(asteroids);

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}

// class Solution {
// public int[] asteroidCollision(int[] asteroids) {
// int n = asteroids.length;
// Stack<Integer> s = new Stack<>();
// for (int i = 0; i < n; i++) {
// if (asteroids[i] > 0 || s.isEmpty()) {
// s.push(asteroids[i]);
// } else {
// while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroids[i])) {
// s.pop();
// }
// if (!s.isEmpty() && s.peek() == Math.abs(asteroids[i])) {
// s.pop();
// } else {
// if (s.isEmpty() || s.peek() < 0) {
// s.push(asteroids[i]);
// }
// }
// }
// }
// int[] res = new int[s.size()];
// for (int i = s.size() - 1; i >= 0; i--) {
// res[i] = s.pop();
// }
// return res;
// }
// }