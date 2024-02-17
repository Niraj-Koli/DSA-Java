/*
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take
 * course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to
 * first take course 1.
 * Return the ordering of courses you should take to finish all courses. If
 * there are many valid answers, return any of them. If it is impossible to
 * finish all courses, return an empty array.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] res = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            res[index++] = node;

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;

                if (indegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }

        if (index == numCourses) {
            return res;
        } else {
            return new int[] {};
        }
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };

        int[] ans = findOrder(numCourses, prerequisites);

        for (int answer : ans) {
            System.out.print(answer + " ");
        }
    }
}

// class Solution {
// private int top;

// public int[] findOrder(int numCourses, int[][] prerequisites) {
// top = numCourses - 1;

// int[] postList = new int[numCourses];
// int[] nextIndex = new int[prerequisites.length];
// int[] nextNode = new int[prerequisites.length];

// for (int i = 0; i < numCourses; i++) {
// postList[i] = -1;
// }

// int index = 0;
// for (int[] prerequisite : prerequisites) {
// nextIndex[index] = postList[prerequisite[1]];
// nextNode[index] = prerequisite[0];
// postList[prerequisite[1]] = index;
// index++;
// }

// int[] stack = new int[numCourses];
// int[] visited = new int[numCourses];

// for (int i = 0; i < numCourses; i++) {
// if (0 == visited[i]) {
// if (!DFS(i, visited, postList, nextIndex, nextNode, stack)) {
// return new int[0];
// }
// }
// }
// return stack;
// }

// private boolean DFS(int numCourses, int[] visited, int[] postList, int[]
// nextIndex, int[] nextNode, int[] stack) {
// visited[numCourses] = 1;
// for (int i = postList[numCourses]; i != -1; i = nextIndex[i]) {
// if (1 == visited[nextNode[i]]) {
// return false;
// }
// if (0 == visited[nextNode[i]]) {
// if (!DFS(nextNode[i], visited, postList, nextIndex, nextNode, stack)) {
// return false;
// }
// }
// }
// visited[numCourses] = 2;
// stack[top] = numCourses;
// top--;
// return true;
// }
// }