/*
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;

        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int adjNode : adj.get(i)) {
                indegree[adjNode]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            count++;

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;

                if (indegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }

        return count == numCourses ? true : false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = { { 1, 0 }, { 0, 1 } };

        boolean ans = canFinish(numCourses, prerequisites);

        System.out.println(ans);
    }
}

// class Solution {
// public boolean canFinish(int numCourses, int[][] prerequisites) {
// int[] pointer = new int[numCourses];
// for (int[] pre : prerequisites) {
// pointer[pre[1]]++;
// }
// int totalRemove = 0;
// int[] remove = new int[prerequisites.length];
// while (totalRemove < prerequisites.length) {
// int curRemove = 0;
// for (int i = 0; i < prerequisites.length; i++) {
// if (remove[i] == 1) {
// continue;
// }
// int[] pre = prerequisites[i];
// if (pointer[pre[0]] == 0) {
// pointer[pre[1]]--;
// remove[i] = 1;
// curRemove++;
// }
// }
// if (curRemove == 0) {
// return false;
// }
// totalRemove += curRemove;
// }
// return true;
// }
// }