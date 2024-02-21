/*
 * Given a characters array tasks, representing the tasks a CPU needs to do,
 * where each letter represents a different task. Tasks could be done in any
 * order. Each task is done in one unit of time. For each unit of time, the CPU
 * could complete either one task or just be idle.
 * 
 * However, there is a non-negative integer n that represents the cooldown
 * period between two same tasks (the same letter in the array), that is that
 * there must be at least n units of time between any two same tasks.
 * 
 * Return the least number of units of times that the CPU will take to finish
 * all the given tasks.
 */

import java.util.Arrays;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        int len = tasks.length;

        int[] chFreq = new int[26];
        for (char task : tasks) {
            chFreq[task - 'A']++;
        }

        Arrays.sort(chFreq);
        System.out.println(Arrays.toString(chFreq));

        int i = 25;
        while (i >= 0 && chFreq[i] == chFreq[25]) {
            i--;
        }

        return Math.max(len, (chFreq[25] - 1) * (n + 1) + 25 - i);
    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int n = 2;

        int ans = leastInterval(tasks, n);

        System.out.println(ans);
    }
}

// class Solution {
// public int leastInterval(char[] tasks, int n) {
// if (n == 0)
// return tasks.length;
// int[] frequencies = new int[26];
// for (char task : tasks) {
// ++frequencies[task - 'A'];
// }
// int maxFrequency = 0, maxCount = 0;
// for (int freq : frequencies)
// maxFrequency = Math.max(maxFrequency, freq);
// for (int freq : frequencies)
// if (freq == maxFrequency)
// ++maxCount;

// int slotnum = maxFrequency - 1, slotlen = n - (maxCount - 1);
// int taskNeed = slotnum * slotlen;
// int tasksToFill = tasks.length - (maxCount * maxFrequency);
// int idle = Math.max(0, taskNeed - tasksToFill);
// return tasks.length + idle;
// }
// }