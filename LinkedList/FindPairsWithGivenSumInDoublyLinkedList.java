/*
 * Given a sorted doubly linked list of positive distinct elements, the task is
 * to find pairs in a doubly-linked list whose sum is equal to given value
 * target.
 */

import java.util.ArrayList;
import java.util.List;

public class FindPairsWithGivenSumInDoublyLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val, ListNode next, ListNode prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

        public ListNode(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public static ListNode convertArrayToDLL(int[] arr) {
        int n = arr.length;

        ListNode head = new ListNode(arr[0]);
        ListNode prevNode = head;

        for (int i = 1; i < n; i++) {
            ListNode temp = new ListNode(arr[i], null, prevNode);
            prevNode.next = temp;
            prevNode = temp;
        }

        return head;
    }

    public static void printDLL(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static List<List<Integer>> findPairsWithGivenSum(ListNode head, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (head == null) {
            return result;
        }

        ListNode left = head;
        ListNode right = head;

        while (right.next != null) {
            right = right.next;
        }

        while (left.val <= right.val) {
            if (left.val + right.val == target) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(left.val);
                pair.add(right.val);

                result.add(pair);

                left = left.next;
                right = right.prev;
            } else if (left.val + right.val < target) {
                left = left.next;
            } else if (left.val + right.val > target) {
                right = right.prev;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 6, 8, 9 };
        int target = 7;

        ListNode head = convertArrayToDLL(arr);

        printDLL(head);

        List<List<Integer>> answer = findPairsWithGivenSum(head, target);

        System.out.println(answer);
    }
}