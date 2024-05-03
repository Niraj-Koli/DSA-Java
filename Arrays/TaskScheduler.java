/*
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task. Tasks could be done in any
 * order. Each task is done in one unit of time. For each unit of time, the CPU
 * could complete either one task or just be idle.
 * 
 * However, there is a non-negative integer k that represents the cooldown
 * period between two same tasks (the same letter in the array), that is that
 * there must be at least k units of time between any two same tasks.
 * 
 * Return the least number of units of times that the CPU will take to finish
 * all the given tasks.
 */

import java.util.Arrays;

class TaskScheduler {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int leastInterval(char[] tasks, int k) {
        int n = tasks.length;

        int[] chFreq = new int[26];

        for (char task : tasks) {
            chFreq[task - 'A']++;
        }

        Arrays.sort(chFreq);

        int i = 25;
        while (i >= 0 && chFreq[i] == chFreq[25]) {
            i--;
        }

        return Math.max(n, (chFreq[25] - 1) * (k + 1) + 25 - i);
    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int k = 2;

        System.out.println(leastInterval(tasks, k));
    }
}